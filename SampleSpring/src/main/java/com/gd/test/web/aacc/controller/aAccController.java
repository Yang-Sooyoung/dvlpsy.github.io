package com.gd.test.web.aacc.controller;

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
import com.gd.test.web.aacc.service.IaAccService;

@Controller
public class aAccController {
	@Autowired
	public IaAccService iaAccService;
	
	@Autowired
	public IPagingService iPagingService;
	
	@RequestMapping(value = "/aAccList")
	public ModelAndView aAccList(@RequestParam HashMap<String, String> params, 
								 ModelAndView mav) throws Throwable {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		mav.addObject("page", page);
		
		mav.setViewName("aacc/aAccList");
		
		return mav;
	}
	
	@RequestMapping(value = "/aAccListAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aAccListAjax(@RequestParam HashMap<String, String> params)
															throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		int cnt = iaAccService.getaAccCnt(params);
		
		PagingBean pb 
		= iPagingService.getPagingBean(Integer.parseInt(params.get("page")), cnt, 5, 3);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iaAccService.getaAccList(params);
		
		modelMap.put("pb", pb);
		modelMap.put("list", list);
		modelMap.put("cnt", cnt);
		
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/aAccDetail")
	public ModelAndView aAccDetail(@RequestParam HashMap<String, String> params, 
			ModelAndView mav) throws Throwable {
		HashMap<String, String> data = iaAccService.getaAcc(params);
		
		mav.addObject("data", data);
		
		mav.setViewName("aacc/aAccDetail");
		
		return mav;
	}
	
	@RequestMapping(value = "/aAccAdd")
	public ModelAndView aAccAdd(ModelAndView mav) {
		
		mav.setViewName("aacc/aAccAdd");
		
		return mav;
	}
	
	@RequestMapping(value = "/aAccAddAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aAccAddAjax(@RequestParam HashMap<String, String> params) 
														throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iaAccService.aAccAdd(params);
			
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/aAccUpdate")
	public ModelAndView aAccUpdate(@RequestParam HashMap<String, String> params, 
			ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iaAccService.getaAcc(params);
		
		mav.addObject("data", data);
		
		mav.setViewName("aacc/aAccUpdate");
		
		return mav;
	}
	
	@RequestMapping(value = "/aAccUpdateAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aAccUpdateAjax(@RequestParam HashMap<String, String> params) 
																throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iaAccService.aAccUpdate(params);
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/aAccDelete")
	public ModelAndView aAccDelete(ModelAndView mav) {
		
		mav.setViewName("aacc/aAccDelete");
		
		return mav;
	}	
	
	@RequestMapping(value = "/aAccDeleteAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aAccDeleteAjax(@RequestParam HashMap<String, String> params) 
																throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iaAccService.aAccDelete(params);
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		return mapper.writeValueAsString(modelMap);
	}
}
