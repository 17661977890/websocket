# websocket
springboot 整合websocket实现消息推送（主动推送，具体用户推送，群发，定时推送）

* Spring Boot 开发私有即时通信系统（WebSocket）：https://www.jianshu.com/p/0f498adb3820  项目地址：https://gitee.com/anoyi/anyim

* 使用WebSocket构建交互式Web应用程序
本指南将引导您完成创建“hello world”应用程序的过程，该应用程序在浏览器和服务器之间来回发送消息。WebSocket是一个非常薄，轻量级的TCP层。它使得非常适合使用“子协议”来嵌入消息。在本指南中，我们将深入研究并使用Spring的STOMP消息来创建交互式Web应用程序。
https://spring.io/guides/gs/messaging-stomp-websocket/

## 原理图解（与传统http请求差异）

![image](http://dl2.iteye.com/upload/attachment/0130/1491/f14c9efc-07f6-3fcd-bdf7-faf2ebf0f6ae.png)


##使用websocket有两种方式：
* 1是使用sockjs，
* 2是使用h5的标准。使用Html5标准自然更方便简单，所以记录的是配合h5的使用方法（有两个案例，两个websocketserver类，分别对应不同的html页面 ）

* 案例2 是针对不同用户来测试webscoket的几个方法

## pom
* 核心是@ServerEndpoint这个注解。这个注解是Javaee标准里的注解，tomcat7以上已经对其进行了实现，
  如果是用传统方法使用tomcat发布项目，只要在pom文件中引入javaee标准即可使用。
  
      <dependency>
        <groupId>javax</groupId>
        <artifactId>javaee-api</artifactId>
        <version>7.0</version>
        <scope>provided</scope>
      </dependency>
      
* 但使用springboot的内置tomcat时，就不需要引入javaee-api了，spring-boot已经包含了。使用springboot的websocket功能首先引入springboot组件

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-websocket</artifactId>
            <version>1.3.5.RELEASE</version>
        </dependency>
     
* 顺便说一句，springboot的高级组件会自动引用基础的组件，像spring-boot-starter-websocket就引入了spring-boot-starter-web和spring-boot-starter，所以不要重复引入。


## 配置类（WebSocketConfig）
* 使用@ServerEndpoint创立websocket endpoint [配置端点类以及具体实现：WebSocketServer]
  首先要注入ServerEndpointExporter，这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint。
  要注意，如果使用独立的servlet容器，而不是直接使用springboot的内置容器，就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理
  
## 测试 案例1
* 1、启动项目
* 2、浏览器输入http://localhost:8080/websocket.html
* 3、可以打开多个页面，后台控制台会答应当前在线人数的变化

## 测试 案例2
* 1、访问 http://localhost:8080/index.html 和 http://localhost:8080/client.html 分别打开两个页面并连接到websocket，
* 2、http://localhost:8080/socket?userName=lily&message=helloworld 给lily发送消息，
* 3、http://localhost:8080/webSocket/socket/all?message=hello,大家好 群发消息，给在线的所有人
![image](https://github.com/17661977890/websocket/blob/master/src/main/resources/image/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190702135004.png)
![image](https://github.com/17661977890/websocket/blob/master/src/main/resources/image/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190702135058.png)

* 定时任务发送消息：
![image](https://github.com/17661977890/websocket/blob/master/src/main/resources/image/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190702150146.png)
