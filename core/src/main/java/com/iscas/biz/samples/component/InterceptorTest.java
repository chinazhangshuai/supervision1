package com.iscas.biz.samples.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/7 11:18
 * @since jdk1.8
 */
public class InterceptorTest implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("*****InterceptorTest*****业务执行前, uri: " + request.getServletPath());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("*****InterceptorTest*****业务执行后, uri: " + request.getServletPath());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("*****InterceptorTest*****请求执行完成, uri: " + request.getServletPath());
    }
}
