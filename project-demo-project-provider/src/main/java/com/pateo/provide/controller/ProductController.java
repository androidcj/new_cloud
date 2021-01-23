package com.pateo.provide.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.pateo.entities.Product;
//import com.pateo.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pateo.provide.entities.Product;
import com.pateo.provide.entities.User;
import com.pateo.provide.service.ProductService;
//import com.pateo.provide.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
//    @Autowired
//    private RedisUtil redisUtil;

    @HystrixCommand(fallbackMethod = "addFallBack")
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        boolean res = false;
        try{
            res =  productService.add(product);
        }catch(Exception e){
            e.printStackTrace();

        }

        return res;
    }

    @HystrixCommand(fallbackMethod = "updateByBeanFallBack")
    @RequestMapping(value = "/product/updateProduct", method = RequestMethod.POST)
    public void updateProduct(@RequestBody Product product) {
         productService.updateProduct(product);
    }


    @HystrixCommand(fallbackMethod = "deleteByIdFallBack")
    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }


    //3s超时
    @HystrixCommand(fallbackMethod = "getByIdFallBack")
    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        return productService.get(id);
    }


    @HystrixCommand(fallbackMethod = "getListFallBack")
    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }

    /**
     * add熔断方法
     * @return
     */
    public boolean addFallBack(Product product){
        return false;
    }

    /**
     * 修改产品数据
     * @param product
     */
    public void  updateByBeanFallBack(Product product){

    }

    /**
     * 删除方法熔断
     */
    public void deleteByIdFallBack(Long id){

    }


    /**
     * getById熔断方法
     * @return
     */
    public Product getByIdFallBack(Long id){
        return null;
    }

    /**
     * getList熔断方法
     * @return
     */
    public List<Product> getListFallBack(){
        return new ArrayList<Product>();
    }


//    @HystrixCommand(fallbackMethod = "getListFallBack")
//    @RequestMapping(value = "/product/webflux/test", method = RequestMethod.GET)
//    public Mono<User> webfluxtest() {
//        User user = new User();
//        user.setId(1);
//        user.setName("aaaa");
//        return Mono.just(user);
//    }




}
