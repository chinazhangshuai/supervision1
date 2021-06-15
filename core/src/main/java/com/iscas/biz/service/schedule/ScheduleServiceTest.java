package com.iscas.biz.service.schedule;

import org.springframework.stereotype.Service;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/6 10:47
 * @since jdk1.8
 */
@Service
public class ScheduleServiceTest {

    /**
     * 定时任务执行的方法
     */
    public void scheduleMethodTest(String param){
        System.out.println("执行一次定时任务，参数：" + param);
    }
}
