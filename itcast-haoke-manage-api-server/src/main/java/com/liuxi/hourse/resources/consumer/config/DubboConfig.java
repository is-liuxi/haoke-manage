package com.liuxi.hourse.resources.consumer.config;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:32
 */
@Configuration
@DubboComponentScan({"com.liuxi.hourse.resources.consumer.api.service", "com.liuxi.hourse.resources.consumer.controller"})
public class DubboConfig {

}
