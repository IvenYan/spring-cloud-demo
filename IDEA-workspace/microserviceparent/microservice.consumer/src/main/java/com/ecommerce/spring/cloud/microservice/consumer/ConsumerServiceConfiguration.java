package com.ecommerce.spring.cloud.microservice.consumer;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ServerServiceConfiguration
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/12 10:52
 * @Version 1.0
 **/
@Configuration
@ExcludeFromComponentScan
public class ConsumerServiceConfiguration {

    //  @Autowired
    //  IClientConfig config;

    @Bean
    public IRule ribbonRule() {
//        高可用调用，测试是如果请求在一台上，就一直请求这一台
        return new BestAvailableRule();
//        轮询
//        return new RoundRobinRule();
//        随机
//        return new RandomRule();
    }
}
