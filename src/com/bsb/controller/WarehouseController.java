package com.bsb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bsb.service.DispatchService;
import com.bsb.service.StockInService;
import com.bsb.service.WarehouseService;
import javax.swing.JOptionPane;

@Controller
@RequestMapping("/warehouse")

public class WarehouseController {
	@Autowired
    private WarehouseService warehouseService;
	@Autowired
    private StockInService StockInService;
	@Autowired
    private DispatchService dispatchService;

	@RequestMapping("/alterquery")
    public ModelAndView AlterQuery(){
        ModelAndView mv = new ModelAndView("WarehouseQuery");
        mv.addObject("alterquery",warehouseService.FindAlter());	
        return mv;
    }
	
	@RequestMapping("/alter_namequery")
    public ModelAndView Alter_NameQuery(String type){
        ModelAndView mv = new ModelAndView("Warehouse_AlterQuery");
        mv.addObject("alter_namequery",warehouseService.FindAlterByName(type));	
        return mv;
    }
	
	@RequestMapping("/controlquery")
    public ModelAndView ControlQuery(String type, String word){
        ModelAndView mv = new ModelAndView("WarehouseQuery2");
        if(word == "") {
        	mv.addObject("controlquery",warehouseService.FindControl());
        }
        else {
        	if(type == null) {
        		mv.addObject("controlquery",warehouseService.FindControl());
				return mv;
			}
			if(Integer.valueOf(type) == 1) {
				mv.addObject("controlquery", warehouseService.findControlByName(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("controlquery", warehouseService.findControlByCondition(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("controlquery", warehouseService.findControlByArea(word));
			}
			else if(Integer.valueOf(type) == 4) {
				mv.addObject("controlquery", warehouseService.findControlByTime(word));
			}
        }	
        return mv;
    }
	
	@RequestMapping("/ready")
    public ModelAndView getReady(){
        ModelAndView mv = new ModelAndView("WarehouseReady");
        mv.addObject("stockin_record",StockInService.ShowRecord());
        mv.addObject("record_select",dispatchService.findAllRecord());
        return mv;
    }
	
	@RequestMapping("/readytohandle")
    public ModelAndView ReadytoHandle(){
        ModelAndView mv = new ModelAndView("WarehouseReady");
        mv.addObject("stockin_record",StockInService.ShowReadyRecord());
        mv.addObject("record_select",dispatchService.findRecordByState("´ýÍê³É"));
        return mv;
    }
	
	@RequestMapping("/store")
    public ModelAndView getStore(RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("WarehouseStore");
        return mv;
    }
	
	@RequestMapping("/store_submit") 
    public ModelAndView creatNewStore(String name,String alter,String reason,String operator,int num, String time,RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:store2");
		int anum = warehouseService.getAlterNum();
		anum = anum + 1;
		String code = "AN" + String.valueOf(anum);
		attributes.addFlashAttribute("forfun", code);
		warehouseService.SampleStore(code,name,alter,reason,operator,num,time);
		attributes.addFlashAttribute("forfun1", name);
		attributes.addFlashAttribute("forfun2", time);
		attributes.addFlashAttribute("forfun3", num);
		return mv;
    }
	
	@RequestMapping("/changewarehouse")
    public ModelAndView changeWarehouse(){
        ModelAndView mv = new ModelAndView("Warehousetotal_Alter");
        return mv;
    }
	
	@RequestMapping("/changewarehouse_submit")
    public ModelAndView changeWarehouse_Submit(String warehouse,int normal,int refrigerate,int freeze){
		warehouseService.setWarehousetotal(warehouse, normal, refrigerate, freeze);
		ModelAndView mv = new ModelAndView("redirect:areastate");	
        return mv;
    }
	
	@RequestMapping("/store2")
    public ModelAndView getStore2(){
        ModelAndView mv = new ModelAndView("WarehouseStore2");
        return mv;
    }
	
	@RequestMapping("/store2_submit")
    public ModelAndView creatNewStore2(String name, int num, String con, String area, String time, String note, RedirectAttributes attributes){
		warehouseService.SampleStore2(name, num, con, area, time, note);
		ModelAndView mv = new ModelAndView("redirect:store_success");
        return mv;	
    }
	
	@RequestMapping("/store_success")
	public ModelAndView applysuccess()
	{
		return new ModelAndView("WarehouseStoreSuccess");
	}
	
	@RequestMapping("/areastate")
    public ModelAndView AreaState(){
        ModelAndView mv = new ModelAndView("WarehouseState_area");
        mv.addObject("areastate",warehouseService.FindState());	
        return mv;
    }
	
	@RequestMapping("/conditionstate")
    public ModelAndView ConditionState(){
        ModelAndView mv = new ModelAndView("WarehouseState_condition");
        mv.addObject("conditionstate",warehouseService.FindState2());	
        return mv;
    }
	
	@RequestMapping("/congestioncontrol")
    public ModelAndView CongestionControl(){
        ModelAndView mv = new ModelAndView("WarehouseCongestion_area");
        mv.addObject("areastate",warehouseService.congestioncontrol());	
        return mv;
    }
	
	@RequestMapping("/congestioncontrol2")
    public ModelAndView CongestionControl2(){
        ModelAndView mv = new ModelAndView("WarehouseCongestion_detail");
        mv.addObject("conditionstate",warehouseService.congestioncontrol2());	
        return mv;
    }
}
