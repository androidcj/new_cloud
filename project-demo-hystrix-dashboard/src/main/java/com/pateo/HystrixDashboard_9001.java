package com.pateo;

//import com.pateo.entities.RedisUrls;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ApplicationContext;

import java.util.List;


@EnableHystrixDashboard //开启服务监控
@SpringBootApplication
public class HystrixDashboard_9001 {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(HystrixDashboard_9001.class, args);
//        Binder binder = Binder.get(context.getEnvironment());
//        List<String> redisUrls = binder.bind("redis.properties.urls", Bindable.listOf(String.class)).get();
//        System.out.println("redisUrl==="+redisUrls.size());
    }

}
