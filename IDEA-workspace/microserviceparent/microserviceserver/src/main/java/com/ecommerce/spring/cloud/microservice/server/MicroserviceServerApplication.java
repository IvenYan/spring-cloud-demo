package com.ecommerce.spring.cloud.microservice.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ServerApplication
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/8 19:39
 * @Version 1.0
 **/
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class MicroserviceServerApplication {

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceServerApplication.class,args);
    }
}
