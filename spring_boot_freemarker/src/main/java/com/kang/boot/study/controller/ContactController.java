package com.kang.boot.study.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kang.boot.study.pojo.Contact;

@Controller
public class ContactController {

	@RequestMapping("/contact")
	public @ResponseBody List<Contact> contactJSON() {
		
		System.out.println("ac");
		
		System.out.println("b");
		
		System.out.println("c");
		
		System.out.println("d");
		
		return Arrays.asList(new Contact("wkx", "wfh!"), new Contact(
				"李四", "wfg"));

	}
	
	@RequestMapping("/contact.html")
	public ModelAndView contactHTML() {
	
		List<Contact> contacts =	Arrays.asList(new Contact("张三", "13312341234"), new Contact(
				"李四sss", "13945672345"));
		
		return new ModelAndView("contact", "contactList", contacts);
	}
	
	 @RequestMapping("/404.ftl")
	    public String _404() {
	        return "404";
	    }
	    @RequestMapping("/error500")
	    public String _500() throws Exception {
	        throw new Exception();
	    }
	    
	   /* @RequestMapping("/error")
	    public String error() throws Exception {
	        return  "testError";
	    }*/
	    
	    @RequestMapping("/error.html")
	    public String errorHtml() throws Exception {
	        return  "testError";
	    }
	
}
