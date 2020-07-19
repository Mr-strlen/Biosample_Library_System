package com.bsb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bsb.service.WarehouseService;
import javax.swing.JOptionPane;

@Controller
@RequestMapping("/warehouse")

public class WarehouseController {
	@Autowired
    private WarehouseService warehouseService;

	@RequestMapping("/alterquery")
    public ModelAndView AlterQuery(){
        ModelAndView mv = new ModelAndView("WarehouseQuery");
        mv.addObject("alterquery",warehouseService.FindAlter());	
        return mv;
    }
	
	@RequestMapping("/alter_namequery")
    public ModelAndView Alter_NameQuery(String type){
        ModelAndView mv = new ModelAndView("WarehouseQuery");
        mv.addObject("alter_namequery",warehouseService.FindAlterByName(type));	
        return mv;
    }
	
	@RequestMapping("/controlquery")
    public ModelAndView ControlQuery(){
        ModelAndView mv = new ModelAndView("WarehouseQuery2");
        mv.addObject("controlquery",warehouseService.FindControl());	
        return mv;
    }
	
	@RequestMapping("/store")
    public ModelAndView getStore(){
        ModelAndView mv = new ModelAndView("WarehouseStore");
        return mv;
    }
	
	@RequestMapping("/store_submit") 
    public ModelAndView creatNewStore(String code, String name,String alter,String reason,int num, String time,RedirectAttributes attributes){
		warehouseService.SampleStore(code,name,alter,reason,num,time);
		ModelAndView mv = new ModelAndView("redirect:store2");
		attributes.addFlashAttribute("forfun1", name);
		attributes.addFlashAttribute("forfun2", time);
		attributes.addFlashAttribute("forfun3", num);
		return mv;
    }
	
	@RequestMapping("/store2")
    public ModelAndView getStore2(){
        ModelAndView mv = new ModelAndView("WarehouseStore2");
        return mv;
    }
	
	@RequestMapping("/store2_submit")
    public ModelAndView creatNewStore2(String name, int num, String con, String area, RedirectAttributes attributes){
		warehouseService.SampleStore2(name, num, con, area);
		ModelAndView mv = new ModelAndView("index");
		JOptionPane.showMessageDialog(null,"´æ´¢³É¹¦£¡");
        return mv;	
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
}
