package com.gd.test.web.test.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.test.service.ITestService;

@Controller /* 언옵테이션 */
public class TestController {
	@Autowired /* 객체생성 */
	public ITestService iTestService; /* ITestService에서 생성 */
	
	@Autowired
	public IPagingService iPagingService;
	
	@RequestMapping(value = "/test1") /* 주소할당 */
	public ModelAndView test1(@RequestParam HashMap<String, String> params,
							  ModelAndView mav) throws Throwable { /* 예외처리 달아주기 */
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		int cnt = iTestService.getMemCnt(params);

		PagingBean pb = iPagingService.getPagingBean(page, cnt, 5, 3);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));

		List<HashMap<String, String>> list = iTestService.getMem(params);
		
		mav.addObject("list", list);
		mav.addObject("pb", pb);
		mav.addObject("page", page);
		
		mav.setViewName("test/test1");
		/* views에 test폴더 만들기 */
		return mav;
	}
	
	@RequestMapping(value = "/test1Detail")
	public ModelAndView test1Detail(@RequestParam HashMap<String, String> params, ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iTestService.getMemDetail(params); /* 외부에서 받아들이는 임의의 값 param */
		/*한줄에 컬럼 여러개일때는 해쉬맵*/
		mav.addObject("data", data);
		
		mav.setViewName("test/test1Detail");

		return mav;
	}
	
	@RequestMapping(value = "/test1Add")
	public ModelAndView test1Add(ModelAndView mav) {
		mav.setViewName("test/test1Add");
		
		return mav;
	}
	
	@RequestMapping(value = "/test1Adds")
	public ModelAndView test1Adds(@RequestParam HashMap<String, String> params,
								  ModelAndView mav) throws Throwable {
		
		try {
			iTestService.addMem(params);
			// redirect:주소 ==> 주소에 해당하는 컨트롤러 매핑으로 이동한다. 단, get방식만 지원
			mav.setViewName("redirect:test1");
		} catch (Exception e) {
			e.printStackTrace();
			
			mav.setViewName("test/test1Adds");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/test1Update")
	public ModelAndView test1Update(@RequestParam HashMap<String, String> params, 
									ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iTestService.getMemDetail(params); /* 외부에서 받아들이는 임의의 값 param */
		/*한줄에 컬럼 여러개일때는 해쉬맵*/
		mav.addObject("data", data);
		
		mav.setViewName("test/test1Update");

		return mav;
	}
	
	@RequestMapping(value = "/test1Updates")
	public ModelAndView test1Updates(@RequestParam HashMap<String, String> params,
								  ModelAndView mav) throws Throwable {
		
		try {
			int cnt = iTestService.updateMem(params);
			
			if(cnt > 0) {
				mav.addObject("res", "success");
			} else {
				mav.addObject("res", "failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("res", "failed");
		}

		mav.setViewName("test/test1Updates");
		
		return mav;
	}
	
	@RequestMapping(value= "/test1Delete")
	public ModelAndView test1Delete(@RequestParam HashMap<String, String> params,
									ModelAndView mav) throws Throwable {
		try {
			int cnt = iTestService.deleteMem(params);
			
			if(cnt > 0) {
				mav.addObject("res", "success");
			} else {
				mav.addObject("res", "failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("res", "failed");
		}

		mav.setViewName("test/test1Delete");
		
		return mav;
	}
	
	@RequestMapping(value = "/test2")
	public ModelAndView test2(@RequestParam HashMap<String, String> params,
							  ModelAndView mav) throws Throwable {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		int cnt = iTestService.getBCnt(params);

		PagingBean pb = iPagingService.getPagingBean(page, cnt, 5, 3);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String,String>> list = iTestService.getB(params);
		
		mav.addObject("list", list);
		mav.addObject("pb", pb);
		mav.addObject("page", page);
		
		mav.setViewName("test/test2");
		
		return mav;
	}
	
	@RequestMapping(value= "/test2Detail")
	public ModelAndView test2Detail(@RequestParam HashMap<String, String> params, ModelAndView mav) throws Throwable {
	
		HashMap<String, String> data = iTestService.getBDetail(params);
		
		mav.addObject("data", data);
		
		mav.setViewName("test/test2Detail");
		
		return mav;
		
	}
	
	@RequestMapping(value= "/test2Add")
	public ModelAndView test2Add(ModelAndView mav) {
		mav.setViewName("test/test2Add");
		
		return mav;
	}
	
	@RequestMapping(value= "/test2Adds")
	public ModelAndView test2Adds(@RequestParam HashMap<String, String> params,
								  ModelAndView mav) throws Throwable {
		try {
			iTestService.addB(params);
			mav.setViewName("redirect:test2");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			mav.setViewName("test/test2Adds");
		}
		
		return mav;
	}
	
	@RequestMapping(value= "/test2Update")
	public ModelAndView test2Update(@RequestParam HashMap<String, String> params, ModelAndView mav) throws Throwable {
	
		HashMap<String, String> data = iTestService.getBDetail(params);
		
		mav.addObject("data", data);
		
		mav.setViewName("test/test2Update");
		
		return mav;
		
	}
	
	@RequestMapping(value= "/test2Updates")
	public ModelAndView test2Updates(@RequestParam HashMap<String, String> params,
								  ModelAndView mav) throws Throwable {
		try {
			int cnt = iTestService.updateB(params);
			
			if(cnt > 0) {
				mav.addObject("res", "success");
			} else {
			mav.addObject("res", "failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("res", "failed");
		}
		
		mav.setViewName("test/test2Updates");
		
		return mav;
	}
	
	@RequestMapping(value= "/test2Delete")
	public ModelAndView test2Delete(@RequestParam HashMap<String, String> params,
								  ModelAndView mav) throws Throwable {
		try {
			int cnt = iTestService.deleteB(params);
			
			if(cnt > 0) {
				mav.addObject("res", "success");
			} else {
			mav.addObject("res", "failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("res", "failed");
		}
		
		mav.setViewName("test/test2Delete");
		
		return mav;
	}
}




