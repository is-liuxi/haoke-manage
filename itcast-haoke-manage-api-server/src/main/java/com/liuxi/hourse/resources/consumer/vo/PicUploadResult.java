package com.liuxi.hourse.resources.consumer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/11 5:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PicUploadResult {

    /**
     * 文件唯一标识
     */
    private String uid;
    /**
     * 文件名
     */
    private String name;
    /**
     * 状态：uploading、done、error、removed
     */
    private String status;
    /**
     * 服务端响应内容，如：'{"status":"success"}'
     */
    private String response;
}
