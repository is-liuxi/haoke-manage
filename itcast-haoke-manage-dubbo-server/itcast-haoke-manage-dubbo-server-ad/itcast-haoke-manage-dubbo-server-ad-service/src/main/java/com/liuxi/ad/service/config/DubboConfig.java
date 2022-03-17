package com.liuxi.ad.service.config;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/16 23:55
 */
@Configuration
@DubboComponentScan("com.liuxi.ad.service.dubbo.impl.api")
public class DubboConfig {

}
