package com.bsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsb.service.StockInService;
//import com.bsb.service.SampleInfoService;

@Controller
@RequestMapping("/StockIn")
public class StockInController {
	@Autowired
    private StockInService StockInService;
//	@Autowired
//	private SampleInfoService sampleinfoService;
	
	@RequestMapping("/StockIn_checking")
    public ModelAndView showappchecking(){
        ModelAndView mv = new ModelAndView("StockInAppChecking");
        mv.addObject("StockIn_checking",StockInService.ShowAppsum(Integer.valueOf("0")));
        return mv;
    }
	
	@RequestMapping("/StockIn_checked")
    public ModelAndView showappchecked(){
        ModelAndView mv = new ModelAndView("StockInAppChecked");
        mv.addObject("StockIn_checked",StockInService.ShowAppsum(Integer.valueOf("1")));
        return mv;
    }
	
	@RequestMapping("/StockIn_appdetail")
    public ModelAndView showappdetail(String id){
        ModelAndView mv = new ModelAndView("StockInAppdetail");
        mv.addObject("StockIn_appdetail",StockInService.ShowAppdetail(Integer.valueOf(id)));
        return mv;
    }
	
	@RequestMapping("/StockIn_record")
    public ModelAndView showrecord(){
        ModelAndView mv = new ModelAndView("StockInRecord");
        mv.addObject("StockIn_record",StockInService.ShowRecord());
        return mv;
    }
	
	@RequestMapping("/StockIn_check")
    public ModelAndView showcheck(String id){
        ModelAndView mv = new ModelAndView("StockInCheck");
        mv.addObject("StockIn_appdetail",StockInService.ShowAppdetail(Integer.valueOf(id)));
        String[] storage = {"1","2","3"};
//        storage[0]=sampleinfoService.GetUnusedNumByType("1");
//        storage[1]=sampleinfoService.GetUnusedNumByType("2");
//        storage[2]=sampleinfoService.GetUnusedNumByType("3");
        mv.addObject("StockIn_storagedetail",storage);
        for(String i:storage) {
        	System.out.println(i);
        }
        return mv;
    }
	
	@RequestMapping("/StockIn_checksubmit")
	public ModelAndView submitcheck(int id, String name, String reason,  String result) {
		System.out.println(id+" "+name+" "+result+" "+reason);
		String[] names = name.split(",");
		String[] results = result.split(",");
		String[] reasons = reason.split(",");
		for(int i = 0; i < names.length; i++) {
			
			StockInService.Appcheck(Integer.valueOf(id), names[i], results[i], reasons[i]);
		}
		return(new ModelAndView("redirect:StockIn_checking"));
	}
	
	@RequestMapping("/StockIn_recordsubmit")
	public ModelAndView submitrecord( int application_id,  String sample_id, String sample_name, String type) {
//		String position_id = sampleinfoService.GetUnusedPosition(type);
		int id = StockInService.GetNextRecordId();
//		StockInService.Recordsubmit(id, application_id, sample_id, sample_name, position_id);
		
		return(new ModelAndView("redirect:StockIn_record"));
	}
	
	@RequestMapping("/StockIn_findrecord")
    public ModelAndView findrecord(String sample_id){
		System.out.println(sample_id);
		ModelAndView mv = new ModelAndView("StockInRecord");
        mv.addObject("StockIn_record",StockInService.ShowRecordbySample_id(sample_id));
        return mv;
    }
	
	@RequestMapping("/StockIn_app")
    public ModelAndView app(){		
		ModelAndView mv = new ModelAndView("StockInAppsubmit");
        mv.addObject("StockIn_nextappid",StockInService.GetNextAppId());        
        return mv;
    }
	
	
	@RequestMapping("/StockIn_appsubmit")
    public ModelAndView submitapp(int id, String applicant, String name,String size,String condition){				
        StockInService.Appsubmit(id, applicant, name, size, condition);
        return(new ModelAndView("redirect:StockIn_app"));
    }
	
}
