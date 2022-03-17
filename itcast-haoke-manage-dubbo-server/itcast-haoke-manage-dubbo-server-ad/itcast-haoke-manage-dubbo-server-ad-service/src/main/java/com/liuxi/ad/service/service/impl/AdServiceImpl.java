package com.liuxi.ad.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuxi.ad.interfaces.pojo.Ad;
import com.liuxi.ad.service.service.AdService;
import com.liuxi.server.common.pojo.vo.PageInfo;
import com.liuxi.server.common.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/16 23:09
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
@Slf4j
public class AdServiceImpl extends BaseServiceImpl<Ad> implements AdService {

    @Transactional(readOnly = true)
    @Override
    public PageInfo<Ad> queryAdList(Integer type, Integer currentPage, Integer pageSize) {
        Ad ad = new Ad();
        ad.setType(type);
        QueryWrapper<Ad> queryWrapper = new QueryWrapper<>(ad);
        queryWrapper.orderByDesc("updated");

        IPage<Ad> adPage = this.queryPageListByWhere(queryWrapper, currentPage, pageSize);
        log.info("queryAdList ===> {}", adPage);
        return new PageInfo<>(Long.valueOf(adPage.getTotal()).intValue(), Long.valueOf(adPage.getCurrent()).intValue(),
                Long.valueOf(adPage.getPages()).intValue(), adPage.getRecords());
    }
}
