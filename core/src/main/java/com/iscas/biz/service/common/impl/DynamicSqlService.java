package com.iscas.biz.service.common.impl;

import com.iscas.biz.mp.mapper.DynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/6 15:56
 * @since jdk1.8
 */
@Service
public class DynamicSqlService {
    @Autowired
    private DynamicMapper dynamicMapper;

    public void dynamicInsert(String sql) {
        dynamicMapper.dynamicInsert(sql);
    }

    public void dynamicUpdate(String sql) {
        dynamicMapper.dynamicUpdate(sql);
    }

    public Map dynamicSelectOne(String sql) {
        return dynamicMapper.dynamicSelectOne(sql);
    }

    public List<Map> dynamicSelect(String sql) {
        return dynamicMapper.dynamicSelect(sql);
    }

    public void dynamicDelete(String sql) {
        dynamicMapper.dynamicDelete(sql);
    }

    public void dynamicSelectLargeData(String sql) {
        dynamicMapper.dynamicSelectLargeData(sql,
                resultContext -> {
                    Map one = (Map) resultContext.getResultObject();
                    //接着处理流式查询结果
                    System.out.println(one);
                });
    }

    public void dynamicBatch(List<String> sql) {
        dynamicMapper.dynamicBatch(sql);
    }


}
