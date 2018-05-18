# Spring boot的使用

> 视频地址：http://edu.51cto.com/center//course/lesson/index?id=202535

1. SpringBoot 可以快速构建项目

2. Springboot 读取配置文件的顺序

springboot 读取application.yml的顺序为

运行目录下config/下  > 运行目录下 > classpath:resources/config/下  > classpath:/下

启动后可以访问

http://localhost:8080/prop

http://localhost:8080/name

也可以自定义配置文件路径

http://localhost:8080/project

自定义路径对.yml文件支持的不是很好（原因未知）


启动时指定配置文件路径 com.zys.spring.MyConfigApp

http://localhost:8080/abcPro

http://localhost:8080/abcYml

* 参考文章

* [springboot读取配置文件](https://blog.csdn.net/freyaalisa/article/details/78837184)

* [Spring Boot 配置文件 – 在坑中实践](http://www.spring4all.com/article/267)

