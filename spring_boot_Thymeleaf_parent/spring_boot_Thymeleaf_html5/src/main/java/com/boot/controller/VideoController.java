package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@Controller
//@RequestMapping("/video")
public class VideoController {

	//@RequestMapping("/playVideo")
	public String playVideo(){
		//ThymeleafViewResolver t;
		return "video/playVideo";
	}
	
}
