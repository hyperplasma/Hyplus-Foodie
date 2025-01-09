# Hyplus Foodie


**Hyplus Foodie**（**神威食客**）是<a href="https://www.hyperplasma.top" target="_blank">Hyperplasma</a>旗下的一款开源的新型外卖服务系统，致力于为用户提供最为便捷的美食体验。通过其高效、可靠的设计，用户可以随时随地轻松下单，享受独具Hyperplasma风味的美食体验。无论是忙碌的工作日还是悠闲的周末，Hyplus Foodie都能满足您的用餐需求，让美食触手可及。

食客为神，美味双绝；佳肴无疆，享尽盛宴！

微信小程序客户端：<a href="https://github.com/Akira37R/Hyplus-Foodie-wxmp">Hyplus-Foodie-wxmp</a>

## 特点

- **用户友好的界面**: 提供直观的用户界面，使用户能够轻松浏览菜单、下单和支付。
- **高效的订单处理**: 使用高性能的订单处理系统，确保订单能够迅速准确地处理。
- **实时跟踪**: 用户可以实时跟踪他们的订单状态，包括订单准备、配送和预计送达时间。
- **多支付方式**: 支持多种支付方式，包括信用卡、PayPal等。
- **安全**: 实现了多层安全措施，确保用户数据和交易的安全性。
- **可扩展性**: 系统设计灵活，易于扩展和维护。
- **多语言支持**: 支持多种语言，提升用户体验。

## 技术栈

Hyplus-Foodie使用以下技术栈：

- **后端语言**: Java (JDK 11)
- **框架**: Spring Boot (2.5.4)
- **数据库**: MySQL (8.0)
- **构建工具**: Maven (3.8.1)
- **版本控制**: Git
- **容器化**: Docker (20.10)
- **持续集成/持续部署**: GitHub Actions
- **消息队列**: RabbitMQ
- **缓存**: Redis

## 安装和运行

### 系统要求

在运用本项目之前，请确保您的系统满足以下要求：

- Java 11 或更高版本
- Maven 3.8.1 或更高版本
- MySQL 8.0 或更高版本
- Docker 20.10 或更高版本
- Redis 6.0 或更高版本


### 克隆仓库

```sh
git clone https://github.com/Akira37R/Hyplus-Foodie.git
cd Hyplus-Foodie
```

### 配置数据

1. 创建一个新的MySQL数据库：参照`assets/database`目录下的数据库设计文档`design.md`，执行`init.sql`。
2. 修改`hyplus-server/src/main/resources`目录下的产品配置文件`application-prod.yml`，配置自定义字段（持久层、阿里云、Redis、小程序等）。
3. 确保`application.yml`中的`spring.profiles.active`为`prod`。

### 构建和运行

本地运行：

```sh
mvn clean install
mvn spring-boot:run
```

使用Docker：

```sh
docker build -t hyplus-foodie .
docker run -d -p 8080:8080 hyplus-foodie
```

本系统不含管理端前端框架，故需自行搭建调试入口，或效仿下述方式：

 * 通过ApiFox、Postman等工具测试请求响应，可导入`assets/YApi`目录中提供的用户端、管理端接口文档（格式为YApi`json`）。
 * 使用本系统内置的knife4j生成Api文档及在线接口调试页面，默认请求路径为`/doc.html`（浏览器中直接访问`localhost:8080/doc.html`）。

若要使用微信小程序客户端，请按要求部署<a href="https://github.com/Akira37R/Hyplus-Foodie-wxmp">Hyplus-Foodie-wxmp</a>，并自行设置APPID。


## 贡献

Hyplus Foodie欢迎任何形式的贡献，包括但不限于代码、文档、问题和建议。

## 许可证

[Apache License 2.0](hyplus-foodie-spring/LICENSE)

## 联系方式

如果您有任何问题或建议，请通过以下方式联系我们：

- Email: <u>akira37@foxmail.com</u>
- GitHub: https://github.com/Akira37R/Hyplus-Foodie
- Hyplus官网：https://www.hyperplasma.top
- 地址：浙江省杭州市拱墅区Hyperplasma广场三号楼12层

<img src="hyplus-foodie-spring/assets/hyperplasma_logo_v1_whitebg.png">

感谢您使用Hyplus-Foodie！