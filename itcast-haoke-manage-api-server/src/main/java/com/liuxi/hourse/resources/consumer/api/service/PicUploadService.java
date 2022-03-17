package com.liuxi.hourse.resources.consumer.api.service;

import com.aliyun.oss.OSSClient;
import com.liuxi.hourse.resources.consumer.config.AliYunConfig;
import com.liuxi.hourse.resources.consumer.vo.PicUploadResult;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/11 5:09
 */
@Service
public class PicUploadService {

    @Autowired
    private OSSClient oosClient;
    @Autowired
    private AliYunConfig aliYunConfig;

    /**
     * 允许上传的格式
     */
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};

    public PicUploadResult uploadImage(MultipartFile multipartFile) {
        // 1、上传文件后缀名校验
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(multipartFile.getOriginalFilename(), type)) {
                isLegal = true;
                break;
            }
        }

        PicUploadResult picUploadResult = new PicUploadResult();
        if (!isLegal) {
            picUploadResult.setStatus("error");
        }

        // 文件路径
        String fileName = multipartFile.getOriginalFilename();
        String filePath = setFilePath(fileName);

        try {
            oosClient.putObject(aliYunConfig.getBucketName(), filePath, new ByteArrayInputStream(multipartFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
            picUploadResult.setStatus("error");
        }

        picUploadResult.setStatus("done");
        picUploadResult.setName(aliYunConfig.getUrlPrefix() + filePath);
        picUploadResult.setUid(String.valueOf(System.currentTimeMillis()));
        return picUploadResult;
    }

    /**
     * 保存目录结构： images/year/month/day/xxx.jpg
     * @param fileName
     * @return
     */
    private String setFilePath(String fileName) {
        DateTime dateTime = new DateTime();
        StringBuffer append = new StringBuffer();
        append.append("images/").append(dateTime.toString("yyyy")).append("/")
                .append(dateTime.toString("MM")).append("/")
                .append(dateTime.toString("dd")).append("/").append(System.currentTimeMillis())
                .append(RandomUtils.nextInt(100, 9999)).append(".")
                .append(StringUtils.substringAfter(fileName, "."));
        return append.toString();
    }
}
