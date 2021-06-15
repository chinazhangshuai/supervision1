package com.iscas.biz.samples.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/7 11:28
 * @since jdk1.8
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration iRegistration = registry.addInterceptor(new InterceptorTest());
        iRegistration.addPathPatterns("/**");
        System.out.println("注册拦截器");
    }
}
