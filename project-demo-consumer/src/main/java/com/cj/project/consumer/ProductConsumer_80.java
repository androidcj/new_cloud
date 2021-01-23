package com.cj.project.consumer;

import irule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 注册消费段
 */
@EnableFeignClients
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name="config-demo-provide",configuration = MyselfRule.class)
@EnableHystrix
public class ProductConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(ProductConsumer_80.class, args);
    }

}
