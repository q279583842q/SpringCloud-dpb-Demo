package com.dpb.feign.controller;

import com.dpb.feign.pojo.Product;
import com.dpb.feign.service.ProductConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springcloud-feign-prodcut-consumer
 * @description: 消费者提供服务
 * @author: 波波烤鸭
 * @create: 2019-06-07 10:47
 */
@RestController
public class ProductController {

    @Autowired
    ProductConsumerService consumerService;
    /**
     * Consumer 中的查询所有商品的方法
     * @return
     */
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public List<Product> getAll(){
        return this.consumerService.findAll();
    }

    @RequestMapping(value="/get",method= RequestMethod.GET)
    public Product getProductById(@RequestParam("id") Integer id){
        return this.consumerService.getProductById(id);
    }


    @RequestMapping(value="/get1",method= RequestMethod.GET)
    public Product addProductGet(Product product){
        return this.consumerService.addProductGet(product.getId(),product.getName());
    }

    @RequestMapping(value="/get2",method= RequestMethod.GET)
    public Product addProductPost(Product product){
        System.out.println(product);
        return this.consumerService.addProductPost(product);
    }


}
