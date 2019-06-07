package com.dpb.feign.pojo;

/**
 * @program: springcloud-feign-prodcut-service
 * @description: 商品信息的pojo类
 * @author: 波波烤鸭
 * @create: 2019-06-07 09:22
 */
public class Product {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
