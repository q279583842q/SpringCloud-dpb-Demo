package com.dpb.provider.controller;

import com.dpb.provider.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @program: RestTemplate_Demo
 * @description: Rest服务提供者
 * @author: 波波烤鸭
 * @create: 2019-05-29 09:45
 */
@RestController
public class RestDemoController {

    /**
     * 无参，返回字符串
     * @return
     */
    @RequestMapping("/server1")
    public String server1String(){
        System.out.println("服务端被访问了...");
        return "success";
    }

    /**
     * 有参，基本数据类型 返回字符串
     * @return
     */
    @RequestMapping("/server2")
    public String server2String(Integer id,String userName){
        System.out.println("服务端被访问了..."+id+" "+userName);
        return "success--参数得到了";
    }

    /**
     * 有参，基本数据类型 返回字符串
     * @return
     */
    @RequestMapping("/server3")
    public String server3String(@RequestBody  User user){
        System.out.println("服务端被访问了..."+user);
        return "success--参数得到了";
    }

    /**
     * 返回自定义对象
     * @return
     */
    @RequestMapping("/server4")
    public User server4Object(){
        System.out.println("服务端被访问了...");
        return new User(2,"李四","深圳");
    }

    /**
     * 返回 集合带泛型
     * @return
     */
    @RequestMapping("/server5")
    public List<User> server5List(){
        System.out.println("服务端被访问了...");
        return Arrays.asList(new User(2,"李四1","深圳")
                            ,new User(3,"李四2","深圳")
                            ,new User(4,"李四3","深圳"));
    }

    /**
     * 返回 JSON数据
     * @return
     */
    @RequestMapping("/server6")
    @ResponseBody
    public List<User> server6Json(){
        System.out.println("服务端被访问了...");
        return Arrays.asList(new User(2,"李四1","深圳")
                ,new User(3,"李四2","深圳")
                ,new User(4,"李四3","深圳"));
    }


}
