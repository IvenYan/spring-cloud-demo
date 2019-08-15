package com.ecommerce.spring.cloud.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName MainApplication
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/7 19:33
 * @Version 1.0
 **/
//@EnableEurekaServer
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApiGatewayApplication.class, args);
    }

}
