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
	/*public static void main(String[] args) {
		System.out.println(date2String(new Date()));
	}*/
}
