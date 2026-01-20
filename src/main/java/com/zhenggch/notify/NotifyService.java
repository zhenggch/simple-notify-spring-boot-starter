package com.zhenggch.notify;

public interface NotifyService {
    /**
     * 发送简单的文本消息
     * @param message 消息内容
     */
    void send(String message);
}
