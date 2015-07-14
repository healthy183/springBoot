package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {

	@RequestMapping("/")
	public String defaultHtml(){
		return  "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String indexHtml(){
		return  "index";
	}
	
}
