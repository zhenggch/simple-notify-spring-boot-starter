package com.zhenggch.notify;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "simple.notify")
public class NotifyProperties {
    private boolean enabled = true;
    private DingTalk dingTalk = new DingTalk();
    private Feishu feishu = new Feishu(); // 新增这行

    @Data
    public static class DingTalk {
        private String webhook;
        private String secret;
    }

    // 新增飞书配置内部类
    @Data
    public static class Feishu {
        private String webhook;
        private String secret;
    }
}