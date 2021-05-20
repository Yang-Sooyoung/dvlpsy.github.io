package com.gd.test.web.abook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.abook.service.IaBookService;

@Controller
public class YsyaBookController {
	@Autowired
	public IaBookService iaBookService;
	
	@Autowired
	public IPagingService iPagingService;

	@RequestMapping(value = "/aBookList")
	public ModelAndView aBookList(@RequestParam HashMap<String, String> params, 
								 ModelAndView mav) throws Throwable {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		mav.addObject("page", page);

		mav.setViewName("abook/aBookList");

		return mav;
	}

	@RequestMapping(value = "/aBookListAjax", 
					method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aBookListAjax(@RequestParam HashMap<String, String> params)
																throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		int cnt = iaBookService.getaBookCnt(params);
		
		PagingBean pb 
		= iPagingService.getPagingBean(Integer.parseInt(params.get("page")), cnt, 3, 3);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iaBookService.getaBookList(params);
		
		modelMap.put("pb", pb);
		modelMap.put("list", list);
		modelMap.put("cnt", cnt);
		
		return mapper.writeValueAsString(modelMap);
	}
	
	
	@RequestMapping(value = "/aBookDetail")
	public ModelAndView aBookDetail(@RequestParam HashMap<String, String> params, 
								   ModelAndView mav) throws Throwable { //조회수 넣을꺼면 여기. 보드컨트롤러 참조
		
		HashMap<String, String> book = iaBookService.getaBook(params);

		mav.addObject("book", book);

		mav.setViewName("abook/aBookDetail");

		return mav;
	}

	@RequestMapping(value = "/aBookAdd")
	public ModelAndView aBookAdd(ModelAndView mav) {

		mav.setViewName("abook/aBookAdd");

		return mav;
	}

	@RequestMapping(value = "/aBookAddAjax", 
					method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aBookAddAjax(@RequestParam HashMap<String, String> params) 
															throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iaBookService.aBookAdd(params);
			
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		
		return mapper.writeValueAsString(modelMap);
	}

	@RequestMapping(value = "/aBookUpdate")
	public ModelAndView aBookUpdate(@RequestParam HashMap<String, String> params, 
								   ModelAndView mav) throws Throwable {
		
		HashMap<String, String> book = iaBookService.getaBook(params);

		mav.addObject("book", book);
		mav.setViewName("abook/aBookUpdate");

		return mav;
	}

	@RequestMapping(value = "/aBookUpdateAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aBookUpdateAjax(@RequestParam HashMap<String, String> params) 
																throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iaBookService.aBookUpdate(params);
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/aBookDelete")
	public ModelAndView aBookDelete(ModelAndView mav) {
		
		mav.setViewName("abook/aBoardDelete");
		
		return mav;
	}	
	

	@RequestMapping(value = "/aBookDeleteAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aBookDeleteAjax(@RequestParam HashMap<String, String> params) 
																throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iaBookService.aBookDelete(params);
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		return mapper.writeValueAsString(modelMap);
	}
}
