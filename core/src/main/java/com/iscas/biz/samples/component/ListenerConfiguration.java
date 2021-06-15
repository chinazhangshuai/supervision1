package com.iscas.biz.samples.component;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/7 12:01
 * @since jdk1.8
 */
@Configuration
public class ListenerConfiguration {

    @Bean
    public ServletListenerRegistrationBean listenerTestRegistrationBean(){
        ServletListenerRegistrationBean listenerRegistry = new ServletListenerRegistrationBean();
        listenerRegistry.setOrder(Ordered.HIGHEST_PRECEDENCE + 4);
        //注册监听器
        listenerRegistry.setListener(new ListenerTest());
        return listenerRegistry;
    }
}
