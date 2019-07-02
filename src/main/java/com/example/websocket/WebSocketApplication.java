package com.example.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling 注解：开启定时任务
 */
@EnableScheduling
@SpringBootApplication
public class WebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketApplication.class, args);
	}

}
