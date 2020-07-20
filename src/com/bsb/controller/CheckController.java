package com.bsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bsb.model.CheckSampleTable;
import com.bsb.service.CheckService;

@Controller
@RequestMapping("/check")

public class CheckController {
	@Autowired
    private CheckService checkService;
	
	@RequestMapping("/index")
    public ModelAndView getCheck(){
        ModelAndView mv = new ModelAndView("CheckIndex");
        mv.addObject("check",checkService.findCheck());
        return mv;
    }
	
	@RequestMapping("/findbyid")
    public ModelAndView getCheckbyid(String id){
        if(id == "") {
        	ModelAndView mv = new ModelAndView("CheckQuery");
            mv.addObject("check",checkService.findAllCheckSample());
            return mv;
        }
		ModelAndView mv = new ModelAndView("CheckQuery");
        mv.addObject("check",checkService.findSamplebyid(Integer.valueOf(id)));
        return mv;
    }
	
	@RequestMapping("/creat")
    public ModelAndView getCreat(){
        ModelAndView mv = new ModelAndView("CheckCreat");
        return mv;
    }
	
	@RequestMapping("/creat_submit") 
    public ModelAndView creatNewCheck(String check_id, String check_ctt, String check_wh, String check_ct, String check_dp, RedirectAttributes attributes){
		checkService.creatCheck(check_id, check_ctt,check_wh,check_ct,check_dp);
		ModelAndView mv = new ModelAndView("redirect:creat2");
		attributes.addFlashAttribute("forfun", check_id);
        return mv;
    }
	
	@RequestMapping("/creat2")
    public ModelAndView getCreat2(){
        ModelAndView mv = new ModelAndView("CheckCreat2");
        return mv;
    }
	
	@RequestMapping("/sample_submit")
    public ModelAndView creatNewSample(String type, String sample_id, String position_id, String check_id, RedirectAttributes attributes){
		if(type.equals("next")) {
			checkService.creatSample(sample_id,position_id,check_id);
			ModelAndView mv = new ModelAndView("redirect:creat2");
			attributes.addFlashAttribute("forfun", check_id);
			return mv;
		}
		else if(type.equals("quit")) {
			checkService.creatSample(sample_id,position_id,check_id);
			ModelAndView mv = new ModelAndView("redirect:show");
			attributes.addAttribute("forfun", check_id);
			attributes.addFlashAttribute("forsure", check_id);
			return mv;
		}
		ModelAndView mv = new ModelAndView("CheckCreat");
        return mv;	
    }
	
	@RequestMapping("/show")
    public ModelAndView getCheckShow(String type, String forfun){
        if(forfun == "") {
        	ModelAndView mv = new ModelAndView("CheckShow");
            mv.addObject("check",checkService.findAllCheckSample());
            return mv;
        }
		ModelAndView mv = new ModelAndView("CheckShow");
		List<CheckSampleTable> list = checkService.findSamplebyid(Integer.valueOf(forfun));
		for(CheckSampleTable i : list) {
			String state = checkService.findSampleStatebyPosition(i.getposition_id());
			if(state.equals("0")) {
				i.setstate("不通过");
				checkService.setSampleState(i.getposition_id(),"不通过");
			}
			else {
				String sample = checkService.findSampleIdbyPosition(i.getposition_id());
				if(sample.equals(i.getsample_id())) {
					i.setstate("通过");
					checkService.setSampleState(i.getposition_id(),"通过");
				}
				else {
					i.setstate("不通过");
					checkService.setSampleState(i.getposition_id(),"不通过");
				}
			}
		}
		checkService.setCheckState(forfun);
        mv.addObject("check", list);
        if(type != null && type.equals("exit")) {
        	return new ModelAndView("redirect:index");
        }
        return mv;
    }
	
	@RequestMapping("/comp_submit")
    public ModelAndView creatNewComp(String type,String check_id,RedirectAttributes attributes){
		if(type.equals("start")) {
			checkService.creatComp(check_id);
			ModelAndView mv = new ModelAndView("redirect:comp");
			attributes.addFlashAttribute("forfin", check_id);
			return mv;
		}
		else if(type.equals("quit")) {
			ModelAndView mv = new ModelAndView("redirect:creat");
			return mv;
		}
		ModelAndView mv = new ModelAndView("CheckCreat");
        return mv;	
    }
	
	@RequestMapping("/comp")
    public ModelAndView getComp(){
        ModelAndView mv = new ModelAndView("CheckComp");
        return mv;
    }
}
