package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class HomeController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/home/index")
    String homeIndex() {

    	//LayoutDialect a;
    	
        return "home/index";
    }
    
   /* @RequestMapping("properties")
    @ResponseBody
    java.util.Properties properties() {
        return System.getProperties();
    }*/
}
