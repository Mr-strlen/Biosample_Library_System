package com.bsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sampleinfo")

public class SampleInfoController {
	@RequestMapping("/query")
	public ModelAndView SampleInfoRequest(String word, String type) {
		if(word == "") {
			ModelAndView mv = new ModelAndView("SampleInfo");
			return(mv);
		}
	}
}
