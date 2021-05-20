package com.test.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.spring.service.ITestService;

@Controller
public class TestController {
	// @Autowired : 다음 인터페이스에 해당하는 객체를 주입하겠다.
	@Autowired
	public ITestService iTestService;
		
	@RequestMapping(value = "/test1")
	public ModelAndView test1(ModelAndView mav) {
		mav.addObject("msg", "컨트롤러발 데이터임");
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("no", "1");
		map.put("title", "test");
		
		mav.addObject("map", map);
		
		List<String> list1 = new ArrayList<String>();
		
		list1.add("제목");
		list1.add("작성자");
		list1.add("작성일");
		
		mav.addObject("list1", list1);
		
		List<HashMap<String, String>> list2 = new ArrayList<HashMap<String, String>>();

		for(int i = 10; i > 0; i--) {
			
			HashMap<String, String> temp = new HashMap<String, String>();
			
			temp.put("no", "" + i);
			temp.put("title", "Test" + i);
			temp.put("writer", "Tester" + i);
			
			list2.add(temp);
		}
		
		mav.addObject("list2", list2);
		
		// /WEB-INF/views/ + test/test1 + .jsp
		// => /WEB-INF/views/test/test1.jsp
		mav.setViewName("test/test1");
		
		return mav;
	}
	
	@RequestMapping(value = "/test2") /*주소할당*/
	public ModelAndView test2(ModelAndView mav) { /*기본형태 */
		mav.setViewName("test/test2");
	
		return mav;
	}
	
	@RequestMapping(value = "/test3") /*주소할당*/
	public ModelAndView test3(HttpServletRequest req, 
							  //@RequestParam String msg, // 변수명이 같은것을 받아옴
							  //@RequestParam(value = "msg") String a, // value에 지정한 내용과 같은것을 받아옴
							  @RequestParam HashMap<String, String>params, // map에 키,값으로 받아옴 
			ModelAndView mav) { /*기본형태 */
		//System.out.println(req.getParameter("msg")); // request를 통해 직접 취득
		System.out.println(params.get("msg"));
		
		mav.addObject("msg2", "Hi");
		
		String log = iTestService.getLog("어찌되나 봅시다."); // F3 : 선언부로 이동, Ctrl : 임플리먼트(참조)로 이동
		
		mav.addObject("log", log);
		
		mav.setViewName("test/test3");
	
		return mav;
	}
	
	@RequestMapping(value = "/test4") /*주소할당*/
	public ModelAndView test4(ModelAndView mav) { /*기본형태 */
		mav.setViewName("test/test4");
	
		return mav;
	}
	
	@RequestMapping(value = "/test5") /*주소할당*/
	public ModelAndView test5(
			@RequestParam HashMap<String, String> Params,
			ModelAndView mav) { /*기본형태 */
		String gugu = iTestService.getGugu(Params.get("dan"));
		
		System.out.println(gugu);
		
		mav.addObject("gugu", gugu);
		
		mav.setViewName("test/test5");
	
		return mav;
	}
	
	@RequestMapping(value = "/test6")
	public ModelAndView test6(ModelAndView mav) {
		mav.setViewName("test/test6");
		
		return mav;
	}
	
	@RequestMapping(value = "/test7")
	public ModelAndView test7(
			@RequestParam HashMap<String, String> Params,
			ModelAndView mav) {
		List<Integer[]> lotto = iTestService.getLotto(Params.get("jang"));
		
		mav.addObject("lotto", lotto);
		
		mav.setViewName("test/test7");
		
		return mav;
	}
}





















