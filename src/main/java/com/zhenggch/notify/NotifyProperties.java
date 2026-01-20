package com.zhenggch.notify;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "simple.notify")
public class NotifyProperties {
    private boolean enabled = true;
    private DingTalk dingTalk = new DingTalk();

    @Data
    public static class DingTalk {
        private String webhook;
        private String secret;
    }
}