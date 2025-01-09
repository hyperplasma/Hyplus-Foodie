# Hyplus Foodie

**Hyplus Foodie**（**神威食客**）是<a href="https://www.hyperplasma.top" target="_blank">Hyperplasma</a>旗下的一款开源的新型外卖服务系统，致力于为用户提供最为便捷的美食体验。通过其高效、可靠的设计，用户可以随时随地轻松下单，享受独具Hyperplasma风味的美食体验。无论是忙碌的工作日还是悠闲的周末，Hyplus Foodie都能满足您的用餐需求，让美食触手可及。

食客为神，美味双绝；佳肴无疆，享尽盛宴！




## 特点

- **用户友好的界面**: 提供直观的用户界面，使用户能够轻松浏览菜单、下单和支付。
- **高效的订单处理**: 使用高性能的订单处理系统，确保订单能够迅速准确地处理。
- **实时跟踪**: 用户可以实时跟踪他们的订单状态，包括订单准备、配送和预计送达时间。
- **多支付方式**: 支持多种支付方式，包括信用卡、PayPal等。
- **安全**: 实现了多层安全措施，确保用户数据和交易的安全性。
- **可扩展性**: 系统设计灵活，易于扩展和维护。
- **多语言支持**: 支持多种语言，提升用户体验。

## 克隆仓库

```sh
git clone https://github.com/Akira37R/Hyplus-Foodie-Ultimate.git
```

## 后端架构 hyplus-foodie-spring

### 技术栈

Hyplus Foodie后端（`hyplus-foodie-spring`）使用以下技术栈：

- **后端语言**: Java (JDK 11)
- **框架**: Spring Boot (2.5.4)
- **数据库**: MySQL (8.0)
- **构建工具**: Maven (3.8.1)
- **版本控制**: Git
- **容器化**: Docker (20.10)
- **持续集成/持续部署**: GitHub Actions
- **消息队列**: RabbitMQ
- **缓存**: Redis

### 安装和运行

#### 系统要求

在使用`hyplus-foodie-spring`之前，请确保您的系统满足以下要求：

- Java 11 或更高版本
- Maven 3.8.1 或更高版本
- MySQL 8.0 或更高版本
- Docker 20.10 或更高版本
- Redis 6.0 或更高版本

#### 配置数据

1. 创建一个新的MySQL数据库：参照`assets/database`目录下的数据库设计文档`design.md`，执行`init.sql`。
2. 修改`hyplus-foodie-spring/hyplus-server/src/main/resources`目录下的产品配置文件`application-prod.yml`，配置自定义字段（持久层、阿里云、Redis、小程序等）。
3. 确保`application.yml`中的`spring.profiles.active`为`prod`。

#### 构建和运行

```sh
cd Hyplus-Foodie-Ultimate/hyplus-foodie-spring
```

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

本系统暂不含管理端前端框架，故需自行搭建调试入口，或效仿下述方式：

 * 通过ApiFox、Postman等工具测试请求响应，可导入`assets/YApi`目录中提供的用户端、管理端接口文档（格式为YApi`json`）。
 * 使用本系统内置的knife4j生成Api文档及在线接口调试页面，默认请求路径为`/doc.html`（浏览器中直接访问`localhost:8080/doc.html`）。

## 微信小程序架构（用户端）hyplus-foodie-wxmp

### 技术栈

Hyplus Foodie微信小程序（`hyplus-foodie-wxmp`）使用以下技术栈：

- **前端语言**: JavaScript
- **框架**: 微信小程序开发框架
- **版本控制**: Git

### 安装和运行

#### 系统要求

在运用本项目之前，请确保您的系统满足以下要求：

- 微信开发者工具 2.24.2 或更高版本


### 配置小程序

```sh
cd Hyplus-Foodie-Ultimate/hyplus-foodie-wxmp
```

1. 打开微信开发者工具，点击“导入项目”，选择克隆的项目文件夹。
2. 可对配置文件`project.private.config.json`进行如下设置——

```json
{
  "setting": {
    "compileHotReLoad": true
  },
  "appid": "%YOUR-APPID%",  
  "description": "项目私有配置文件。此文件中的内容将覆盖 project.config.json 中的相同字段。项目的改动优先同步到此文件中。详见文档：https://developers.weixin.qq.com/miniprogram/dev/devtools/projectconfig.html"
}
```

其中`APPID`需在<a href="https://mp.weixin.qq.com/cgi-bin/wx?token=&lang=zhCN">微信公众平台</a>申请。

如有需要，可进一步配置项目的合法域名、业务域名等。

### 运行项目

1. 在<a href="https://developers.weixin.qq.com/miniprogram/dev/devtools/stable.html">微信开发者工具</a>中点击“编译”按钮。
2. 在模拟器中预览和调试小程序。


## 贡献

Hyplus Foodie欢迎任何形式的贡献，包括但不限于代码、文档、问题和建议。

## 许可证

[Apache License 2.0](LICENSE)

## 联系方式

如果您有任何问题或建议，请通过以下方式联系我们：

- Email: <u>akira37@foxmail.com</u>
- GitHub: https://github.com/Akira37R/Hyplus-Foodie-Ultimate
- Hyplus官网：https://www.hyperplasma.top
- 地址：浙江省杭州市拱墅区Hyperplasma广场三号楼12层

<img src="assets/hyperplasma_logo_v1_whitebg.png">

感谢您使用Hyplus-Foodie！