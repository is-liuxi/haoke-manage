package com.liuxi.house.resources.service.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuxi.house.resource.interfaces.pojo.BasePojo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 通用的 CRUD 操作
 * </P>
 * @author liu xi
 * @date 2022/3/8 3:47
 */
public abstract class BaseServiceImpl<T extends BasePojo> {

    @Autowired
    private BaseMapper<T> mapper;

    /**
     * 根据 id 查询数据
     * @param id
     * @return
     */
    public T queryById(Long id) {

        return this.mapper.selectById(id);
    }

    /**
     * 查询所有数据
     * @return
     */
    public List<T> queryAll() {

        return this.mapper.selectList(null);
    }

    /**
     * 根据条件查询一条数据
     * @param record
     * @return
     */
    public T queryOne(T record) {

        return this.mapper.selectOne(new QueryWrapper<>(record));
    }

    /**
     * 根据条件查询多条数据
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {

        return this.mapper.selectList(new QueryWrapper<>(record));
    }

    /**
     * 根据条件分页查询数据列表
     * @param queryWrapper
     * @param page
     * @param rows
     * @return
     */
    public IPage<T> queryPageListByWhere(QueryWrapper<T> queryWrapper, Integer page, Integer rows) {

        return this.mapper.selectPage(new Page<>(page, rows), queryWrapper);
    }

    /**
     * 保存数据
     * @param record
     * @return
     */
    public Integer save(T record) {
        LocalDateTime now = LocalDateTime.now();
        record.setCreated(now);
        record.setUpdated(now);
        return this.mapper.insert(record);
    }

    /**
     * 根据 id 修改数据
     * @param record
     * @return
     */
    public Integer update(T record) {
        record.setUpdated(LocalDateTime.now());
        return this.mapper.updateById(record);
    }

    /**
     * 根据 id 删除数据
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {

        return this.mapper.deleteById(id);
    }

    /**
     * 根据条件删除数据，单个
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record) {

        return this.mapper.delete(new QueryWrapper<>(record));
    }
}
