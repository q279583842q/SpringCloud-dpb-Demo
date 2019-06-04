package com.dpb.consumer;

import com.dpb.consumer.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)
public class ConsumerApplicationTests {


    /**
     * RestTemplate 访问 provider的第一个服务 server1
     */
    @Test
    public void contextLoads() {
        String url = "http://localhost:8080/server1";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        // 获取响应的状态
        HttpStatus statusCode = entity.getStatusCode();
        // 获取响应的header信息
        HttpHeaders headers = entity.getHeaders();
        // 获取响应的body信息
        String msg = entity.getBody();
        System.out.println(statusCode);
        System.out.println(headers);
        System.out.println(msg);
    }

    /**
     * getForObject 访问
     */
    @Test
    public void contextLoadsObject() {
        String url = "http://localhost:8080/server1";
        RestTemplate restTemplate = new RestTemplate();
        // 直接返回的就是我们需要的结果，但是获取不到对应的响应状态等信息
        String msg = restTemplate.getForObject(url,String.class);
        System.out.println(msg);
    }

    /**
     * getForObject 访问
     */
    @Test
    public void contextLoadsObject1() {
        String url = "http://localhost:8080/server3";
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(1,"bobo","中国");
        // 直接返回的就是我们需要的结果，但是获取不到对应的响应状态等信息
        String msg = restTemplate.postForEntity(url,user,String.class).getBody();
        System.out.println(msg);
    }
    /**
     * 请求服务并且传递参数
     *     基本数据类型
     */
    @Test
    public void testServer2(){
        String url = "http://localhost:8080/server2?id={1}&userName={2}";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class,5,"bobo");
        System.out.println(entity.getBody());
    }

    /**
     * 请求服务并且传递参数
     *     基本数据类型
     */
    @Test
    public void testServer3(){
        String url = "http://localhost:8080/server2?id={id}&userName={userName}";
        Map<String,Object> map = new HashMap<>();
        map.put("id",6);
        map.put("userName","波波烤鸭");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class,map);
        System.out.println(entity.getBody());
    }

    /**
     * 请求服务并且传递参数
     *     自定义类型
     */
    @Test
    public void testServer4(){
        String url = "http://localhost:8080/server3?id={id}&userName={userName}";
        Map<String,Object> map = new HashMap<>();
        map.put("id",6);
        map.put("userName","波波烤鸭");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class,map);
        System.out.println(entity.getBody());
    }

    /**
     * 返回类型为自定义类型
     */
    @Test
    public void testServer5(){
        String url = "http://localhost:8080/server4";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> entity = restTemplate.getForEntity(url, User.class);
        System.out.println(entity.getBody());
    }
    /**
     * 返回类型为List带泛型
     */
    @Test
    public void testServer6(){
        String url = "http://localhost:8080/server5";
        RestTemplate restTemplate = new RestTemplate();
        // 注意后面有一对{} ParameterizedTypeReference本身是抽象类
        ParameterizedTypeReference<List<User>> pr = new ParameterizedTypeReference<List<User>>() {};
        ResponseEntity<List<User>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, pr);
        System.out.println(exchange.getBody());
    }

    /**
     * 返回类型为List带泛型
     */
    @Test
    public void testServer7(){
        String url = "http://localhost:8080/server6";
        RestTemplate restTemplate = new RestTemplate();
        // 注意后面有一对{} ParameterizedTypeReference本身是抽象类
        ParameterizedTypeReference<List<User>> pr = new ParameterizedTypeReference<List<User>>() {};
        ResponseEntity<List<User>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, pr);
        System.out.println(exchange.getBody());
    }
}
