package com.zjh.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	  * 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	  * 则返回的结果为2019-05-01 00:00:00
	 * @param src
	 * @return
	 */
	public static Date getDateByInitMonth(Date src){
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(src);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	 * 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	 * 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	 * @param src
	 * @return
	 */
	
	public static Date getDateByFullMonth(Date src){

		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(src);
		
		int month = calendar.get(Calendar.MONTH)+1;
		
		if(month==2) {
			calendar.set(Calendar.DAY_OF_MONTH, 28);
		}else if(month==4||month==6||month==9||month==11) {
			calendar.set(Calendar.DAY_OF_MONTH, 30);
		}else {
			calendar.set(Calendar.DAY_OF_MONTH, 31);
		}
		
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	
	
	
	public static void main(String[] args) {
		
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		/*
		 * Date dateByInitMonth = DateUtil.getDateByInitMonth(new Date());
		 * System.out.println(sdf.format(dateByInitMonth));
		 */
		 
		
		Date dateByFullMonth = DateUtil.getDateByFullMonth(new Date());
		System.out.println(sdf.format(dateByFullMonth));
	}
}
