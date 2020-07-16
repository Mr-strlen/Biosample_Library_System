package com.bsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.bsb.service.stockinService;
//import com.bsb.service.SampleInfoService;

@Controller
@RequestMapping("/stockin")
public class StockInController {
//	@Autowired
//    private stockinService stockinService;
//	@Autowired
//	private SampleInfoService sampleinfoService;
	
	@RequestMapping("/stockin_checking")
    public ModelAndView showappchecking(){
        ModelAndView mv = new ModelAndView("StockInAppChecking");
//        mv.addObject("stockin_checking",stockinService.ShowAppsum(Integer.valueOf("0")));
        return mv;
    }
	
	@RequestMapping("/stockin_checked")
    public ModelAndView showappchecked(){
        ModelAndView mv = new ModelAndView("StockInAppChecked");
//        mv.addObject("stockin_checked",stockinService.ShowAppsum(Integer.valueOf("1")));
        return mv;
    }
	
	@RequestMapping("/stockin_appdetail")
    public ModelAndView showappdetail(String id){
        ModelAndView mv = new ModelAndView("StockInAppdetail");
//        mv.addObject("stockin_appdetail",stockinService.ShowAppdetail(Integer.valueOf(id)));
        return mv;
    }
	
	@RequestMapping("/stockin_record")
    public ModelAndView showrecord(){
        ModelAndView mv = new ModelAndView("StockInRecord");
//        mv.addObject("stockin_record",stockinService.ShowRecord());
        return mv;
    }
	
	@RequestMapping("/stockin_check")
    public ModelAndView showcheck(String id){
        ModelAndView mv = new ModelAndView("StockInCheck");
//        mv.addObject("stockin_appdetail",stockinService.ShowAppdetail(Integer.valueOf(id)));
        String[] storage = {"1","2","3"};
//        storage[0]=sampleinfoService.GetUnusedNumByType("1");
//        storage[1]=sampleinfoService.GetUnusedNumByType("2");
//        storage[2]=sampleinfoService.GetUnusedNumByType("3");
        mv.addObject("stockin_storagedetail",storage);
        for(String i:storage) {
        	System.out.println(i);
        }
        return mv;
    }
	
	@RequestMapping("/stockin_checksubmit")
	public ModelAndView submitcheck(int id, String name, String reason,  String result) {
		System.out.println(id+" "+name+" "+result+" "+reason);
		String[] names = name.split(",");
		String[] results = result.split(",");
		String[] reasons = reason.split(",");
		for(int i = 0; i < names.length; i++) {
			
//			stockinService.Appcheck(Integer.valueOf(id), names[i], results[i], reasons[i]);
		}
		return(new ModelAndView("redirect:stockin_checking"));
	}
	
	@RequestMapping("/stockin_recordsubmit")
	public ModelAndView submitrecord( int application_id,  String sample_id, String sample_name, String type) {
//		String position_id = sampleinfoService.GetUnusedPosition(type);
//		int id = stockinService.GetNextRecordId();
//		stockinService.Recordsubmit(id, application_id, sample_id, sample_name, position_id);
		
		return(new ModelAndView("redirect:stockin_record"));
	}
	
	@RequestMapping("/stockin_findrecord")
    public ModelAndView findrecord(String sample_id){
		System.out.println(sample_id);
		ModelAndView mv = new ModelAndView("StockInRecord");
//        mv.addObject("stockin_record",stockinService.ShowRecordbySample_id(sample_id));
        return mv;
    }
	
	@RequestMapping("/stockin_app")
    public ModelAndView app(){		
		ModelAndView mv = new ModelAndView("StockInAppsubmit");
//        mv.addObject("stockin_nextappid",stockinService.GetNextAppId());        
        return mv;
    }
	
	
	@RequestMapping("/stockin_appsubmit")
    public ModelAndView submitapp(int id, String applicant, String name,String size,String condition){				
//        stockinService.Appsubmit(id, applicant, name, size, condition);
        return(new ModelAndView("redirect:stockin_app"));
    }
	
}
