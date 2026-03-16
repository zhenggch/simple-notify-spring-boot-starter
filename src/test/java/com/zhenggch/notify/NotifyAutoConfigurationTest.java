package com.zhenggch.notify;

import com.zhenggch.notify.impl.DingTalkNotifyService;
import com.zhenggch.notify.impl.FeishuNotifyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class NotifyAutoConfigurationTest {

    // 模拟 Spring Boot 启动上下文
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(NotifyAutoConfiguration.class));

    @Test
    void dingTalkServiceShouldBeConfigured() {
        this.contextRunner
                // 模拟配置文件里只配了钉钉的 webhook
                .withPropertyValues("simple.notify.dingtalk.webhook=https://oapi.dingtalk.com/robot/send?access_token=test")
                .run((context) -> {
                    // 断言：上下文中应该包含钉钉的 Bean，但不包含飞书的 Bean
                    assertThat(context).hasSingleBean(DingTalkNotifyService.class);
                    assertThat(context).doesNotHaveBean(FeishuNotifyService.class);
                });
    }

    @Test
    void feishuServiceShouldBeConfigured() {
        this.contextRunner
                // 模拟配置文件里只配了飞书的 webhook
                .withPropertyValues("simple.notify.feishu.webhook=https://open.feishu.cn/open-apis/bot/v2/hook/test")
                .run((context) -> {
                    // 断言：上下文中应该包含飞书的 Bean，但不包含钉钉的 Bean
                    assertThat(context).hasSingleBean(FeishuNotifyService.class);
                    assertThat(context).doesNotHaveBean(DingTalkNotifyService.class);
                });
    }
}