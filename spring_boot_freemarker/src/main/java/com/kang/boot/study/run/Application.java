package com.kang.boot.study.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;


@Configuration
@ComponentScan("com.kang")
@EnableAutoConfiguration
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	
	private static class CustomizedContainer implements EmbeddedServletContainerCustomizer {
	    @Override
	    public void customize(ConfigurableEmbeddedServletContainer container) {
	        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/test404.ftl"));
	       container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/testError.ftl"));
	    }
	}
	
}


