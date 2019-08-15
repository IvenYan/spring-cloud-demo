package com.ecommerce.spring.cloud.microservice.consumer.controller;

import com.ecommerce.spring.cloud.microservice.consumer.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/consumer/test1")
public class TestController1 {


    @Autowired
    private MsgProducer msgProducer;

    private static int no=1;

    @RequestMapping("/function1")
    public Object test1(){

        return "success";
    }

    @RequestMapping("/consumer1")
    public Object consumerMessage1(){
//        System.out.println(msgProducer);
        String consumer1 = msgProducer.getMsg("consumer1", 1000l);
        return consumer1;
    }

    @RequestMapping("/consumer2")
    public String consumerMessage2(){
//        System.out.println(msgProducer);
        String consumer2 =msgProducer.getMsg("consumer2",2000l);
        return consumer2;
    }

    @RequestMapping("/stop")
    public Object consumerMessageStop(){
//        System.out.println(msgProducer);
        String consumer1 = msgProducer.setConsumerStop();
        return consumer1;
    }


}
