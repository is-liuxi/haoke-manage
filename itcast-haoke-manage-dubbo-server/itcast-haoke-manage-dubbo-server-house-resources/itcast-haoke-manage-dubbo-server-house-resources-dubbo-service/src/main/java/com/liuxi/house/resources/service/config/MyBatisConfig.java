package com.liuxi.house.resources.service.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 3:39
 */
@Configuration
@MapperScan(basePackages = "com.liuxi.house.resources.service.mapper")
public class MyBatisConfig {

}
