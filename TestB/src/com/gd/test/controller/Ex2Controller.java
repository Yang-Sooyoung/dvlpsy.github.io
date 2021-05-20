package com.gd.test.controller;

import com.gd.test.service.Ex2Service; //수족관 게임

public class Ex2Controller { // 어항구입, 물고기구입, 먹이주기. 자금확인

	public static void main(String[] args) { // 초기값, 어항 4개, 물고기 3, 자금 300원부터 시작
		Ex2Service g = new Ex2Service();
		
		g.fish_game();
	}
}