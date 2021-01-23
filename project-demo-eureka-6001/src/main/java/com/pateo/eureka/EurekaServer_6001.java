package com.pateo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 定义注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer_6001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_6001.class, args);
    }
}
