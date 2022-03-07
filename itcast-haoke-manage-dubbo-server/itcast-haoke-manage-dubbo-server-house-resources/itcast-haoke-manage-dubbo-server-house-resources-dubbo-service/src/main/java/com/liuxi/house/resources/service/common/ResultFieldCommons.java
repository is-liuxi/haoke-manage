package com.liuxi.house.resources.service.common;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 3:29
 */
public interface ResultFieldCommons {

    /**
     * -1：输入的参数不符合要求
     */
   Integer SAVE_HOUSE_RESOURCES_PARAMETER_ERROR = -1;

    /**
     * 0：数据插入数据库失败
     */
    Integer SAVE_HOUSE_RESOURCES_SQL_ERROR = 0;

    /**
     * 1：成功
     */
    Integer SAVE_HOUSE_RESOURCES_SUCCESS = 1;
}
