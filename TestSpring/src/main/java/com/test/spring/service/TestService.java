package com.test.spring.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TestService implements ITestService {

	@Override
	public String getLog(String msg) {
		return "LOG : "+ msg;
	}
	
	@Override
	public String getGugu(String dan) {
		String gugu = "";
		
		int d = Integer.parseInt(dan);
		
		for(int i = 1; i < 10; i++) {
			gugu += d + " * " + i + " = " + (d * i) + "<br/>";
		}
		
		return gugu;
	}

	@Override
	public List<Integer[]> getLotto(String jang) {
		List<Integer[]> lotto = new ArrayList<Integer[]>();
		
		for(int i = 0; i < Integer.parseInt(jang); i++) {
			Integer[] temp = new Integer[6];
		
			for(int j = 0; j < 6; j++) {
				temp[j] = (int)(Math.random() * 45) + 1;
				
				for(int k = 0; k < j; k++) {
					if(temp[k] == temp[j]) {
						j--;
						break;
					}
				}
			}
			lotto.add(temp);
		}
	return lotto;
	}
}



















