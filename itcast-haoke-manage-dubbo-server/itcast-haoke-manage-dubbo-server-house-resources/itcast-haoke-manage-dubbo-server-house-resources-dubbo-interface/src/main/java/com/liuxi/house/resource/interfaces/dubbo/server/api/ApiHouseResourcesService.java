package com.liuxi.house.resource.interfaces.dubbo.server.api;

import com.liuxi.house.resource.interfaces.pojo.HouseResources;
import com.liuxi.server.common.pojo.vo.PageInfo;

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

    /**
     * 分页查询房源列表
     * @param page
     * @param pageSize
     * @param houseResources
     * @return
     */
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources houseResources);

    /**
     * 根据 ID 查询房源数据
     * @param id
     * @return
     */
    HouseResources queryHouseResourcesById(Long id);
}
