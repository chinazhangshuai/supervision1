package com.iscas.biz.model.common;

import lombok.Data;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/6 10:55
 * @since jdk1.8
 */
@Data
public class ScheduleTaskRequest {

    private String beanName;

    private String methodName;

    private Object params;

    private String cron;

}
