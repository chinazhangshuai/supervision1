package com.iscas.biz.service.cache;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/7 9:09
 * @since jdk1.8
 */
public interface CacheService<V> {

    void set(String cacheKey, V value);

    V get(Class<V> clazz,String cacheKey);

    void delete(String cacheKey);
}
