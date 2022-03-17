package com.liuxi.ad.service;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/16 23:33
 */
@SpringBootApplication
public class AdProviderMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdProviderMain.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
