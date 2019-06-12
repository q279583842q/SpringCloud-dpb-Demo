package com.dpb.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="shop-product-provider")
public interface ProductConsumerService extends ProductService {


}
