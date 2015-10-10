package com.buobao.eie.service;

import com.buobao.eie.dao.TestEntityDao;
import com.buobao.eie.entity.TestEntity;
import com.buobao.eie.utils.Limit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dqf on 2015/10/10.
 */
@Service
public class TestEntityServiceImpl implements TestEntityService {
    @Resource
    private TestEntityDao testEntityDao;

    public Object get(String id) {
        return testEntityDao.get(id);
    }

    public List<TestEntity> findByLimit(Limit limit) {
        return testEntityDao.findByLimit(limit);
    }

    public void delete(String id) {
        testEntityDao.delete(id);
    }

    public void update(TestEntity testEntity) {
        testEntityDao.update(testEntity);
    }

    public void add(TestEntity testEntity) {
        testEntityDao.add(testEntity);
    }
}
