package com.liuxi.house.resource.interfaces.server.api;

import com.liuxi.house.resource.interfaces.pojo.entity.HouseResources;

/**
 * <p>
 *
 * </P>
 * @author LiuXi
 * @date 2022/3/8 3:26
 */
public interface ApiHouseResourcesService {

    /**
     * 新增房源
     * @param houseResources
     * @return
     */
    int saveHouseResources(HouseResources houseResources);
}
