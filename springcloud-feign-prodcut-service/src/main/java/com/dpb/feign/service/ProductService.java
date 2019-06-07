package com.dpb.feign.service;

import com.dpb.feign.pojo.Product;
import org.springframework.web.bind.annotation.*;

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

    /**
     *  根据id查询商品信息
     *  Feign本身也是基于http请求的客户端
     *  在接收参数时我们需要通过@RequestParam注解来指明要接收的参数
     * @param id
     * @return
     */
    @GetMapping("/getProductById")
    public Product getProductById(@RequestParam("id") Integer id);

    /**
     * GET方式
     *     获取多个参数
     *     注意：GET方式 形参必须多个分开
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/addProductGet")
    public Product addProductGet(@RequestParam("id") Integer id,@RequestParam("name") String name);

    /**
     *  Post方式
     *     获取多个参数：@RequestBody
     * @param product
     * @return
     */
    @PostMapping("/addProductPost")
    public Product addProductPost(@RequestBody  Product product);
}
