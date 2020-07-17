package com.bsb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsb.service.DispatchService;

@Controller
@RequestMapping("/dispatch")
public class DispatchController {
	
	@Autowired
	private DispatchService dispatchService;
	
	//出库申请
	@RequestMapping("/apply")
	public ModelAndView getApply(){
        ModelAndView mv = new ModelAndView("DispatchApply");
        return mv;
    }
	// 待审核申请
	@RequestMapping("/app_checksum")
	public ModelAndView getCheckApp(){
        ModelAndView mv = new ModelAndView("DispatchAppCheckSum");
        mv.addObject("app_checksum",dispatchService.findAppByResult("待审核"));
        return mv;
    }
}