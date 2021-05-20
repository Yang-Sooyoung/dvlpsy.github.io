package com.gd.test.web.oboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.gd.test.web.oboard.service.IOBoardService;

@Controller
public class OBoardController {
	@Autowired
	public IOBoardService iOBoardService;
	
	@Autowired
	public IPagingService iPagingService;
	
	@RequestMapping(value = "/oBoard")
	public ModelAndView oBoard(ModelAndView mav) {
		
		mav.setViewName("oboard/oBoard");
		
		return mav;
	}
	
	@RequestMapping(value = "/oBoardListAjax", 
					method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBoardListAjax(
				@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		int cnt = iOBoardService.getOBoardCnt(params);
		
		PagingBean pb = iPagingService.getPagingBean(Integer.parseInt(params.get("page")), 
					cnt, 5, 3);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iOBoardService.getOBoardList(params);
		
		modelMap.put("list", list);
		modelMap.put("pb", pb);
		modelMap.put("cnt", cnt);
		
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/oBoardAddAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBoardAddAjax(HttpSession session,
			@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		params.put("mno", String.valueOf(session.getAttribute("sMno")));
		
		try {
			iOBoardService.oBoardAdd(params);
			
			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "EXCEPTION");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/oBoardUpdateAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBoardUpdateAjax(HttpSession session,
			@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		params.put("mno", String.valueOf(session.getAttribute("sMno")));
		
		try {
			int cnt = iOBoardService.oBoardUpdate(params);
			
			if(cnt > 0) {
				modelMap.put("res", "SUCCESS");
			} else {
				modelMap.put("res", "FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "EXCEPTION");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/oBoardDeleteAjax", 
			method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBoardDeleteAjax(HttpSession session,
			@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		params.put("mno", String.valueOf(session.getAttribute("sMno")));
		
		try {
			int cnt = iOBoardService.oBoardDelete(params);
			
			if(cnt > 0) {
				modelMap.put("res", "SUCCESS");
			} else {
				modelMap.put("res", "FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "EXCEPTION");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
}