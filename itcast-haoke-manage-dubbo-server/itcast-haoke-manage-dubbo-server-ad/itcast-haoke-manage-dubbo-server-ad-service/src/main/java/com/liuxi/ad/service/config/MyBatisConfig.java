package com.liuxi.ad.service.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/16 23:31
 */
@Configuration
@MapperScan("com.liuxi.ad.service.mapper")
public class MyBatisConfig {

    /**
     * myBatis-plus 分页插件
     * 旧版使用 PaginationInterceptor 类
     * @return
     */
    @Bean
    public MybatisPlusInterceptor paginationInnerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 设置数据为 MySQL
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
