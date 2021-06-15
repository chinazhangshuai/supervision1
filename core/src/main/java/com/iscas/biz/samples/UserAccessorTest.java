package com.iscas.biz.samples;

import com.iscas.base.biz.config.Constants;
import com.iscas.base.biz.config.stomp.UserAccessor;
import com.iscas.base.biz.model.auth.User;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/7 15:11
 * @since jdk1.8
 * 自定义websocket连接时，保存用户信息的方式
 */
@Component
public class UserAccessorTest implements UserAccessor {
    @Override
    public void accessor(Message<?> message, StompHeaderAccessor accessor) {
        Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
        if (raw instanceof Map) {
            Object name = ((Map)raw).get(Constants.TOKEN_KEY);
            if (name instanceof List) {
                User user = new User();
                user.setUsername(((List)name).get(0).toString());
                accessor.setUser(user);
            }
        }
    }
}
