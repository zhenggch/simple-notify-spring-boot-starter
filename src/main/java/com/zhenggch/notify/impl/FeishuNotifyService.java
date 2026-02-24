package com.zhenggch.notify.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.zhenggch.notify.NotifyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 飞书/Lark 通知实现
 */
@Slf4j
@RequiredArgsConstructor
public class FeishuNotifyService implements NotifyService {

    private final String webhook;

    @Override
    public void send(String message) {
        try {
            // 飞书的 JSON 结构
            JSONObject json = new JSONObject();
            json.set("msg_type", "text");

            JSONObject content = new JSONObject();
            content.set("text", "Notify: " + message);
            json.set("content", content);

            String result = HttpUtil.post(webhook, json.toString());
            log.info("Send Feishu message result: {}", result);
        } catch (Exception e) {
            log.error("Failed to send Feishu message", e);
        }
    }
}