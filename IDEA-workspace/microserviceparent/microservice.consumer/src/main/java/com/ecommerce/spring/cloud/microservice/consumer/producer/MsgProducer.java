package com.ecommerce.spring.cloud.microservice.consumer.producer;

import com.ecommerce.spring.cloud.microservice.consumer.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ClassName component
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/12 12:39
 * @Version 1.0
 **/
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private static volatile boolean stop=false;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static Message message=null;

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    public void sendMsgWithExchange(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
//        rabbitTemplate.convert
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
    }

    public void sendMsgWithQueue(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.setQueue(RabbitConfig.QUEUE_A);
//        byte[] bytes = ;
        MessageProperties messageProperties=new MessageProperties();
        messageProperties.setAppId("11");
        message=new Message(content.getBytes(),messageProperties);
        rabbitTemplate.send(message);
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
    }

    public String getMsg(String flag,long restTime) {
//        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        Message receive = rabbitTemplate.receive(RabbitConfig.QUEUE_A);

        while(receive!=null&stop==false){

            byte[] body = receive.getBody();
            String msg = new String(body);
            System.out.println(flag+" ="+msg);
            try {
//                线程休息时间
                Thread.sleep(restTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            receive = rabbitTemplate.receive(RabbitConfig.QUEUE_A);

        }
        return flag+"= success";
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
    }

    public String setConsumerStop() {
        stop=true;
        logger.info("消费停止");
        return "= success";
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info(" 回调id:" + correlationData);
        if (ack) {
            logger.info("消息成功消费");
        } else {
            logger.info("消息消费失败:" + cause);
        }
    }
}
