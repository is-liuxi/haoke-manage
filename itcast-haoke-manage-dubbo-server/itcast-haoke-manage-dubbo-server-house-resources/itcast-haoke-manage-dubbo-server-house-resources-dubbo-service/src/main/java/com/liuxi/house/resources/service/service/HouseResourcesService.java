package com.liuxi.house.resources.service.service;

import com.liuxi.house.resource.interfaces.pojo.entity.HouseResources;

/**
 * <p>
 *
 * </P>
 * @author LiuXi
 * @date 2022/3/8 3:45
 */
public interface HouseResourcesService {

    /**
     * 新增房源
     * @param houseResources
     * @return
     */
    int saveHouseResources(HouseResources houseResources);

}
