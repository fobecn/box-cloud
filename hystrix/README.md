Hystrix 隔离

# 简单描述
Hystrix 并非治理服务，而是一种嵌入在为服务，对方法或线程异常时隔离改方法或线程。


# 相关角色及流程
* 生产者-由生产者统一对隔离自行处理
* 消费者
* Hystrix 信息聚合
* 注册中心

# 约定
* 我们正常情况只使用默认值，并兼容默认值

# 测试
```
#监控台
http://localhost:8762/hystrix  —— 输入
http://localhost:8762/actuator/hystrix.stream


#2秒超时，20次刷新后，只走fallback方法
http://localhost:8762/stores/1/timeout

# 2分之一失败，10秒内失败 20 次后 5秒内只走fallBack
http://localhost:8762/stores/1

```

# 相关代码
https://github.com/fobecn/box-cloud.git

# 参考
* https://www.jianshu.com/p/efb049107572
* https://www.cnblogs.com/leeSmall/p/8847652.html
* http://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.0.0.RELEASE/single/spring-cloud-netflix.html#_hystrix_timeouts_and_ribbon_clients