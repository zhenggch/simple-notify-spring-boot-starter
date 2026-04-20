# Simple Notify Spring Boot Starter

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.x-green.svg)](https://spring.io/projects/spring-boot)
[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=zhenggch_simple-notify-spring-boot-starter)](https://sonarcloud.io/summary/new_code?id=zhenggch_simple-notify-spring-boot-starter)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=zhenggch_simple-notify-spring-boot-starter&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=zhenggch_simple-notify-spring-boot-starter)

A lightweight, extensible, and easy-to-use notification starter for Spring Boot applications. Ideally designed for sending system alerts, monitoring logs, or business notifications via various channels (DingTalk, Feishu, etc.) with minimal configuration.

## ✨ Features

## ✨ Features

* **Zero-Code Integration**: Just add dependency and configuration.
* **Multi-Channel Support**:
  * ✅ **DingTalk** (Supported)
  * ✅ **Feishu/Lark** (Supported)
  * 🚧 **Email** (Planned)
* **High Performance**: Native `@Async` support for non-blocking message delivery.
* **Extensible Architecture**: Easily implement your own `NotifyService`.

## 📦 Installation

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.zhenggch</groupId>
    <artifactId>simple-notify-spring-boot-starter</artifactId>
  <version>1.0.0</version>
</dependency>

```

## 🚀 Quick Start

### 1. Configure `application.yml`

Enable the service and configure your DingTalk Webhook:

```yaml
simple:
  notify:
    enabled: true
    dingtalk:
      webhook: [https://oapi.dingtalk.com/robot/send?access_token=YOUR_TOKEN](https://oapi.dingtalk.com/robot/send?access_token=YOUR_TOKEN)
    feishu:
      webhook: [https://open.feishu.cn/open-apis/bot/v2/hook/YOUR_FEISHU_TOKEN](https://open.feishu.cn/open-apis/bot/v2/hook/YOUR_FEISHU_TOKEN)

```

### 2. Inject and Use

Inject `NotifyService` in your business logic:

```java
@Service
@RequiredArgsConstructor
public class UserService {

    private final NotifyService notifyService;

    public void register(User user) {
        // Business logic...
        
        // Send notification
        notifyService.send("New user registered: " + user.getName());
    }
}

```

## 🛠 Building from Source

```bash
git clone [https://github.com/zhenggch/simple-notify-spring-boot-starter.git](https://github.com/zhenggch/simple-notify-spring-boot-starter.git)
cd simple-notify-spring-boot-starter
mvn clean install

```

## 📄 License

This project is licensed under the [Apache 2.0 License](https://www.google.com/search?q=LICENSE).

## 🤝 Contributing

Contributions, issues and feature requests are welcome!
Feel free to check the [issues page](https://github.com/zhenggch/simple-notify-spring-boot-starter/issues) if you want to contribute.