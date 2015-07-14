package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/html5")
public class HtmlController {
	
	@RequestMapping(value="{pageUrl}/{pageName}")//,method={RequestMethod.POST}
	public String showHtml(@PathVariable String pageUrl,@PathVariable String pageName){
		return  pageUrl+"/"+pageName;
	}
	
	
}
