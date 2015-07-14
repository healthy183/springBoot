package spring.boot.Thymeleaf.first.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan("spring.boot")
@EnableAutoConfiguration
public class ApplicationView {

	
	public static void main(String[] args) {
		
		SpringApplication.run(ApplicationView.class, args);  
		
	}
}
