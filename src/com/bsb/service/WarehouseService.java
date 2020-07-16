package com.bsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/warehouse")

public class WarehouseService {
	@RequestMapping("/store")
    public ModelAndView getCreat(){
        ModelAndView mv = new ModelAndView("Warehousestore");
        return mv;
    }
	
	@RequestMapping("/state")
    public ModelAndView getCheck(){
        ModelAndView mv = new ModelAndView("CheckIndex");
        return mv;
    }
}
