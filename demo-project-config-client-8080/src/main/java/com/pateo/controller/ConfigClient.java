package com.pateo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 梦学谷
 */
@RestController
public class ConfigClient {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.datasource.url}")
    private String url;


    @GetMapping("/config")
    public String config() {
        String content = "applicationName: " + applicationName + ", port: " + port+",url:"+url;
        System.out.println(content);
        return content;
    }
}
