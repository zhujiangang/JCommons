package org.jcommons.common;

public class StringTypeUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return
	 */
	//方法1，使用自带的
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	//方法2，使用ascii码
//	public static boolean isNumeric(String str) {
//		for (int i = str.length(); --i >= 0;) {
//			int chr = str.charAt(i);
//			if (chr < 48 || chr > 57)
//				return false;
//		}
//		return true;
//	}
//
	//方法3，使用正则
//	public static boolean isNumeric(String str) {
//		Pattern pattern = Pattern.compile("[0-9]*");
//		return pattern.matcher(str).matches();
//	}
//
	//方法4，使用异常
//	public static boolean isNumeric(String str) {
//		try {
//			Integer.parseInt(str);
//			return true;
//		} catch (Exception ex) {
//			return false;
//		}
//	}
}
