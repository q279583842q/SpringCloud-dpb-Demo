package com.dpb.feign.controller;

import com.dpb.feign.pojo.Product;
import com.dpb.feign.service.ProductConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springcloud-feign-prodcut-consumer
 * @description: 消费者提供服务
 * @author: 波波烤鸭
 * @create: 2019-06-07 10:47
 */
@RestController
public class ProductController {

    @Resource
    ProductConsumerService consumerService;
    /**
     * Consumer 中的查询所有商品的方法
     * @return
     */
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public List<Product> getAll(){
        return this.consumerService.findAll();
    }

}
