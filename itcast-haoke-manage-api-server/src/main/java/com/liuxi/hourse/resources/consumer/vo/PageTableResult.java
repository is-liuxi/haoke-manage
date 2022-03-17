package com.liuxi.hourse.resources.consumer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/11 7:14
 */
@AllArgsConstructor
@Data
public class PageTableResult<T> {

    private List<T> data;
    private Pagination pagination;
}
