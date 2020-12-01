package com.sbs.selenium.exam;

public class Util {

	public static void sleep(int millis) {
		//설정된 millis초 단위 만큼 쉬는 것
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
