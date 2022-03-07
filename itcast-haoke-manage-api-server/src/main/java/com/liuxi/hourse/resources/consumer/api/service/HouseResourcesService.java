package com.liuxi.hourse.resources.consumer.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liuxi.house.resource.interfaces.pojo.entity.HouseResources;
import com.liuxi.house.resource.interfaces.server.api.ApiHouseResourcesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:24
 */
@Service
public class HouseResourcesService {

    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    /**
     * 调用生产者新增房源服务
     * @param houseResources
     * @return
     */
    public Integer saveHouseResources(HouseResources houseResources) {

        return this.apiHouseResourcesService.saveHouseResources(houseResources);
    }
}
