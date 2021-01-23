package com.pateo;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * webFlux生产消费者实例验证
 * @创建人 juncao
 * @创建时间 2019/12/18 18:41
 * @描述
 **/
public class EventBusDemo {
    @Subscribe
    public void sendMessage1(String message){
        System.out.println("订阅sendMessage1方法："+message);
    }

    @Subscribe
    public void sendMessage2(String message){
        System.out.println("订阅sendMessage2方法："+message);
    }

    public static void main(String[] args) {
        EventBus bus = new EventBus();
        bus.register(new EventBusDemo());
        bus.post("testMessage");
    }

}