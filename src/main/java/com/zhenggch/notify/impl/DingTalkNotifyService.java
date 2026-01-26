package com.zhenggch.notify.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.zhenggch.notify.NotifyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 钉钉通知实现类
 */
@Slf4j
@RequiredArgsConstructor
public class DingTalkNotifyService implements NotifyService {

    // 钉钉机器人的 Webhook 地址
    private final String webhook;

    @Override
    public void send(String message) {
        try {
            // 1. 构建钉钉机器人需要的 JSON 参数
            // 参考文档：https://open.dingtalk.com/document/orgapp/custom-robot-access
            JSONObject json = new JSONObject();
            json.set("msgtype", "text");

            JSONObject text = new JSONObject();
            text.set("content", "Notify: " + message);
            json.set("text", text);

            // 2. 发送 HTTP POST 请求
            String result = HttpUtil.post(webhook, json.toString());

            // 3. 打印结果日志
            log.info("Send DingTalk message result: {}", result);
        } catch (Exception e) {
            log.error("Failed to send DingTalk message", e);
        }
    }
}