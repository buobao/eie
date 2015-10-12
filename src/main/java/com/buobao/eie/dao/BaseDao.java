package com.buobao.eie.dao;

import com.buobao.eie.entity.BaseEntity;
import com.buobao.eie.utils.Limit;

import java.util.List;

/**
 * Created by dqf on 2015/10/12.
 */
public interface BaseDao<T extends BaseEntity> {
    public T get(String id);
    public List<T> findByLimit(Limit limit);
    public void delete(String id);
    public void update(T entity);
    public void add(T entity);
}
