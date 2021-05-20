package com.gd.test.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.gd.test.service.TestService3;

public class TestController5 { //캘린더 속성 가져오기, 오류, 예외


	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		// syso + ctrl + space : 프린트린 나옴
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)); // jan: 0, fed:1, mar:2 ...
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); //일 : 1 ~ 토 : 7 
		
		System.out.println(c.get(Calendar.AM_PM)); // AM : 0, PM : 1

		System.out.println(c.get(Calendar.HOUR)); // 12시간 기준
		System.out.println(c.get(Calendar.HOUR_OF_DAY)); // 24시간 기준
		System.out.println(c.get(Calendar.MINUTE)); // 몇 분
		System.out.println(c.get(Calendar.SECOND)); // 몇 초
		System.out.println(c.get(Calendar.MILLISECOND)); // ..? 엄청 작은 초?

		System.out.println(c.get(Calendar.DAY_OF_YEAR)); // 1년 중 몇번째 날인지
		System.out.println(c.get(Calendar.WEEK_OF_MONTH)); // 1달 중 몇번째 주인지
		System.out.println(c.get(Calendar.WEEK_OF_YEAR)); // 1년 중 몇번째 주인지
		
		Date d = new Date(); // ?
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 ss초");
		
		// y : 년도 yy(2자리) yyyy(4자리)
		// M : 월
		// d : 일
		// E : 요일
		// a : 오전/오후
		// H : 시(24시간기준)
		// h : 시(12시간기준)
		// m : 분
		// s : 초
		// S : 밀리초
		// w : 연도기준 몇번쨰 주
		// W : 월기준 몇번째 주
		// D : 연도기준 몇번째 일
		
		System.out.println(f.format(d));
		
		// 오늘은 ~~~~년도의 ~번째 주 ~요일 입니다.
		// 현재 시각은 오전 ~~시 ~~분 입니다.
		
		f = new SimpleDateFormat("오늘은 yyyy년도의 w번쨰 주 E요일 입니다.");
		System.out.println(f.format(d));
		f = new SimpleDateFormat("현재 시각은 a HH시 mm분 입니다.");
		System.out.println(f.format(d));
		
		try {
			System.out.println("시도하다");
//			int[] arr = new int[4];
//			System.out.println(arr[4]);
			
			throw new IOException(); // IO간에 발생할수 있는 예외 던짐, 예외 강제로 발생시킴
			
//			int a = Integer.parseInt("abc");
//			System.out.println("정상종료");
			
		} catch (NumberFormatException ne) {
			System.out.println("예외발생 : " + ne.toString());
			
			ne.printStackTrace();
			
		} catch(Exception e) {
			System.out.println("예외발생 : " + e.toString());
		}

		System.out.println("예외처리 이후");
	
		TestService3 ts = new TestService3();
		
		try {
			ts.test();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
	}

}