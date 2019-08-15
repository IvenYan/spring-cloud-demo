package com.ecommerce.spring.cloud.microservice.server.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName HashFunction
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/13 9:44
 * @Version 1.0
 **/
//@Configuration
//@Bean
public class HashFunction {

    public int user(String userName){
        int abs = Math.abs(userName.hashCode() % 1024);
        if(abs<=255 && 0<=abs){
            return 1;
        }
        if(abs<=512 && 256<=abs){
            return 2;
        }
        if(abs<=767 && 513<=abs){
            return 3;
        }
        if(abs<=1023 && 768<=abs){
            return 4;
        }
        return abs;
    }
}
