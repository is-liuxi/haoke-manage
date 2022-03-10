package com.liuxi.hourse.resources.consumer.controller;

import com.liuxi.hourse.resources.consumer.api.service.PicUploadService;
import com.liuxi.hourse.resources.consumer.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/11 5:06
 */
@RequestMapping("pic/upload")
@RestController
public class PicUploadController {

    @Autowired
    private PicUploadService picUploadService;

    @PostMapping("uploadImage")
    public PicUploadResult uploadImage(@RequestParam("file") MultipartFile multipartFile) {

        return picUploadService.uploadImage(multipartFile);
    }
}
