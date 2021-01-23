package com.cj.project.consumer.service;


import com.cj.project.consumer.entities.Product;
import com.cj.project.consumer.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断类
 */
@Component
public class ProductConsumerServiceFallBack implements ProductConsumeService{
    @Override
    public boolean add(Product product) {
        return false;
    }

    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public User webfluxtest() {
        return new User();
    }

    @Override
    public Object redisGet(String key) {
        return null;
    }

    @Override
    public Object putUser(User user) {
        return null;
    }

    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public String loginout(String userId) {
        return null;
    }

    @Override
    public String register(User user) {
        return null;
    }
}
