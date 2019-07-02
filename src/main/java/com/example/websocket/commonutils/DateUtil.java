package com.example.websocket.commonutils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
import org.apache.commons.lang3.StringUtils;
 
/**
 * @Description 时间处理工具类 
 * @author bin
 */
public class DateUtil {

	private static final SimpleDateFormat dayOfDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private static final SimpleDateFormat secondOfDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * @return 当天时间加一天，返回"yyyy-MM-dd"格式
	 */
	public static String addOneDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return dayOfDateFormat.format(calendar.getTime());
	}

	/**
	 * @return 当天时间加一月，返回"yyyy-MM-dd"格式
	 */
	public static String addOneMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		return dayOfDateFormat.format(calendar.getTime());
	}

	/**
	 * @param dayNumber 加的天数
	 * @return 返回当天时间添加几天之后的时间, 返回"yyyy-MM-dd"格式
	 */
	public static String addFewDays(int dayNumber) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dayNumber);
		return dayOfDateFormat.format(calendar.getTime());
	}

	/**
	 * @param dateString 需要转换成时间格式的日期字符串
	 * @return 返回字符串转换成的时间
	 */
	public static Date stringToDate(String dateString) {
		ParsePosition parsePosition = new ParsePosition(0);
		if (dateString.contains(" ")) {
			return secondOfDateFormat.parse(dateString, parsePosition);
		} else {
			return dayOfDateFormat.parse(dateString, parsePosition);
		}
	}

	/**
	 * @param date 需要转换成字符串格式的日期
	 * @return 返回"yyyy-MM-dd"格式的转换后的字符串
	 */
	public static String dateToShotString(Date date) {
		return dayOfDateFormat.format(date);
	}

	/**
	 * @param date 需要转换成字符串格式的日期
	 * @return 返回"yyyy-MM-dd HH:mm:ss"格式的转换后的字符串
	 */
	public static String dateToLongString(Date date) {
		return secondOfDateFormat.format(date);
	}

	/**
	 * @param dateString 需要获取0点的时间字符串,如果获取当天0点,传null即可
	 * @return 返回"yyyy-MM-dd HH:mm:ss"格式的某天0点字符串
	 */
	public static String getZeroTime(String dateString) {
		if (StringUtils.isBlank(dateString)) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			return secondOfDateFormat.format(calendar.getTime());
		} else {
			Date date = stringToDate(dateString);
			return dateToLongString(date);
		}
	}
}