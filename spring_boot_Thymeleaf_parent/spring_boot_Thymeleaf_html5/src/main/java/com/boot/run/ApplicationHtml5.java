package com.boot.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@ComponentScan("com.boot")
@SpringBootApplication
public class ApplicationHtml5 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationHtml5.class);
    }
}

/*@Bean
public ViewResolver thymeleafViewResolver() {
    ThymeleafViewResolver vr = new ThymeleafViewResolver();
    vr.setTemplateEngine(templateEngine());
    vr.setCharacterEncoding("UTF-8");
    vr.setOrder(Ordered.HIGHEST_PRECEDENCE);
    // all message/* views will not be handled by this resolver as they are Tiles views
    vr.setExcludedViewNames(new String[]{"message/*"});
    return vr;
}*/
