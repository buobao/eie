package com.buobao.eie.dao;

import com.buobao.eie.entity.TestEntity;
import com.buobao.eie.utils.Limit;

import java.util.List;

/**
 * Created by dqf on 2015/10/10.
 */
public interface TestEntityDao {
    public Object get(String id);
    public List<TestEntity> findByLimit(Limit limit);
    public void delete(String id);
    public void update(TestEntity testEntity);
    public void add(TestEntity testEntity);
}
