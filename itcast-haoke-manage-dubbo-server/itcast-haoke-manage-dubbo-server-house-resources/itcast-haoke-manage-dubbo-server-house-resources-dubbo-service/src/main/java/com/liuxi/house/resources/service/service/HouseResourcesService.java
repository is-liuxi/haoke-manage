package com.liuxi.house.resources.service.service;

import com.liuxi.house.resource.interfaces.pojo.entity.HouseResources;
import com.liuxi.house.resource.interfaces.pojo.vo.PageInfo;

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

    /**
     * 分页条件查询房源列表
     * @param page
     * @param pageSize
     * @param houseResources
     * @return
     */
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources houseResources);
}
