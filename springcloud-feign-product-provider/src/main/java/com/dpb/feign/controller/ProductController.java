package com.dpb.feign.controller;


import com.dpb.feign.pojo.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dpb.feign.service.ProductService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud-feign-product-provider
 * @description: 服务提供者的控制器
 * @author: 波波烤鸭
 * @create: 2019-06-07 09:44
 */
@RestController
public class ProductController implements ProductService{


    /**
     * 此处不用再添加@RequestMapping注解，重写的方法在接口中定义的有
     * @return
     */
    @Override
    public List<Product> findAll() {
        try{
            System.out.println("*********"+new Date());
            // 休眠6秒
            Thread.sleep(6000);
        }catch (Exception e){

        }

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "电视"));
        list.add(new Product(2, "电脑"));
        list.add(new Product(3, "冰箱"));
        list.add(new Product(4, "洗衣机"));
        return list;
    }

    /**
     * 单个参数的处理
     * @param s
     * @return
     */
    @Override
    public Product getProductById(Integer id) {

        return new Product(id,"bobo烤鸭-feign");
    }

    @Override
    public Product addProductGet(Integer id, String name) {
        return new Product(id,name);
    }

    @Override
    public Product addProductPost(@RequestBody  Product product) {
        return product;
    }
}
