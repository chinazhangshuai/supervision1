package com.iscas.biz.samples;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 如有要看例子，请打开注释
 *
 **/
@RestController
@Api(tags = "测试-websocket")
public class WebsocketControllerTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //spring提供的发送消息模板
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private SimpUserRegistry userRegistry;
    //暂时用一个固定的线程池做示例
    private ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
    private ScheduledFuture<?> p2pSF = null;
    private ScheduledFuture<?> broadcastSF = null;

    /*点对点通信*/
    @MessageMapping(value = "/queue")
    @ApiOperation(value = "点对点", notes = "测试点对点推送")
    public void templateTest(Principal principal) {
        logger.info("当前在线人数:" + userRegistry.getUserCount());
        int i = 1;
        for (SimpUser user : userRegistry.getUsers()) {
            logger.info("用户" + i++ + "---" + user);
        }

        //发送消息给指定用户
        //模拟启动一个定时任务去推送数据
        if (p2pSF != null) {
            p2pSF.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(() -> {
            if (userRegistry.getUser(principal.getName()) != null) {
                messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/message", "服务器主动推送一个点对点消息，随机数:" + Math.random());
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
        p2pSF = scheduledFuture;
    }

    /*广播*/
    @MessageMapping("/topic")
    @ApiOperation(value = "广播", notes = "测试广播推送")
    public void topic() throws Exception {
        if (broadcastSF != null) {
            broadcastSF.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(() -> {
            messagingTemplate.convertAndSend("/topic/message", "服务器主动推送一个广播消息，随机数:" + Math.random());
        }, 1000, 1000, TimeUnit.MILLISECONDS);
        broadcastSF = scheduledFuture;
    }

}
