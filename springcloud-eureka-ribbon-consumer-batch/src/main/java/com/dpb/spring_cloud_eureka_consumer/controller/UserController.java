package com.dpb.spring_cloud_eureka_consumer.controller;

import com.dpb.spring_cloud_eureka_consumer.pojo.User;
import com.dpb.spring_cloud_eureka_consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @program: springcloud-eureka-consumer
 * @description: 用户控制器
 * @author: 波波烤鸭
 * @create: 2019-05-28 17:40
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/consumer")
    public void getUsers() throws Exception{

        Future<User> f1 = this.userService.getUser(1);
        Future<User> f2 = this.userService.getUser(2);
        Future<User> f3 = this.userService.getUser(3);
        System.out.println(f1.get().toString());
        System.out.println(f2.get().toString());
        System.out.println(f3.get().toString());
    }
}
