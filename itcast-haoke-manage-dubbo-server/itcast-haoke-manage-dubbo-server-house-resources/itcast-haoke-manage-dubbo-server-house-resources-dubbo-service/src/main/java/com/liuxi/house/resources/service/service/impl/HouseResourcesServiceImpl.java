package com.liuxi.house.resources.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuxi.house.resource.interfaces.pojo.entity.HouseResources;
import com.liuxi.house.resource.interfaces.pojo.vo.PageInfo;
import com.liuxi.house.resources.service.common.BaseServiceImpl;
import com.liuxi.house.resources.service.common.ResultFieldCommons;
import com.liuxi.house.resources.service.mapper.HouseResourcesMapper;
import com.liuxi.house.resources.service.service.HouseResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private HouseResourcesMapper houseResourcesMapper;

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

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources houseResources) {
        // 调用抽象类封装的方法
        QueryWrapper<HouseResources> queryWrapper = new QueryWrapper<>(houseResources);
        queryWrapper.orderByDesc("updated");
        IPage<HouseResources> iPageList = this.queryPageListByWhere(queryWrapper, page, pageSize);

        return new PageInfo<>(Long.valueOf(iPageList.getTotal()).intValue(), Long.valueOf(iPageList.getCurrent()).intValue(),
                Long.valueOf(iPageList.getPages()).intValue(), iPageList.getRecords());
    }

    /**
     * 参数判空校验
     * @param houseResources
     * @return
     */
    private boolean saveFieldNotNull(HouseResources houseResources) {

        return StringUtils.isNotEmpty(houseResources.getBuildingNum()) && houseResources.getRent() != null
                && StringUtils.isNotEmpty(houseResources.getHouseType()) && StringUtils.isNotEmpty(houseResources.getContact())
                && StringUtils.isNotEmpty(houseResources.getUseArea()) && StringUtils.isNotEmpty(houseResources.getFloor())
                && StringUtils.isNotEmpty(houseResources.getContact()) && StringUtils.isNotEmpty(houseResources.getMobile())
                && houseResources.getTime() != null;
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {

        return this.queryById(id);
    }
}
