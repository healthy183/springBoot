package spring.boot.first.web.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("spring.boot")
@SpringBootApplication
public class ApplicationRun extends SpringBootServletInitializer {

//public class ApplicationRun  {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationRun.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(ApplicationRun.class,args);
		//SpringApplication.run(ApplicationRun.class);
	}

}
