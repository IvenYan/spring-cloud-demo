package com.ecommerce.spring.cloud.microservice.eureka;

//import com.netflix.hystrix.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName MainApplication
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/7 19:33
 * @Version 1.0
 **/
@EnableEurekaServer
@SpringBootApplication
//@EnableCircuitBreaker
public class MicroserviceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaApplication.class, args);
    }

//    @Component
//    public class StoreIntegration {
//
//        /*@HystrixCommand(fallbackMethod = "defaultStores")
//        public Object getStores(Map<String, Object> parameters) {
//            //do stuff that might fail
//            return null;
//        }*/
//
//        public Object defaultStores(Map<String, Object> parameters) {
////            return /* something useful */;
//            return "success";
//        }
//    }

}
