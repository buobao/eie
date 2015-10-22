package com.buobao.eie.redis;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dqf on 2015/10/20.
 */
public class RedisClient {
    private Jedis jedis;
    private JedisPool jedisPool;
    private ShardedJedis shardedJedis;
    private ShardedJedisPool shardedJedisPool;

    public RedisClient(){

    }

    private void initialPool(){
        //基本连接池配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config,"127.0.0.1",6379);
    }

    private void initialShardedPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);

        List<JedisShardInfo> shardInfoList = new ArrayList<JedisShardInfo>();
        shardInfoList.add(new JedisShardInfo("127.0.0.1",6379,"master"));

        //构造连接池
        shardedJedisPool = new ShardedJedisPool(config,shardInfoList);
    }
}




































