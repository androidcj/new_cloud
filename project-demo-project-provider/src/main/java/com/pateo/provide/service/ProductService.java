package com.pateo.provide.service;



import com.pateo.provide.entities.Product;

import java.util.List;

/**
 * 定义简单的service类
 */
public interface ProductService {

    boolean add(Product product);

    Product get(Long id);


    List<Product> list();

    void updateProduct(Product product);

    void deleteProductById(Long id);
}
