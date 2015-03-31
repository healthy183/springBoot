package org.springBoot.batch3.annotation.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("org.springBoot")
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(
				Application.class, args);

	}
		
}
