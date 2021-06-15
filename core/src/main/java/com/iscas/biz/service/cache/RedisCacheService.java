package com.iscas.biz.service.cache;

import com.iscas.base.biz.util.CaffCacheUtils;
import com.iscas.common.redis.tools.ConfigInfo;
import com.iscas.common.redis.tools.JedisConnection;
import com.iscas.common.redis.tools.RedisInfo;
import com.iscas.common.redis.tools.impl.JedisClient;
import com.iscas.common.redis.tools.impl.standalone.JedisStandAloneConnection;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/6 18:33
 * @since jdk1.8
 */
@Service
@ConditionalOnProperty(prefix = "spring.cache", name = "type", havingValue = "redis", matchIfMissing = false)
public class RedisCacheService<V> implements CacheService<V>{

    private static JedisClient jedisClient = null;

    static {
        try {
            JedisConnection jedisConnection = new JedisStandAloneConnection();
            ConfigInfo configInfo = new ConfigInfo();
            configInfo.setMaxIdle(10);
            configInfo.setMaxTotal(50);
            configInfo.setMaxWait(20000);
            RedisInfo redisInfo = new RedisInfo();
            redisInfo.setHost("localhost");
            redisInfo.setPort(6379);
//        redisInfo.setPwd("iscas");
            redisInfo.setTimeout(10000);
            configInfo.setRedisInfos(Arrays.asList(redisInfo));
            jedisClient = new JedisClient(jedisConnection, configInfo);
        } catch (Exception e) {

        }
    }


    public void set(String cacheKey, Object value) {
        try {
            jedisClient.del(cacheKey);
            jedisClient.set(cacheKey, value, 123);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public V get(Class<V> clazz, String cacheKey) {
        V v = null;
        try {
            v = jedisClient.get(clazz, cacheKey);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return v;
    }

    public void delete(String cacheKey) {
        try {
            jedisClient.del(cacheKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CaffCacheUtils.remove(cacheKey);
    }
}
