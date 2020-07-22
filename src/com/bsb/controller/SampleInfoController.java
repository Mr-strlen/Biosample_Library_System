package com.bsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsb.service.SampleInfoService;

@Controller
@RequestMapping("/sampleinfo")
public class SampleInfoController {
	
	@Autowired
	private SampleInfoService sampleinfoService;
	
	
	@RequestMapping("/query")
	public ModelAndView SampleInfoRequest(String word, String type) {
		if(word == "") {
			ModelAndView mv = new ModelAndView("SampleInfo");
			mv.addObject("searchresult", sampleinfoService.getAllInfoTables());
			return(mv);
		}
		else {
			ModelAndView mv = new ModelAndView("SampleInfo");
			if(type == null) {
				mv.addObject("searchresult", sampleinfoService.getAllInfoTables());
				return mv;
			}
			if(Integer.valueOf(type) == 0) {
				mv.addObject("searchresult", sampleinfoService.getAllInfoTables());
			}
			else if(Integer.valueOf(type) == 1) {
				mv.addObject("searchresult", sampleinfoService.NameQueryTables(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("searchresult", sampleinfoService.TypeQueryTables(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("searchresult", sampleinfoService.AuditorQueryTables(word));
			}
			else if(Integer.valueOf(type) == 4) {
				mv.addObject("searchresult", sampleinfoService.SourceQueryTables(word));
			}
			else if(Integer.valueOf(type) == 5) {
				mv.addObject("searchresult", sampleinfoService.TimeQueryTables(word));
			}
			else if(Integer.valueOf(type) == 6) {
				mv.addObject("searchresult", sampleinfoService.PositionQueryTables(word));
			}
			else {
				mv.addObject("searchresult", sampleinfoService.getAllInfoTables());
			}
			return(mv);
		}
	}
	@RequestMapping("/statistics")
	public ModelAndView SampleInfoStatistics(String type) {
		ModelAndView mv = new ModelAndView("SampleStatistics");
		if(type == null) {
			mv.addObject("statistics", sampleinfoService.GroupByName());
			return mv;
		}
		if(Integer.valueOf(type) == 1) {
			mv.addObject("statistics", sampleinfoService.GroupByName());
		}
		else if(Integer.valueOf(type) == 2) {
			mv.addObject("statistics", sampleinfoService.GroupByType());
		}
		else if(Integer.valueOf(type) == 3) {
			mv.addObject("statistics", sampleinfoService.GroupByAuditor());
		}
		else if(Integer.valueOf(type) == 4) {
			mv.addObject("statistics", sampleinfoService.GroupBySource());
		}
		else {
			mv.addObject("statistics", sampleinfoService.GroupByName());
		}
		return(mv);
	}
}
