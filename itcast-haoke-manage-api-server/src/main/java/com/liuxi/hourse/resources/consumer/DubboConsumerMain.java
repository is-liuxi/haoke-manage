package com.liuxi.hourse.resources.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:24
 */
@SpringBootApplication
@EnableCaching
public class DubboConsumerMain {

    public static void main(String[] args) {

        SpringApplication.run(DubboConsumerMain.class, args);
    }
}
