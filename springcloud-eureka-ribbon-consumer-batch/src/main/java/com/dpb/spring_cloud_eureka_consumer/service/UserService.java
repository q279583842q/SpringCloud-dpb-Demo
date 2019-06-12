package com.dpb.spring_cloud_eureka_consumer.service;

import com.dpb.spring_cloud_eureka_consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @program: springcloud-eureka-consumer
 * @description: 用户的业务处理
 * @author: 波波烤鸭
 * @create: 2019-05-28 17:43
 */
@Service
public class UserService {
    /**
     * consumer 的 controller 调用的方法
     * 该方法返回值必须要返回Future 类型
     * 利用 hystrix 合并请求
     */
    @HystrixCollapser(
            batchMethod = "batchUser"
            , scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL
            ,collapserProperties = {
                    //请求时间间隔在 20ms 之内的请求会被合并为一个请求,默认为 10ms
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "20"),
                    //设置触发批处理执行之前，在批处理中允许的最大请求数。
                    @HystrixProperty(name = "maxRequestsInBatch",value = "200"),
            })
    public Future<User> getUser(Integer id){
        System.out.println("----id---:"+id);
        return null;
    }

    /**
     * 调用 Provider 服务的方法
     * @param ids
     * @return
     */
    @HystrixCommand
    public List<User> batchUser(List<Integer> ids){
        for(Integer id:ids){
            System.out.println(id);
        }
        //假设是调用 provider 服务后返回的 list
        List<User> list = new ArrayList<>();
        list.add(new User(1, "张三",18));
        list.add(new User(2, "李四",19));
        list.add(new User(3, "王五",20));
        list.add(new User(4, "小明",21));
        list.add(new User(100,"小张",22));
        System.out.println("*************");
        return list;
    }

}
