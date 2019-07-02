package com.example.websocket.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 在SpringBoot2.0及Spring 5.0 WebMvcConfigurerAdapter已被废弃，目前找到解决方案就有
 * 1 直接实现WebMvcConfigurer （官方推荐）
 * 2 直接继承WebMvcConfigurationSupport
 * @ https://blog.csdn.net/lenkvin/article/details/79482205
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 为各个页面提供路径映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/client").setViewName("client");
        registry.addViewController("/index").setViewName("index");
    }
}