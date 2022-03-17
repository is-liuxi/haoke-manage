package com.liuxi.redis.test;

import com.liuxi.hourse.resources.consumer.DubboConsumerMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/17 22:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DubboConsumerMain.class)
public class RedisConnectTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void redisTest() {
        redisTemplate.opsForValue().set("name", "张三");

        String name = redisTemplate.opsForValue().get("name");
        System.out.println("===============" + name);
    }
}
