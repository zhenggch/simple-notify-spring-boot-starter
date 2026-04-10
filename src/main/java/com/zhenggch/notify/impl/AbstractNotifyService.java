package com.zhenggch.notify.impl;

import com.zhenggch.notify.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

/**
 * 通知服务抽象基类
 * 统一处理异常捕获和日志打印
 */
@Slf4j
public abstract class AbstractNotifyService implements NotifyService {

    @Async
    @Override
    public void send(String message) {
        String channelName = this.getClass().getSimpleName();
        try {
            // 调用子类的具体发送逻辑
            doSend(message);
            log.info("Successfully sent message via {}", channelName);
        } catch (Exception e) {
            log.error("Failed to send message via {}", channelName, e);
        }
    }

    /**
     * 执行具体的发送逻辑，由子类实现
     *
     * @param message 消息内容
     * @throws Exception 发送过程中可能抛出的异常
     */
    protected abstract void doSend(String message) throws Exception;
}