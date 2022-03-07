package com.liuxi.house.resources.service.service.impl;

import com.liuxi.house.resource.interfaces.pojo.entity.HouseResources;
import com.liuxi.house.resources.service.common.BaseServiceImpl;
import com.liuxi.house.resources.service.common.ResultFieldCommons;
import com.liuxi.house.resources.service.service.HouseResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 3:46
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources> implements HouseResourcesService {

    @Override
    public int saveHouseResources(HouseResources houseResources) {
        if (saveFieldNotNull(houseResources)) {
            try {
                save(houseResources);
                return ResultFieldCommons.SAVE_HOUSE_RESOURCES_SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
                return ResultFieldCommons.SAVE_HOUSE_RESOURCES_SQL_ERROR;
            }
        }
        return ResultFieldCommons.SAVE_HOUSE_RESOURCES_PARAMETER_ERROR;
    }

    private boolean saveFieldNotNull(HouseResources houseResources) {

        return StringUtils.isNotEmpty(houseResources.getBuildingNum()) && houseResources.getRent() != null
                && StringUtils.isNotEmpty(houseResources.getHouseType()) && StringUtils.isNotEmpty(houseResources.getContact())
                && StringUtils.isNotEmpty(houseResources.getUseArea()) && StringUtils.isNotEmpty(houseResources.getFloor())
                && StringUtils.isNotEmpty(houseResources.getContact()) && StringUtils.isNotEmpty(houseResources.getMobile())
                && houseResources.getTime() != null;
    }
}
