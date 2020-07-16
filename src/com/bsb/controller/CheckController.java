package com.bsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/check")

public class CheckController {
	@RequestMapping("/creat")
    public ModelAndView getCreat(){
        ModelAndView mv = new ModelAndView("CheckCreat2");
        return mv;
	}
}
