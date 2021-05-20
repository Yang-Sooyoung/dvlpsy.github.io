package com.gd.test.web.aboard.controller;

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
import com.gd.test.web.aboard.service.IABoardService;


@Controller
public class ABoardController {
	@Autowired
	public IABoardService iABoardService;
	
	@Autowired
	public IPagingService iPagingService;
	
	@RequestMapping(value = "/aBoardList")
	public ModelAndView aBoardList(@RequestParam HashMap<String, String> params,
								   ModelAndView mav) {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		mav.addObject("page", page);
		
		mav.setViewName("aboard/aBoardList");
		
		return mav;
	}
	
	@RequestMapping(value = "/aBoardListAjax", 
					method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aBoardListAjax(@RequestParam HashMap<String, String> params)
																throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		int cnt = iABoardService.getABoardCnt(params);
		
		PagingBean pb 
		= iPagingService.getPagingBean(Integer.parseInt(params.get("page")), cnt, 10, 10);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iABoardService.getABoardList(params);
		
		modelMap.put("pb", pb);
		modelMap.put("list", list);
		modelMap.put("cnt", cnt);
		
		return mapper.writeValueAsString(modelMap);
	}

	@RequestMapping(value = "/aBoardDetail")
	public ModelAndView aBoardDetail(@RequestParam HashMap<String, String> params, ModelAndView mav) throws Throwable {
									 iABoardService.updateABoardHit(params);

		HashMap<String, String> board = iABoardService.getABoard(params);

		mav.addObject("board", board);

		mav.setViewName("aboard/aBoardDetail");

		return mav;
	}

	@RequestMapping(value = "/aBoardAdd")
	public ModelAndView aBoardAdd(ModelAndView mav) {
		
		mav.setViewName("aboard/aBoardAdd");
		
		return mav;
	}
	
	@RequestMapping(value = "/aBoardAddAjax", 
					method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aBoardAddAjax(@RequestParam HashMap<String, String> params) 
																throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iABoardService.ABoardAdd(params);
			
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	/* 혼자한부분 */
	@RequestMapping(value = "/aBoardUpdate")
	public ModelAndView aBoardUpdate(@RequestParam HashMap<String, String> params, ModelAndView mav) 
																	throws Throwable {
		iABoardService.updateABoardHit(params);

		HashMap<String, String> board = iABoardService.getABoard(params);
		
		mav.addObject("board", board);
		
		mav.setViewName("aboard/aBoardUpdate");
		
		return mav;
	}	
	
	@RequestMapping(value = "/aBoardUpdateAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aBoardUpdateAjax(@RequestParam HashMap<String, String> params) 
																throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iABoardService.ABoardUpdate(params);
			
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/aBoardDelete")
	public ModelAndView aBoardDelete(ModelAndView mav) {
		
		mav.setViewName("aboard/aBoardDelete");
		
		return mav;
	}	
	
	@RequestMapping(value = "/aBoardDeleteAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String aBoardDeleteAjax(@RequestParam HashMap<String, String> params) 
																 throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iABoardService.ABoardDelete(params);
			
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}
		return mapper.writeValueAsString(modelMap);
	}
}
