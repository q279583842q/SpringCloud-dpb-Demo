package com.dpb.springcloud_rabbitmq_demo;

import com.dpb.springcloud_rabbitmq_demo.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringcloudRabbitmqDemoApplication.class)
public class SpringcloudRabbitmqDemoApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() {
        sender.send("你好啊...");
    }
}
