package com.liuxi.hourse.resources.consumer.controller;

import com.liuxi.ad.interfaces.pojo.Ad;
import com.liuxi.hourse.resources.consumer.api.service.AdService;
import com.liuxi.hourse.resources.consumer.vo.WebResult;
import com.liuxi.server.common.pojo.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/16 23:25
 */
@RestController
@RequestMapping("mobile/index")
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("ad/{type}")
    public WebResult queryIndexAdList(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                     @PathVariable("type") Integer type) {

        return this.adService.queryAdList(type, currentPage, pageSize);
    }
}
