package com.cj.project.consumer.service;


import com.cj.project.consumer.entities.Product;
import com.cj.project.consumer.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 定义消费端消费接口
 */
@Service(value = "productConsumeService")
@FeignClient(value = "config-demo-provide",fallback = ProductConsumerServiceFallBack.class)
public interface ProductConsumeService {
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product);

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id);

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list();

    @RequestMapping(value = "/product/updateProduct", method = RequestMethod.POST)
    public void updateProduct(@RequestBody Product product);

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
    public void deleteProductById(@PathVariable("id") Long id);

    @RequestMapping(value = "/product/webflux/test", method = RequestMethod.GET)
    public User webfluxtest();

    //redis操作
    @GetMapping(value = "/redis/get/{key}")
    public Object redisGet(@PathVariable("key") String key);


    //redis操作
    @PostMapping(value = "/redis/putUser")
    public Object putUser(@RequestBody User user);


    @RequestMapping(value = "/redis/login", method = RequestMethod.POST)
    public String login(@RequestBody User user);

    @RequestMapping(value = "/redis/loginout/{userId}", method = RequestMethod.GET)
    public String loginout(@PathVariable("userId") String userId);

    @RequestMapping(value = "/redis/register", method = RequestMethod.POST)
    public String register(@RequestBody User user);


}
