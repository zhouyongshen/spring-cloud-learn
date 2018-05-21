
视频地址：

06 第一个Ribbon程序

http://edu.51cto.com/center/course/lesson/index?id=202531

Ribbon

负载均衡框架 自持可插拔式的负载均衡规则(用在客户端的框架)

支持多种协议 入HTTP,UDP等

提供负载均衡客户端

Ribbon子模块

1. ribbon-core (负载均衡器)
2. ribbon-eureka
3. ribbon-httpclient

负载均衡器组件

一个负载均衡器，至少提供一下功能

1. 要维护各个服务器的IP信息
2. 根据特定的逻辑选取服务器

Ribbon的负载局衡器有三大子模块:

1. Rule
2. Ping
3. ServerList


    Ribbon-client 项目需要自eclipse工具下运行，在IDEA下不能正常运行。