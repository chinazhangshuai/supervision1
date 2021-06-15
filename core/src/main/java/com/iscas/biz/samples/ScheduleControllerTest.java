package com.iscas.biz.samples;

import com.iscas.base.biz.schedule.CronTaskRegister;
import com.iscas.base.biz.schedule.SchedulingRunnable;
import com.iscas.biz.model.common.ScheduleTaskRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/5 17:50
 * @since jdk1.8
 */
@RestController
@RequestMapping("/schedule")
@Api(tags = "定时任务")
public class ScheduleControllerTest {

    @Autowired
    private CronTaskRegister cronTaskRegister;

    /**
     * 请求参数json示例：
     * {
     * "beanName": "scheduleServiceTest",
     * "cron": "0/10 * * * * ?",
     * "methodName": "scheduleMethodTest",
     * "params": "测试参数"
     * }
     */
    @PostMapping("/submitTask")
    @ApiOperation(value = "定时任务", notes = "测试定时任务")
    public void submitTask(@RequestBody ScheduleTaskRequest scheduleTaskRequest) {
        SchedulingRunnable task = new SchedulingRunnable(scheduleTaskRequest.getBeanName(), scheduleTaskRequest.getMethodName(), scheduleTaskRequest.getParams());
        //每30S执行一次任务
        cronTaskRegister.addCronTask("test_task", task, scheduleTaskRequest.getCron());
    }
}
