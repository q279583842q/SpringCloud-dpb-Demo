package com.dpb.springcloud_eureka_provider.controller;

import com.dpb.springcloud_eureka_provider.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloud-eureka-provider
 * @description: 服务提供者
 * @author: 波波烤鸭
 * @create: 2019-05-28 17:30
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        list.add(new User(1,"zhangsan",20));
        list.add(new User(2,"lisi",22));
        list.add(new User(3,"wangwu",20));
        return list;
    }
}
