package com.pateo.jms.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @创建人 juncao
 * @创建时间 2019/12/18 15:01
 * @描述
 **/
public class JmsListener {

    @KafkaListener(topics = "my_test_topic")   //监听同一个主题
    public void receive(ConsumerRecord<?, ?> consumer) {
        System.out.println("topic名称:" + consumer.topic() + ",key:" + consumer.key() + ",分区位置:" + consumer.partition()
                + ", 下标" + consumer.offset());
       String value =  consumer.value().toString();
       System.out.println("value==="+value);
    }

}