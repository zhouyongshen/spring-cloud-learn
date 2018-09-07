项目模块说明

1. spring-zuul-server Eureka服务
2. spring-zuul-getway zuul网关
3. spring-zuul-member 会员模块（为销售模块提供查询会员的功能）
4. spring-zuul-sale 销售模块

直接调用会员模块：
http://localhost:8082/member/

通过销售模块调用：
http://localhost:8081/food-sale

通过网关调用
http://localhost:9000/sale/food-sale
