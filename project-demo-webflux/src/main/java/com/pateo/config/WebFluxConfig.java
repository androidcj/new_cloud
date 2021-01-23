package com.pateo.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.server.WebHandler;

/**
 * @创建人 juncao
 * @创建时间 2019/12/12 14:39
 * @描述
 **/
@Configuration
@ComponentScan
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {
    @Bean
    public WebHandler webHandler(ApplicationContext applicationContext) {
        DispatcherHandler dispatcherHandler = new DispatcherHandler(applicationContext);
        return dispatcherHandler;
    }
}