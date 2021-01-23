package com.pateo.provide.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pateo.provide.entities.Product;
//import com.pateo.provide.mapper.ProductMapper;
import com.pateo.provide.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 服务提供方
 */
@Service
public class ProductServiceImpl implements ProductService {

//    @Autowired
//    ProductMapper productMapper;

    @Override
    public boolean add(Product product) {
//        return productMapper.addProduct(product);
        return true;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="6000"),
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),  //开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),  //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),  //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"),   //失败率达到多少后跳闸

    })
    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="6000")
    public Product get(Long id) {
//        return productMapper.findById(id);
        try{
            Thread.sleep(5000);
        }catch(Exception ex){
            ex.printStackTrace();
        }


        return new Product();
    }
    public Product getByIdFallBack(Long id) {


        System.out.println("服务端超时=====");
        return new Product();
    }


    @Override
    public List<Product> list() {
//        return productMapper.findAll();
        return new ArrayList<>();
    }

    @Override
    public void updateProduct(Product product) {
//        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProductById(Long id) {
//        productMapper.deleteProductById(id);
    }

}
