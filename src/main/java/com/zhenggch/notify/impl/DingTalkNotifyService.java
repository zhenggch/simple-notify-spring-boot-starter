package com.zhenggch.notify.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import lombok.RequiredArgsConstructor;

/**
 * 钉钉通知实现类
 */
@RequiredArgsConstructor
public class DingTalkNotifyService extends AbstractNotifyService {

    private final String webhook;

    @Override
    protected void doSend(String message) throws Exception {
        JSONObject json = new JSONObject();
        json.set("msgtype", "text");

        JSONObject text = new JSONObject();
        text.set("content", "Notify: " + message);
        json.set("text", text);

        // 发送请求，异常和日志交由父类统一处理
        HttpUtil.post(webhook, json.toString());
    }
}