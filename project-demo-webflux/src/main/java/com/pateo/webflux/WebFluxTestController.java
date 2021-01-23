package com.pateo.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试webFlux  类似与Controller
 * @创建人 juncao
 * @创建时间 2019/12/12 14:20
 * @描述
 **/
@RestController
public class WebFluxTestController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

}