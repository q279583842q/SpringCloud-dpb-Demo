package com.dpb.spring_cloud_eureka_consumer.service;

import com.dpb.spring_cloud_eureka_consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloud-eureka-consumer
 * @description: 用户的业务处理
 * @author: 波波烤鸭
 * @create: 2019-05-28 17:43
 */
@Service
public class UserService {

    /**
     * ribbon 负载均衡
     *    LoadBalancerClient 通过服务名称可以获取对应的服务的相关信息 ip port等
     */
    @Autowired
   private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {
                    //默认 20 个;10s 内请求数大于 20 个时就启动熔断器，当请求符合熔断条件时将触发 getFallback()。
            @HystrixProperty(name= HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,
                    value="10"),
            //请求错误率大于 50%时就熔断，然后 for 循环发起请求，当请求符合熔断条件时将触发 getFallback()。
            @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,
                    value="50"),
            //默认 5 秒;熔断多少秒后去尝试请求
            @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,
                    value="5000"),
            })
    public List<User> getUsers(Integer id){
        System.out.println("--------->"+id);
        if(id == 1){
            throw new RuntimeException();
        }
        // ServiceInstance 封装的有服务的基本信息  IP和端口等
        ServiceInstance si = this.loadBalancerClient.choose("eureka-ribbon-provider");

        StringBuilder sb = new StringBuilder();
        sb.append("http://")
                .append(si.getHost())
                .append(":")
                .append(si.getPort())
                .append("/user");
        System.out.println("服务地址:"+sb.toString());
        // SpringMVC RestTemplate
        RestTemplate rt = new RestTemplate();
        ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>() {};
        // ResponseEntity:封装了返回值的信息
        ResponseEntity<List<User>> response = rt.exchange(sb.toString(), HttpMethod.GET,null,type);
        List<User> list = response.getBody();
        return list;
    }

    /**
     * 服务降级
     *   返回托底数据的方法
     * @return
     */
    public List<User> fallback(Integer id){
        List<User> list = new ArrayList<>();
        list.add(new User(3,"我是托底数据",22));
        return list;
    }
}
