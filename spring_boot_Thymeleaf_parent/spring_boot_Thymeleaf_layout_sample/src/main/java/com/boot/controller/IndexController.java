package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@ModelAttribute(value="page")
	public String getPage(){
		return "home";
	}
	
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ModelAndView index(){
		
		ModelAndView mv = new  ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String defaultReq(){
		return "redirect:/index";
	}

	@RequestMapping(value="template",method=RequestMethod.GET)
	public ModelAndView template(){
		
		ModelAndView mv = new  ModelAndView();
		mv.setViewName("layout/template");
		return mv;
	}
	
	
}
