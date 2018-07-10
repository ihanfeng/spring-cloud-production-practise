# 一种用于生产实践的基于Spring Cloud的小型互联网应用架构

<a name="top"></a>

#### 目录

- [序言](#preface)
  - [相关技术](#technology)
  - [微服务](#microservice)
- [第一个微服务](#first-app)
  - [声明服务接口](#declare-api)

<a name="preface"></a>

## 序言

笔者最近一年在某个小微创业企业工作一年有余，在人力、资金、时间等各类资源制约下从零到一完成了一个涵盖微服务、APP、WEB以及SPA应用的小型互联网应用架构。在服务端，我们主要基于Spring Cloud框架来构建微服务体系，充分运用了多项技术在开发和运维的过程中，本文对这一年的Spring Cloud框架实践，从开发到生产做一个全方面的总结。

<a name="technology"></a>

### 相关技术

`Gitlab`, `Spring Boot`, `Spring Cloud`, `Maven`, `Nexus Oss Repository`, `Mysql`, `Mybatis`, `Redis`, `Elasticsearch`, `Rabbitmq`, `Reactjs`, `阿里云`, `Consul`, `Jenkins`, `Docker`, `Docker Swarm`

<a name="microservice"></a>

### 微服务

首先需要明确一下微服务解决什么问题。

在过去，当我们既没用户又没钱也没有人才的时候，我们只能做得起所谓的单体应用，典型的单体应用由一个运行于jvm的java应用程序和一个mysql数据库构成，它们也许分别运行于不同的主机/虚拟机上，也可能运行在同一个主机/虚拟机上，所有的业务处理和用户界面都交给该应用程序，所有的数据都存储到这个唯一的数据库。

然而当用户越来越多，数据量越来越大，需要的CPU运算能力、内存占用、磁盘空间、网络带宽也在不断上升，我们可以通过增加硬件的配置来提高系统的处理能力，但硬件配置的增加有其上限（例如当前能够买到的最强性能的服务器其CPU运算能力、内存、磁盘空间是有上限的），且超过一定阙值，增加硬件配置的成本呈几何级数上升。这就需要一种架构来帮助我们拆分系统，使得系统各个部分可以运行在多个不同的硬件上，并且能够互相协作，在不损失稳定性、性能、可靠性的前提下完成原有整体功能。

为了让系统的不同部分可以运行到不同的硬件上，就需要对系统进行拆分。通常，我们可以将原先的单体应用拆分成多个单体应用，即一个jvm应用和一个数据库拆分为多个jvm应用和多个数据库，如下图所示。

![single-to-multi](assets/images/single-to-multi.png)

我们将原先包含通用功能、账户功能、旅游业务和海淘业务的单体应用拆分为4个应用，并同时拆分原有的数据库。这样的拆分显著增加了架构的复杂性：不同业务表部署在不同的数据库内致使表连接将不再可用；原业务之间的方法调用变为网络API调用，需要考虑应用之间的网络连接、流量控制、网络延迟、网络失效等问题；应用数量的增多对运维也提出了更大挑战。

接下来，就来看看Spring Cloud框架及其生态圈如何帮助我们构建和维护这样的应用架构。

[【回到顶端】](#top)

<a name="first-app"></a>

## 第一个微服务

让我们来创建第一个微服务：common-service，一个包含了全部通用功能的微服务（日志、支付……），因为篇幅限制，仅在此演示日志功能。

最简单的方式是通过[SPRING INITIALIZR](https://start.spring.io)生成项目模板，在`Search for dependencies`输入框中输入`Cloud`，添加`Cloud Bootstrap`依赖后，点击`Generate Project`下载。

<a name="declare-api"></a>

### 声明服务接口

如前所述，服务调用是一种网络API调用，在Spring Cloud中一般为HTTP调用，通常来讲，需要我们编写客户端请求程序。但我们希望找到一种方式，可以满足如下条件：

* 由服务的实现者声明服务接口
* 服务的使用者可以清晰的查阅服务的接口说明
* 服务的使用者几乎不需要编写额外代码就可以像调用普通java方法一样调用服务
* 服务的声明可以有不同的版本

幸运的是，可以使用`Maven`和`Spring Cloud OpenFeign`来达成这样的目标，有关此话题，将在后文展开叙述，在`pom.xml`中声明`common-api`模块作为服务接口声明，声明`common-service`模块作为服务接口实现。

```xml
<!-- pom.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.github.richterplus</groupId>
    <artifactId>common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <modules>
        <module>common-api</module>
        <module>common-service</module>
    </modules>
    <packaging>pom</packaging>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Finchley.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <spring-boot.version>2.0.3.RELEASE</spring-boot.version>
    </properties>
</project>
```

我们在common-api模块中声明日志服务的接口

```java
//LogApi.java
package com.github.richterplus.common.api;

//省略import

/**
 * 日志API
 */
@RequestMapping("log")
public interface LogApi {

    /**
     * 添加日志记录
     */
    @ApiOperation("添加日志记录")
    @RequestMapping(method = RequestMethod.PUT, value = "append")
    AppendLogRes append(@RequestBody AppendLogReq req);
}
```

```java
//AppendLogReq.java
package com.github.richterplus.common.api.bean.log;

//省略import

/**
 * 添加日志请求
 */
public class AppendLogReq extends CommonApiReq {

    /**
     * 客户端id
     */
    @ApiModelProperty("客户端id")
    @NotNull
    @Size(max = 20)
    private String clientId;

    /**
     * 客户端版本号
     */
    @ApiModelProperty("客户端版本号")
    @NotNull
    @Size(max = 10)
    private String clientVersion;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @NotNull
    private Integer userId;

    /**
     * 日志类型
     */
    @ApiModelProperty("日志类型")
    @NotNull
    private Integer logType;

    /**
     * 对象id
     */
    @ApiModelProperty("对象id")
    @NotNull
    private List<Integer> objectIds;

    /**
     * 日志内容
     */
    @ApiModelProperty("日志内容")
    @NotNull
    private String message;

    //省略getter和setter
}
```

```java
//AppendLogRes.java
package com.github.richterplus.common.api.bean.log;

import com.github.richterplus.common.api.bean.CommonApiRes;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加日志响应
 */
public class AppendLogRes extends CommonApiRes {

    /**
     * 日志uuid
     */
    @ApiModelProperty("日志uuid")
    private String logUuid;

    //省略getter和setter
}
```

显而易见，接口定义为一个普通的java interface。

* 使用@RequestMapping注解定义接口访问的url
* 使用POJO定义输入和输出
* 使用JSR303注解约束输入项
* 使用@ApiOperation和@ApiModelProperty对方法和成员进行注释（这两个是SpringFox注解，可用于产生接口文档，稍后会演示如何使用）