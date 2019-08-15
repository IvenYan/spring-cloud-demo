package com.ecommerce.spring.cloud.microservice.server;

import com.ecommerce.spring.cloud.microservice.server.producer.MsgProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ServerApplication
 * @Description MQ 服务的生产者
 * @Author IvenYan
 * @Date 2019/8/8 19:39
 * @Version 1.0
 **/
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class MicroserviceServerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceServerApplication.class,args);
//        RabbitTemplate rabbitTemplate=new RabbitTemplate();
//        MsgProducer msgProducer = new MsgProducer(rabbitTemplate);
//        for (int i = 0; i <10000 ; i++) {
//            msgProducer.sendMsg("消息1");
//        }
    }
}
