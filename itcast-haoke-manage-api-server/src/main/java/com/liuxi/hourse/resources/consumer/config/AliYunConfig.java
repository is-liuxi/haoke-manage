package com.liuxi.hourse.resources.consumer.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/11 4:43
 */
@Configuration
@PropertySource("classpath:aliyun.properties")
@ConfigurationProperties(prefix = "aliyun")
@Setter
public class AliYunConfig {

    private String accessKeyId;
    private String accessKeySecret;
    @Getter
    private String bucketName;
    private String endpoint;
    @Getter
    private String urlPrefix;

    @Bean
    public OSSClient ossClient() {

        return (OSSClient) new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}
