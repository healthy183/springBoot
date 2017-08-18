package com.kang.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/16.
 * @Author Healthy
 * @Version
 */
@SpringBootApplication
//@MapperScan(basePackages = {"com.lizikj.member.dao.mapper"})
@ComponentScan(basePackages = {"com.kang.boot"})
@ImportResource({"classpath:application-dao.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
