package com.buobao.eie.dao;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * Created by dqf on 2015/10/20.
 */
public abstract class AbstractBaseRedisDao<K,V> {
    @Resource
    protected StringRedisTemplate jedisTemplate;

    public void setJedisTemplate(StringRedisTemplate jedisTemplate){
        this.jedisTemplate = jedisTemplate;
    }

}
