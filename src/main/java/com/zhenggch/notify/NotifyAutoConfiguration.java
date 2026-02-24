package com.zhenggch.notify;

import com.zhenggch.notify.impl.DingTalkNotifyService;
import com.zhenggch.notify.impl.FeishuNotifyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NotifyProperties.class)
public class NotifyAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "simple.notify.dingtalk", name = "webhook")
    public NotifyService dingTalkNotifyService(NotifyProperties properties) {
        return new DingTalkNotifyService(properties.getDingTalk().getWebhook());
    }

    // 新增：当配置文件中有飞书的 webhook 时，自动注入飞书服务
    @Bean
    @ConditionalOnProperty(prefix = "simple.notify.feishu", name = "webhook")
    public NotifyService feishuNotifyService(NotifyProperties properties) {
        return new FeishuNotifyService(properties.getFeishu().getWebhook());
    }
}