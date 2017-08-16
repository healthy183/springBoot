package com.kang.boot.web.controller;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/16.
 * @Author Healthy
 * @Version
 */
@RestController
@Slf4j
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World! I am healthy183.";
    }


    @RequestMapping("/healthyCheck")
    public String healthyCheck() {
        String result = "";
        try(BufferedInputStream  inputStream = new BufferedInputStream(HelloController.class.getResourceAsStream("/healthcheck.htm"))){
            StringBuilder sb = new StringBuilder();
            byte[] line = new byte[2048];
            while (inputStream.read(line) != -1) {
                sb.append(new String(line));
            }
            result = sb.toString();
        }catch(Exception e){
            log.info(Throwables.getStackTraceAsString(e));
        }
        return result;
    }
}
