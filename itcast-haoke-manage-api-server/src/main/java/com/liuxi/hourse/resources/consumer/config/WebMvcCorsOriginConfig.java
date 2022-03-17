package com.liuxi.hourse.resources.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *  MVC 配置
 * </P>
 * @author liu xi
 * @date 2022/3/17 13:38
 */
@Configuration
public class WebMvcCorsOriginConfig implements WebMvcConfigurer {

    /**
     * 跨域处理
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS", "HEAD")
                .maxAge(3600);
    }
}
