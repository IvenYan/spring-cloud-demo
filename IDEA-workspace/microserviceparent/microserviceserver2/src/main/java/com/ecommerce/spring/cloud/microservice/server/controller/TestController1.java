package com.ecommerce.spring.cloud.microservice.server.controller;

import com.ecommerce.spring.cloud.microservice.server.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MsgProducer msgProducer;

    private static int no=1;

    @RequestMapping("/function1")
    public Object test1(){

        return "success";
    }

    @RequestMapping("/queue")
    public Object test2(){
//        System.out.println(msgProducer);
        while(no<100000){
            msgProducer.sendMsgWithQueue("suibian+ queue"+no++);
        }
        return "success";
    }

    @RequestMapping("/exchange")
    public Object test3(){
        msgProducer.sendMsgWithExchange("suibian+ exchange"+no++);
        return "success";
    }

    @RequestMapping("/consumer")
    public Object consumerMessage(){
        String msg = msgProducer.getMsg("consumer");
        return msg;
    }
}
