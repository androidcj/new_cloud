package com.pateo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @创建人 juncao
 * @创建时间 2019/12/16 10:52
 * @描述
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer_Config_6002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_Config_6002.class,args);
    }
}