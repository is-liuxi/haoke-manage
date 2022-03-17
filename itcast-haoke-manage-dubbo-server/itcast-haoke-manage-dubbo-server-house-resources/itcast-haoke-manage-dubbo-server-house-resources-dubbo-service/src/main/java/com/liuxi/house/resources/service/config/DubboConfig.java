package com.liuxi.house.resources.service.config;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:19
 */
@Configuration
@DubboComponentScan("com.liuxi.house.resources.service.dubbo.impl.api")
public class DubboConfig {


}
