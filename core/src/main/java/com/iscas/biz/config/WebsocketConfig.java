package com.iscas.biz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2019/7/8 21:44
 * @since jdk1.8
 */
//@Configuration
public class WebsocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
