package com.liuxi.hourse.resources.consumer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/11 7:15
 */
@AllArgsConstructor
@Data
public class Pagination {

    private Integer currentPage;
    private Integer pageSize;
    private Integer total;
}
