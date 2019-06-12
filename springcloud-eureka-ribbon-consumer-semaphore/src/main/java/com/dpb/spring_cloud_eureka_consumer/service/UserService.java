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
                    @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY,value="SEMAPHORE"),// 信号量 隔离
                    @HystrixProperty
                            (name=HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value="100")//信号量最大并度
            })
    public List<User> getUsers(){
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
    public List<User> fallback(){
        List<User> list = new ArrayList<>();
        list.add(new User(3,"我是托底数据",22));
        return list;
    }
}
