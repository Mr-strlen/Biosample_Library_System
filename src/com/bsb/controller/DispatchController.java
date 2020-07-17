package com.bsb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dispatch")
public class DispatchController {
	
	@RequestMapping("/apply")
	public ModelAndView getApply(){
        ModelAndView mv = new ModelAndView("DispatchApply");
        return mv;
    }
	
}