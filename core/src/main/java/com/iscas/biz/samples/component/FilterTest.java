package com.iscas.biz.samples.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/7 11:05
 * @since jdk1.8
 */
public class FilterTest extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //业务逻辑
//        System.out.println("*****FilterTest***** 这里写业务逻辑, uri: " + request.getServletPath());
        filterChain.doFilter(request, response);
    }
}
