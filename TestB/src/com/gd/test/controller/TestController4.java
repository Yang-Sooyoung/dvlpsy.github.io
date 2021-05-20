package com.gd.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestController4 { //리스트, 해쉬맵

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		// add(값) : 값 추가
		list.add("가나다");
		list.add("라마바");
		list.add("사아자");

		for (int i = 0; i < list.size(); i++) {
			// get(인덱스번호) : 인덱스 번호에 해당하는 값 취득
			System.out.println(list.get(i));
		}
		// remove(인덱스번호) : 인덱스번호에 해당하는 내용을 삭제 후 뒤의 내용들을 당겨옴
		list.remove(1);
		System.out.println(list.size());
		System.out.println(list.get(1));

		// add(인덱스번호, 값) : 인덱스번호에 해당하는 위치에 값을 끼워넣음
		list.add(1, "차카타");
		System.out.println(list.size());
		System.out.println(list.get(1));

		// set(인덱스번호, 값) : 인덱스번호에 해당하는 내용을 값으로 변경
		list.set(0, "ABC");
		System.out.println(list.size());
		System.out.println(list.get(0));

		// indexOf(값) : 값이 동일한 인덱스값을 돌려줌
		// lastIndexOf(값) : 뒤에서부터 값이 동일한 인덱스값을 돌려줌
		System.out.println(list.indexOf("사아자"));
		System.out.println(list.lastIndexOf("사아자"));

		// contains(값) : 일치하는 값의 존재여부를 boolean으로 돌려줌
		System.out.println(list.contains("사아자"));

		// toArray() : Object배열로 변경
		Object[] arr = list.toArray();

		// clear() : 리스트를 비움
		list.clear();
		System.out.println(list.size());

		// isEmpty() : 리스트가 비어있는지 boolean으로 돌려줌
		System.out.println(list.isEmpty());

		List<Integer> a = new ArrayList<Integer>();

		a.add(5);
		a.add(7);
		a.add(3);
		a.add(2);
		a.add(9);

		// 오름차순 정렬

		int temp;
		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(i) > a.get(j)) {
					temp = a.get(i);
					a.set(i, a.get(j));
					a.set(j, temp);
				}
			}
		}

		for (int i : a) {
			System.out.println(i);

		}
		// 오름차순 정렬 case2

		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(i) > a.get(j)) {
					a.add(a.get(i));
					a.remove(i);
					i--;
					break;
				}
			}
		}

		for (int i : a) {
			System.out.println(i);

		}

		HashMap<String, String> map = new HashMap<String, String>();

		// put(값1, 값2) : 값1을 키로, 값2를 값으로 데이터를 추가
		map.put("a", "가나다");
		map.put("b", "라마바");
		map.put("c", "사아자");

		// get(값) : 값에 해당하는 키를 찾아 연결된 데이터 취득
		System.out.println(map.get("c"));

		// remove(값) : 값에 해당하는 키를 찾아 연결된 데이터를 삭제
		map.remove("b");
		System.out.println(map.get("b"));

		// replace(값1, 값2) : 값1에 해당하는 키를 찾아 연결된 데이터를 값2로 변경 , (잘안씀, put으로도 가능)
		// map.replace("a", "ABC");
		map.put("a", "ABC");
		System.out.println(map.get("a"));

		// containsKey(값) : 값에 해당하는 키가 존재하는지 boolean으로 제공
		System.out.println(map.containsKey("b"));

		// containsValue(값) : 값에 해당하는 값이 존재하는지 boolean으로 제공
		System.out.println(map.containsValue("사아자"));

		// size() : 데이터의 개수
		System.out.println(map.size());

		// clear() : 맵 비우기
		map.clear();

		// isEmpty() : 맵이 비어있는지 boolean으로 제공
		System.out.println(map.isEmpty());
		
		map.put("a", "가나다");
		map.put("b", "라마바");
		map.put("c", "사아자");
		
		Set<String> KeySet = map.keySet();
		
		Iterator<String> Keys = KeySet.iterator();
		
		while(Keys.hasNext()) {
			System.out.println(map.get(Keys.next()));
		}
		
		List<HashMap<String, String>> board = new ArrayList<HashMap<String, String>>();

		for (int i = 1; i < 11; i++) {
			HashMap<String, String> t = new HashMap<String, String>();

			t.put("no", Integer.toString(i));
			t.put("title", "Test" + i);
			t.put("writer", "Tester");

			board.add(t);
		}
		System.out.println("번호\t제목\t작성자");
		System.out.println("---------------------------");
		for (HashMap<String, String> t : board) {
			System.out.println(t.get("no") + "\t" + t.get("title") + "\t" + t.get("writer"));
		}

	}

}
