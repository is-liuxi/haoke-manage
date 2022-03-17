package com.liuxi.house.resources.service;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:17
 */
@SpringBootApplication
public class HouseResourcesProviderMain {
    public static void main(String[] args) {

        new SpringApplicationBuilder(HouseResourcesProviderMain.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
