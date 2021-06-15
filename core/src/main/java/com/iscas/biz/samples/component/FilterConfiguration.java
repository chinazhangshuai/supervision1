package com.iscas.biz.samples.component;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
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
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterTestRegistrationBean(){
        FilterRegistrationBean filterRegistry = new FilterRegistrationBean();
        filterRegistry.setOrder(Ordered.HIGHEST_PRECEDENCE + 3);
        //注册过滤器
        filterRegistry.setFilter(new FilterTest());
        filterRegistry.addUrlPatterns("/*");
        filterRegistry.setName("filterTest");
        return filterRegistry;
    }

}
