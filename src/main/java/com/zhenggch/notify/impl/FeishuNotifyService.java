package com.zhenggch.notify.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import lombok.RequiredArgsConstructor;

/**
 * 飞书/Lark 通知实现
 */
@RequiredArgsConstructor
public class FeishuNotifyService extends AbstractNotifyService {

    private final String webhook;

    @Override
    protected void doSend(String message) throws Exception {
        JSONObject json = new JSONObject();
        json.set("msg_type", "text");

        JSONObject content = new JSONObject();
        content.set("text", "Notify: " + message);
        json.set("content", content);

        HttpUtil.post(webhook, json.toString());
    }
}