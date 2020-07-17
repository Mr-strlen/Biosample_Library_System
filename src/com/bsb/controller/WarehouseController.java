package com.bsb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.bsb.service.WarehouseService;

@Controller
@RequestMapping("/warehouse")

public class WarehouseController {
	@Autowired
    private WarehouseService warehouseService;
	@RequestMapping("/store")
    public ModelAndView getCreat(){
        ModelAndView mv = new ModelAndView("WarehouseStore");
        return mv;
    }
	
	@RequestMapping("/store_submit") 
    public void creatNewCheck(String code, String name,String alter,String reason,int num, String time){
		warehouseService.SampleStore(code,name,alter,reason,num,time);
    }
}
