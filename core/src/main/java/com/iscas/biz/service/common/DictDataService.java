package com.iscas.biz.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iscas.biz.domain.common.DictData;

import java.util.List;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/2/25 16:12
 * @since jdk1.8
 */
public interface DictDataService extends IService<DictData> {

    boolean deleteByIds(List<Object> ids);

}
