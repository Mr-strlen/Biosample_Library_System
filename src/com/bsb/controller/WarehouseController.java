package com.bsb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bsb.service.WarehouseService;

@Controller
@RequestMapping("/warehouse")

public class WarehouseController {
	@Autowired
    private WarehouseService warehouseService;
	
	@RequestMapping("/query")
    public ModelAndView AlterQuery(){
        ModelAndView mv = new ModelAndView("WarehouseQuery");
        mv.addObject("warehouse",warehouseService.FindAlter());
        return mv;
    }
	
	@RequestMapping("/store")
    public ModelAndView getStore(){
        ModelAndView mv = new ModelAndView("WarehouseStore");
        return mv;
    }
	
	@RequestMapping("/store_submit") 
    public void creatNewStore(String code, String name,String alter,String reason,int num, String time,RedirectAttributes attributes){
		warehouseService.SampleStore(code,name,alter,reason,num,time);
		ModelAndView mv = new ModelAndView("redirect:store2");
		attributes.addFlashAttribute("forfun1", code);
		attributes.addFlashAttribute("forfun2", name);
    }
	
	@RequestMapping("/store2")
    public ModelAndView getStore2(){
        ModelAndView mv = new ModelAndView("WarehouseStore2");
        return mv;
    }
}
