package com.xgy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String date2String(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
	
	public static String getYearDate(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
	}
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public static long getTimeStamp(){
		
		Date dates = new Date();
        
        long s=dates.getTime();
		
		return s/1000;
	}
	public static void main(String[] args) {
		int i = 1453335100;
		 i = (int) (getTimeStamp() - i) ;
		 System.out.println(i);
	}
}
