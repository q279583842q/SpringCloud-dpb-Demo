package com.dpb.spring_cloud_eureka_consumer.controller;

import com.dpb.spring_cloud_eureka_consumer.pojo.User;
import com.dpb.spring_cloud_eureka_consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

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
    public List<User> getUsers(){
        return this.userService.getUsers();
    }


    @RequestMapping(value="/get",method= RequestMethod.GET)
    public User get(Integer id){

        return this.userService.getUserById(id);
    }
    @RequestMapping(value="/del",method=RequestMethod.GET)
    public void del(Integer id){
        this.userService.deleteUserById(id);
    }
}
