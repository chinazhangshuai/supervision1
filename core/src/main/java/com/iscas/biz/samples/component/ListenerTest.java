package com.iscas.biz.samples.component;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 启动启动后监听
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2019/1/24 8:48
 * @since jdk1.8
 */
public class ListenerTest implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
//        System.out.println("*****ListenerTest***** 回复响应后销毁, uri: " + request.getServletPath());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
//        System.out.println("*****ListenerTest***** 接收请求后初始化, uri: " + request.getServletPath());
    }
}

