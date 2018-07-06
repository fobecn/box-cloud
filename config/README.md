# 目的 Preview
* 统一Spring Cloud 环境配置管理

# 作用 Effect
* 让聚群的微服务统一配置 (Make micro service config together)
* 统一环境拆分，让开发，测试，生产简易拆分。

# 实操 Hands on
* 由于比较简单我可以把所有代码贴出来

## 配置服务 Config server
pom.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>box-cloud</artifactId>
        <groupId>cn.hitstone</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>config</artifactId>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-config</artifactId>
                <version>2.0.0.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
    </dependencies>


</project>
```
application.xml
```
server:
  port: 8888 #能默认就默认原则,微服开启配置后默认端口
spring:
  application:
    name: config
  profiles:
      active: native
info:
  version: "0.1.0"
logging:
  level:
    root: INFO
    org.springframework.web: INFO
  file: config.log


```

eureka-default.yml
```
config:
  name: eureka
server:
  port: 8761
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

ConfigApplication.java

```
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
```

## 验证
 启动验证
```
curl "http://localhost:8888/eureka/default"
 ```

## Config client
* 本次测试依赖eureka 注册中心，可考察我下一章节。

# 相关代码
* https://github.com/fobecn/box-cloud.git

# 参考
* http://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.0.0.RELEASE/

