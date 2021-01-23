package com.cj.project.consumer.controller;


import com.cj.project.consumer.entities.Product;
import com.cj.project.consumer.service.ProductConsumeService;
//import com.pateo.entities.Product;
//import com.pateo.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@Api("demo工程测试接口")
@RestController
@DefaultProperties(defaultFallback = "consumer_default_fallback_method")
public class ProductController_Consumer {

    @Autowired
    private ProductConsumeService productConsumeService;

    @ApiOperation("添加产品数据")
    @RequestMapping(value = "/consumer/product/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productConsumeService.add(product);
    }

    @ApiOperation("得到产品数据")
    @HystrixCommand(fallbackMethod = "getByIdFallBack")
    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    @RequestMapping(value = "/consumer/product/get/{id}",method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        return productConsumeService.get(id);
    }

    public Product getByIdFallBack(Long id){
        System.out.println("客户端超时====");
        return new Product();
    }
    @ApiOperation("得到产品列表")
    @HystrixCommand
    @RequestMapping(value = "/consumer/product/list",method = RequestMethod.GET)
    public List<Product> list() {
        return productConsumeService.list();
    }

    @ApiOperation("修改产品信息")
    @RequestMapping(value = "/consumer/product/updateProduct",method = RequestMethod.POST)
    public void updateProduct(@RequestBody Product product) {
         productConsumeService.updateProduct(product);
    }

    @ApiOperation("通过ID删除产品数据")
    @RequestMapping(value = "/consumer/product/delete/{id}",method = RequestMethod.POST)
    public void deleteProductById(@PathVariable("id") Long id) {
        productConsumeService.deleteProductById(id);
    }

//    @ApiOperation("webflux测试")
//    @RequestMapping(value = "/consumer/product/webflux/test",method = RequestMethod.GET)
//    public User webfluxtest() {
//        Object obj = productConsumeService.webfluxtest();
//        System.out.println("obj==="+obj);
//        return productConsumeService.webfluxtest();
//    }


//    @ApiOperation("从redis中获取数据")
//    @RequestMapping(value = "/consumer/redisTest/get/{key}",method = RequestMethod.GET)
//    public Object redisGet(@PathVariable("key") String key) {
//        return  productConsumeService.redisGet(key);
//    }
//
//    @ApiOperation("保存数据到redis")
//    @RequestMapping(value = "/consumer/redisTest/putUser",method = RequestMethod.POST)
//    public void putUser(@RequestBody User user) {
//        productConsumeService.putUser(user);
//    }



    public List<Product> consumer_default_fallback_method(){
        System.out.println("方法超时，请稍后再试...");
        return new ArrayList();
    }

}
