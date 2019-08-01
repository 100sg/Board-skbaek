package com.skbaek.board.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Util {
	
	public static Date getNow() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	
	public static Date getNowToDate(String pattern, String timezone) throws ParseException, Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		
		return dateFormat.parse(dateFormat.format(new Date()));
	}
}
