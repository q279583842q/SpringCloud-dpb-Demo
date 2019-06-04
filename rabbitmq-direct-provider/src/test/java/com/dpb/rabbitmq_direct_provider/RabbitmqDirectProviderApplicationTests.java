package com.dpb.rabbitmq_direct_provider;

import com.dpb.rabbitmq_direct_provider.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDirectProviderApplication.class)
public class RabbitmqDirectProviderApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() throws Exception{

            sender.send("hello .... ");
    }
}
