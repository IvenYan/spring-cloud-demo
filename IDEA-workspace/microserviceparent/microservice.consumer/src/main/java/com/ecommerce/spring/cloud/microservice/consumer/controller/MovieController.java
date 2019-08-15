package com.ecommerce.spring.cloud.microservice.consumer.controller;

//import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName MovieController
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/12 10:15
 * @Version 1.0
 **/
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumer/id")
    public String findByid(){
        Object forObject = this.restTemplate.getForObject("http://server-service/server/test1/function1", String.class);
        return forObject.toString();
    }

//    测试自己写的ribbon
    @GetMapping("/selfribbon")
    public String findByidWithSelfRibbon(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("server-service");
        String str="111 =="+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId();

        ServiceInstance serviceInstanceDemo = this.loadBalancerClient.choose("server-service-demo");
        String str1="111 =="+serviceInstanceDemo.getHost()+":"+serviceInstanceDemo.getPort()+":"+serviceInstanceDemo.getServiceId();

        System.out.println(str+";"+str1);
        return str+";"+str1;
    }

}
