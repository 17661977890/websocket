package com.example.websocket.websocketconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket配置类中
 */
@Configuration
public class WebSocketConfig {
    /**
     *  第一个配置是因为使用springboot内置容器，自己开发时需要配置，如果有独立的容器需要将其注释掉，
     * 也就意味着，如果将项目打成WAR包，部署到服务器，使用Tomcat启动时，需要注释掉ServerEndpointExporter配置；
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * MyEndpointConfigure配置是因为我的需求需要，需要在websocket类中注入service层或者dao层的接口，
     * MyEndpointConfigure配置就是为了解决websocket无法注入的问题，如果没有需要可以不用配置
     * @return
     */
    @Bean
    public MyEndpointConfigure newConfigure() {
        return new MyEndpointConfigure();
    }
}