package com.bsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.bsb.service.WarehouseService;
//import com.bsb.service.SampleInfoService;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
//	@Autowired
//    private WarehouseService warehouseService;
//	@Autowired
//	private SampleInfoService sampleinfoService;
	
	@RequestMapping("/warehouse_checking")
    public ModelAndView showappchecking(){
        ModelAndView mv = new ModelAndView("WarehouseAppChecking");
//        mv.addObject("warehouse_checking",warehouseService.ShowAppsum(Integer.valueOf("0")));
        return mv;
    }
	
//	@RequestMapping("/warehouse_checked")
//    public ModelAndView showappchecked(){
//        ModelAndView mv = new ModelAndView("WarehouseAppChecked");
//        mv.addObject("warehouse_checked",warehouseService.ShowAppsum(Integer.valueOf("1")));
//        return mv;
//    }
//	
//	@RequestMapping("/warehouse_appdetail")
//    public ModelAndView showappdetail(String id){
//        ModelAndView mv = new ModelAndView("WarehouseAppdetail");
//        mv.addObject("warehouse_appdetail",warehouseService.ShowAppdetail(Integer.valueOf(id)));
//        return mv;
//    }
//	
//	@RequestMapping("/warehouse_record")
//    public ModelAndView showrecord(){
//        ModelAndView mv = new ModelAndView("WarehouseRecord");
//        mv.addObject("warehouse_record",warehouseService.ShowRecord());
//        return mv;
//    }
//	
//	@RequestMapping("/warehouse_check")
//    public ModelAndView showcheck(String id){
//        ModelAndView mv = new ModelAndView("WarehouseCheck");
//        mv.addObject("warehouse_appdetail",warehouseService.ShowAppdetail(Integer.valueOf(id)));
//        String[] storage = {"1","2","3"};
//        storage[0]=sampleinfoService.GetUnusedNumByType("1");
//        storage[1]=sampleinfoService.GetUnusedNumByType("2");
//        storage[2]=sampleinfoService.GetUnusedNumByType("3");
//        mv.addObject("warehouse_storagedetail",storage);
//        for(String i:storage) {
//        	System.out.println(i);
//        }
//        return mv;
//    }
//	
//	@RequestMapping("/warehouse_checksubmit")
//	public ModelAndView submitcheck(int id, String name, String reason,  String result) {
//		System.out.println(id+" "+name+" "+result+" "+reason);
//		String[] names = name.split(",");
//		String[] results = result.split(",");
//		String[] reasons = reason.split(",");
//		for(int i = 0; i < names.length; i++) {
//			
//			warehouseService.Appcheck(Integer.valueOf(id), names[i], results[i], reasons[i]);
//		}
//		return(new ModelAndView("redirect:warehouse_checking"));
//	}
//	
//	@RequestMapping("/warehouse_recordsubmit")
//	public ModelAndView submitrecord( int application_id,  String sample_id, String sample_name, String type) {
//		String position_id = sampleinfoService.GetUnusedPosition(type);
//		int id = warehouseService.GetNextRecordId();
//		warehouseService.Recordsubmit(id, application_id, sample_id, sample_name, position_id);
//		
//		return(new ModelAndView("redirect:warehouse_record"));
//	}
//	
//	@RequestMapping("/warehouse_findrecord")
//    public ModelAndView findrecord(String sample_id){
//		System.out.println(sample_id);
//		ModelAndView mv = new ModelAndView("WarehouseRecord");
//        mv.addObject("warehouse_record",warehouseService.ShowRecordbySample_id(sample_id));
//        return mv;
//    }
//	
//	@RequestMapping("/warehouse_app")
//    public ModelAndView app(){		
//		ModelAndView mv = new ModelAndView("WarehouseAppsubmit");
//        mv.addObject("warehouse_nextappid",warehouseService.GetNextAppId());        
//        return mv;
//    }
//	
//	
//	@RequestMapping("/warehouse_appsubmit")
//    public ModelAndView submitapp(int id, String applicant, String name,String size,String condition){				
//        warehouseService.Appsubmit(id, applicant, name, size, condition);
//        return(new ModelAndView("redirect:warehouse_app"));
//    }
	
}
