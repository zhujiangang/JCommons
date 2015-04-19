package org.jcommons.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	
	public static String parseDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static String parseDate(Date date){
		return parseDate(date, "yyyy:MM:dd hh:mm:ss");
	}
}
