package com.liuxi.hourse.resources.consumer.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *  将缓存拦截器添加到 Spring 容器中
 * </P>
 * @author liu xi
 * @date 2022/3/17 23:14
 */
@Configuration
public class WebMvcInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private RedisCacheInterceptor redisCacheInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 所有请求
        registry.addInterceptor(redisCacheInterceptor).addPathPatterns("/**");
    }
}
