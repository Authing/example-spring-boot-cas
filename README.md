# Spring Security CAS 后端服务

- [集成介绍](#集成介绍)
- [项目搭建](#项目搭建)
- [配置文件](#配置文件)
- [运行测试](#运行测试)


### 集成介绍

> 单点登录 (Single sign on)，英文名称缩写 SSO，SSO 的意思就是在多系统的环境中，登录单方系统，就可以在不用再次登录的情况下访问相关受信任的系统。也就是说只要登录一次单体系统就可以。

> Authing CAS 就是 SSO 解决方案的一种具体实现方式，即在多个系统中，用户只需要到一个中央服务器登录一次即可访问这些系统中的任何一个，无须多次登录。
> 并且支持多种认证机制、安全策略、支持授权以及提供高可用性的方式。不需要客户关注于如何实现 CAS Server，如何配置 HTTPS，如何配置各种繁琐的配置文件，以及如何提供个性化的登录，登出的页面等等
> Authing 简化配置流程，为用户提供一站式应用集成，用户只需要在平台自行配置各种需要的方式即可


### 项目搭建

方式一：使用 Spring Initializr 快速构建项目

打开 IDEA，点击 New Project 创建一个新项目，选择 Spring Initializr 创建一个 Spring Boot 项目，输入项目的 Group 以及 Artifact 信息

添加 Spring Web, Spring Security 依赖

另外，集成过程中需要在 pom.xml 中需要添加一些其他的依赖包，如下：

```yaml
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </dependency>

        <dependency>
            <groupId>net.unicon.cas</groupId>
            <artifactId>cas-client-autoconfig-support</artifactId>
            <version>2.3.0-GA</version>
        </dependency>

        <!--远程调用接口使用-->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.7.11</version>
        </dependency>
    </dependencies>
```

### 配置文件

找到 src/main/resources/application.properties，将其重命名为 application.yml，并添加如下内容：

```yaml
server:
port: 9999

cas:
server-url-prefix: {替换为你的 server-url-prefix，如：https://cjtjls-demo.authing.cn/cas-idp/61319680ea8b30c9ca9ca071}
server-login-url: {替换为你的 server-login-url，如：https://cjtjls-demo.authing.cn/cas-idp/61319680ea8b30c9ca9ca071/login}
client-host-url: {替换为你的 client-host-url，如：http://localhost:9999/}
validation-url-patterns:
- /**
```

需要将这里的 {server-url-prefix}、{server-login-url}、{client-host-url} 替换成应用中的实际信息

### 运行测试

一切准备就绪了，现在启动项目并访问 `http://localhost:9999`，即可看到 Authing 登录窗口，登录成功后，页面可以查看到返回的用户信息



