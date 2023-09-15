package kr.co.kmarket.etc;
/*
 * 	날짜 : 2023/09/14
 *  이름 : 이현정
 * 	내용 : 문자열 출력과 관련된 Utils 클래스 
 * 
 * */
import java.text.DecimalFormat;

public class Utils {
	
	public static String comma(String number) {
		int parsedNumber = Integer.parseInt(number);
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(parsedNumber);
	}
	
	public static String comma(int number) {
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(number);
	}
	
	public static String ellipsis(String str, int length) {
		return str.substring(0, length)+"...";
	}
}
