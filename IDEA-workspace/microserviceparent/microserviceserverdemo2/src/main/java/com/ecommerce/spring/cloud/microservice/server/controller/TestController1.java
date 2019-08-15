package com.ecommerce.spring.cloud.microservice.server.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController1
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/8 19:40
 * @Version 1.0
 **/
@RestController
@RequestMapping("/server/test1")
public class TestController1 {

    @RequestMapping("/function1")
    public String test1(){

        return "success";
    }
}
