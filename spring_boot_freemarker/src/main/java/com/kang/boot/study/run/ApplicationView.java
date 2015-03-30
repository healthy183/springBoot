package com.kang.boot.study.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.kang.boot.study.pojo.Contact;


/*@Configuration
@ComponentScan("com.kang")
@EnableAutoConfiguration
@Controller
@EnableWebMvc*/
public class ApplicationView extends WebMvcConfigurerAdapter {

	 @RequestMapping(value = "/user", produces = { "application/json","application/xml" })
	    public @ResponseBody Contact findUser() {
	        return new Contact("张三", "男");
	    }
	    @RequestMapping(value = "/user", produces = { "text/html" })
	    public ModelAndView viewUser() {
	        return new ModelAndView("user", "user", findUser());
	    }
	
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		
		configurer.favorPathExtension(true);
        configurer.ignoreAcceptHeader(true);
        configurer.useJaf(false);
        configurer.defaultContentType(MediaType.TEXT_HTML);
        configurer.mediaType("html", MediaType.TEXT_HTML);
        configurer.mediaType("xml", MediaType.APPLICATION_XML);
        configurer.mediaType("json", MediaType.APPLICATION_JSON);
		
		
	}
	    
	    
	    
	public static void main(String[] args) {
		 SpringApplication.run(ApplicationView.class, args);
	}

}
