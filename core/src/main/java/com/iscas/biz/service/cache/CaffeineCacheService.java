package com.iscas.biz.service.cache;

import com.iscas.base.biz.util.CaffCacheUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/6 18:33
 * @since jdk1.8
 */
@Service
@ConditionalOnProperty(prefix = "spring.cache", name = "type", havingValue = "caffeine", matchIfMissing = true)
public class CaffeineCacheService<V> implements CacheService<V> {


    public void set(String cacheKey, V value) {
        CaffCacheUtils.set(cacheKey, value);
    }

    public V get(Class<V> clazz, String cacheKey) {
        return (V) CaffCacheUtils.get(cacheKey);
    }

    public void delete(String cacheKey) {
        CaffCacheUtils.remove(cacheKey);
    }

}
