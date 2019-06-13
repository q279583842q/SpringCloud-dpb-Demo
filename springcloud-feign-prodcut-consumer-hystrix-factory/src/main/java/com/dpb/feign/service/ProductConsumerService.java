package com.dpb.feign.service;

import com.dpb.feign.hystrix.ProductServiceFallbackFactory;
import com.dpb.feign.pojo.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * feign 做服务降级处理
 *    不需要继承 ProductService接口
 * fallback属性关联托底数据类
 */
@FeignClient(name="shop-product-provider" ,fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductConsumerService  {

    @RequestMapping(value="/product/findAll",method= RequestMethod.GET)
    public List<Product> findAll();

}
