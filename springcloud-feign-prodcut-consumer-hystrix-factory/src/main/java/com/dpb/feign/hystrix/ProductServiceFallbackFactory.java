package com.dpb.feign.hystrix;

import com.dpb.feign.pojo.Product;
import com.dpb.feign.service.ProductConsumerService;
import feign.hystrix.FallbackFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloud-feign-prodcut-consumer-hystrix
 * @description: fallback类
 * @author: 波波烤鸭
 * @create: 2019-06-12 21:35
 */
@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductConsumerService> {

    private Logger logger = Logger.getLogger(ProductServiceFallbackFactory.class);

    @Override
    public ProductConsumerService create(Throwable throwable) {
        return new ProductConsumerService() {
            /**
             * 能够返回托底数据的 fallback 方法
             * @return
             */
            @Override
            public List<Product> findAll() {
                // log 异常信息
                logger.warn("fegin fallback Exception:"+throwable);
                List<Product> list = new ArrayList<>();
                list.add(new Product(-1, "我是托底数据"));
                return list;
            }
        };
    }
}
