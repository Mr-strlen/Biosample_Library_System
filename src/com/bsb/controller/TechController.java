package com.bsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bsb.service.TechService;

@Controller
@RequestMapping("/tech")
public class TechController {
	@Autowired
    private TechService techservice;
	
	@RequestMapping("/all")
    public ModelAndView getallOperationMethod(){
        ModelAndView mv = new ModelAndView("techOperationMethod");
        mv.addObject("method",techservice.findAllOperationMethod());
        mv.addObject("app",techservice.ShowAllApp());
        return mv;
    }
	
	@RequestMapping("/findby")
    public ModelAndView getBooksbyno(String type,String operation_class){
        
        if(type == "") {
            if(operation_class == "") {
            	ModelAndView mv = new ModelAndView("techOperationMethod");
            	mv.addObject("app",techservice.ShowAllApp());
                mv.addObject("method",techservice.findAllOperationMethod());
                return mv;
            }
    		ModelAndView mv = new ModelAndView("techOperationMethod");
    		mv.addObject("app",techservice.ShowAllApp());
            mv.addObject("method",techservice.findOperationMethodbyclass(operation_class));
            return mv;
        }
        if(operation_class == "") {
        	ModelAndView mv = new ModelAndView("techOperationMethod");
        	mv.addObject("app",techservice.ShowAllApp());
            mv.addObject("method",techservice.findOperationMethodbytype(type));
            return mv;
        }
		ModelAndView mv = new ModelAndView("techOperationMethod");
		mv.addObject("app",techservice.ShowAllApp());
        mv.addObject("method",techservice.findOperationMethodbyboth(type,operation_class));
        return mv;  
    }
	@RequestMapping("/change")
    public ModelAndView changeallOperationMethod(){
        ModelAndView mv = new ModelAndView("techChangeMethod");
        mv.addObject("app",techservice.ShowAllApp());
        mv.addObject("method",techservice.findAllOperationMethod());
        return mv;
    }	
	@RequestMapping("/changesearch")
    public ModelAndView getChangeOperationMethod(String type, String operation_class){
        if(type == "") {
            if(operation_class == "") {
            	ModelAndView mv = new ModelAndView("techChangeMethod");
            	mv.addObject("app",techservice.ShowAllApp());
                mv.addObject("method",techservice.findAllOperationMethod());
                return mv;
            }
    		ModelAndView mv = new ModelAndView("techChangeMethod");
    		mv.addObject("app",techservice.ShowAllApp());
            mv.addObject("method",techservice.findOperationMethodbyclass(operation_class));
            return mv;
        }
        if(operation_class == "") {
        	ModelAndView mv = new ModelAndView("techChangeMethod");
        	mv.addObject("app",techservice.ShowAllApp());
            mv.addObject("method",techservice.findOperationMethodbytype(type));
            return mv;
        }
		ModelAndView mv = new ModelAndView("techChangeMethod");
		mv.addObject("app",techservice.ShowAllApp());
        mv.addObject("method",techservice.findOperationMethodbyboth(type,operation_class));
        return mv;  
    }	

	@RequestMapping("/changemethod")
    public ModelAndView changeOperationMethod(String type,String operation_class,String method, String findtype,
			String findoperation_class, String findmethod,String state){
		if(Integer.valueOf(state)==1)
		{
			if(type=="")
				type=findtype;
			if(operation_class=="")
				operation_class=findoperation_class;
			if(method=="")
				method=findmethod;
			techservice.changeOperationMethod(type, operation_class, method, findtype,
					findoperation_class);
			return(new ModelAndView("redirect:change"));
		}
		else if(Integer.valueOf(state)==0)
		{
			techservice.deleteMethod(findtype,findoperation_class);
			return(new ModelAndView("redirect:change"));
		}
		else
			return(new ModelAndView("redirect:change"));

		/*ModelAndView mv = new ModelAndView("changeMethod");
		if(searchtype == "") {
            if(searchoperation_class == "") {
                mv.addObject("method",techservice.findAllOperationMethod());
                return mv;
            }
            mv.addObject("method",techservice.findOperationMethodbyclass(searchoperation_class));
            return mv;
        }
        if(searchoperation_class == "") {
            mv.addObject("searchmethod",techservice.findOperationMethodbytype(searchtype));
            return mv;
        }
        mv.addObject("method",techservice.findOperationMethodbyboth(searchtype,searchoperation_class));
        return mv;  */
	}
	
	
	
	
	@RequestMapping("/check")
    public ModelAndView getallRequest(){
        ModelAndView mv = new ModelAndView("techSuggestion");
        mv.addObject("app",techservice.ShowAllApp());
        return mv;
    }
	
	@RequestMapping("/submitsuggestion")
	public  ModelAndView submitSuggestion(String id,String suggestion,String name){
		System.out.println(id+suggestion+name);
		techservice.checkApp(Integer.valueOf(id),suggestion,name);
        //ModelAndView mv = new ModelAndView("techSuggestion");
        //mv.addObject("method",techservice.ShowAllApp());
        return (new ModelAndView("redirect:check")); 
	}
	@RequestMapping("/addMethod")
	public  ModelAndView addMethod(String type,String operation_class,String method){
		{
			techservice.addMethod(type,operation_class,method);
	        return (new ModelAndView("redirect:change")); 
		}
	}
}