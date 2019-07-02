package com.example.websocket.websocket.task;


import com.example.websocket.commonutils.DateUtil;
import com.example.websocket.websocket.server.WebSocketServer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class ProductExpireTask {
	@Autowired
	private WebSocketServer2 webSocketServer2;

	//每天早上0点执行
	@Scheduled(cron = "0 0 0 1/1 * ?")
	public void productExpire() {
		//距离到期还有一个月提醒
		String oneMonthExpireDate = DateUtil.addOneMonth();
		dealExpireProduct(oneMonthExpireDate);

		//距离到期还有一天提醒
		String oneDayExpireDate = DateUtil.addOneDay();
		dealExpireProduct(oneDayExpireDate);

		//距离到期还有一周提醒
		String oneWeekExpireDate = DateUtil.addFewDays(7);
		dealExpireProduct(oneWeekExpireDate);
	}

	private void dealExpireProduct(String expireDate) {
		//todo 推送逻辑代码---根据具体业务场景来写
	}

	/**
	 * 模拟定时任务服务端主动给某个用户发送信息
	 * 每5秒执行一次
	 */
	@Scheduled(cron = "*/5 * * * * ?")
	public void sendMessage() {
		String message = "你好";
		Session session = webSocketServer2.getSession("bin");
		if(session!=null){
			try {
				webSocketServer2.sendMessage(session, String.valueOf(new TextMessage(message)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}