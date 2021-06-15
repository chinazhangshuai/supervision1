package com.iscas.biz.samples;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.iscas.biz.mp.config.db.SqlSessionFactoryCustomizer;
import org.apache.ibatis.session.Configuration;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/7 14:05
 * @since jdk1.8
 * 自定义plugins、typeHandler、enumHandler等
 */
@Component
public class SqlSessionFactoryCustomizerPluginsTest implements SqlSessionFactoryCustomizer {
    @Override
    public void customize(Configuration configuration, FactoryBean sessionFactory) {
        if (sessionFactory instanceof MybatisSqlSessionFactoryBean) {
            MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = (MybatisSqlSessionFactoryBean) sessionFactory;
            //自定义插件
            //mybatisSqlSessionFactoryBean.setPlugins(new PageInterceptor(),new OptimisticLockerInterceptor());
        }
        //自定义插件
        //configuration.addInterceptor(new PageInterceptor());
    }
}