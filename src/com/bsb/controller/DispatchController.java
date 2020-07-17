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
	// 申请详情
	@RequestMapping("/app_detail")
	public ModelAndView getAppDetail(String type){
        ModelAndView mv = new ModelAndView("DispatchAppDetail");
        mv.addObject("app_detail",dispatchService.findAppDetailByOrder(type));
        return mv;
    }
	// 申请查询
	@RequestMapping("/app_select")
	public ModelAndView getSelectApp(String type, String word){
        ModelAndView mv = new ModelAndView("DispatchAppSelect");
        if(word == "") {
        	mv.addObject("app_select",dispatchService.findAllApp());
        }
        else {
        	if(type == null) {
				mv.addObject("app_select", dispatchService.findAllApp());
				return mv;
			}
			if(Integer.valueOf(type) == 1) {
				mv.addObject("app_select", dispatchService.findAppByOrder(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("app_select", dispatchService.findAppByApplicant(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("app_select", dispatchService.findAppByTime(word));
			}
			else if(Integer.valueOf(type) == 4) {
				mv.addObject("app_select", dispatchService.findAppByResult(word));
			}
			else if(Integer.valueOf(type) == 5) {
				mv.addObject("app_select", dispatchService.findAppByAuditor(word));
			}
        }
        return mv;
    }
	// 审核申请
	@RequestMapping("/app_checkdetail")
    public ModelAndView setCheckDetail(String type){
        ModelAndView mv = new ModelAndView("DispatchAppCheckDetail");
        mv.addObject("app_checkdetail",dispatchService.findAppDetailByOrder(type));
        return mv;
    }
}