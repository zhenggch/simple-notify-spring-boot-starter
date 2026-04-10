package com.zhenggch.notify;

import com.zhenggch.notify.impl.DingTalkNotifyService;
import com.zhenggch.notify.impl.FeishuNotifyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@EnableConfigurationProperties(NotifyProperties.class)
public class NotifyAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "simple.notify.dingtalk", name = "webhook")
    public NotifyService dingTalkNotifyService(NotifyProperties properties) {
        return new DingTalkNotifyService(properties.getDingTalk().getWebhook());
    }

    @Bean
    @ConditionalOnProperty(prefix = "simple.notify.feishu", name = "webhook")
    public NotifyService feishuNotifyService(NotifyProperties properties) {
        return new FeishuNotifyService(properties.getFeishu().getWebhook());
    }
}