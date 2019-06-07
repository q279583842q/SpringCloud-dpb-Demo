package com.dpb.feign.service;

import com.dpb.feign.pojo.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 公共服务的接口
 */
@RequestMapping("/product")
public interface ProductService {

    /**
     * 查询所有商品的方法
     * @return
     */
    @GetMapping("/findAll")
    public List<Product> findAll();
}
