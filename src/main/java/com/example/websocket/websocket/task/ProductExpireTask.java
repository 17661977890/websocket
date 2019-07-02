package com.example.websocket.websocket.task;


import com.example.websocket.commonutils.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

 
@Component
public class ProductExpireTask {

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

	@Scheduled(cron = "0 0 0 1/1 * ?")
	public void pushMsgExpire() {
		String oneDayExpireDate = DateUtil.getZeroTime(DateUtil.addOneDay());
		//推送消息只存在一天，根据到期时间将数据删除

	}
}