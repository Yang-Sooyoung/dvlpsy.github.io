package com.gd.test.web.blog.controller;

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
import com.gd.test.web.blog.service.IBlogService;

@Controller
public class BlogController {
	@Autowired
	public IBlogService iBlogService;
	
	@Autowired
	public IPagingService iPagingService;
	
	@RequestMapping(value = "/blogMembers")
	public ModelAndView blogMembers(@RequestParam HashMap<String, String> params, 
								 ModelAndView mav) throws Throwable {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		mav.addObject("page", page);
		
		mav.setViewName("blog/blogMembers");
		
		return mav;
		
		
	}
	
	@RequestMapping(value = "/blogMembersAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String blogMembersAjax(@RequestParam HashMap<String, String> moon)
							throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		int cnt = iBlogService.getBlogCnt(moon);
		
		PagingBean pb
		= iPagingService.getPagingBean(Integer.parseInt(moon.get("page")), cnt, 5, 3);
		
		moon.put("startCnt", Integer.toString(pb.getStartCount()));
		moon.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iBlogService.getblogMembersList(moon);
		
		modelMap.put("pb", pb);
		modelMap.put("list", list);
		modelMap.put("cnt", cnt);
		
		
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/blogMDetail")
	public ModelAndView blogMDetail(HttpSession session, @RequestParam HashMap<String, String> params, 
								 ModelAndView mav) throws Throwable {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		mav.addObject("page", page);
		
		mav.setViewName("blog/blogMDetail");
		
		return mav;
		
		
	}
	
	@RequestMapping(value = "/blogMDetailAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String blogMDetailAjax(@RequestParam HashMap<String, String> moon)
							throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		int cnt = iBlogService.getblogMDetailCnt(moon);
		
		PagingBean pb
		= iPagingService.getPagingBean(Integer.parseInt(moon.get("page")), cnt, 5, 3);
		
		moon.put("startCnt", Integer.toString(pb.getStartCount()));
		moon.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iBlogService.getblogMDetail(moon);
		
		modelMap.put("pb", pb);
		modelMap.put("list", list);
		modelMap.put("cnt", cnt);
		
		
		return mapper.writeValueAsString(modelMap);
	}
	
	
   @RequestMapping(value = "/blogMDetailConAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8" ) 
   @ResponseBody
   public String blogMDetailConAjax(@RequestParam HashMap<String, String> params)
         throws Throwable{
      ObjectMapper mapper = new ObjectMapper();
      
      Map<String, Object> modelMap = new HashMap <String, Object>();
      
      addBlogHit(params);
      
      HashMap<String, String> data = iBlogService.getBlogMDetailCon(params);
      // {mno=9, page=1}
      modelMap.put("data", data);
      
      return mapper.writeValueAsString(modelMap);
      
   }
   
   public void addBlogHit(@RequestParam HashMap<String, String> params) throws Throwable{
      
      // 선택한 글의 조회수 + 1
      
      int data = iBlogService.addBlogHit(params);
      
   }
   
   @RequestMapping(value="/blogMAdd")
   public ModelAndView aBoardAdd(ModelAndView mav) {
      mav.setViewName("blog/blogMAdd");
      return mav;
   }
   @RequestMapping(value="/blogAddAjax", 
         method=RequestMethod.POST, produces="text/json;charset=UTF-8") //method 부터 한글나오게 하는 코드
   @ResponseBody
   public String blogAddAjax(@RequestParam HashMap<String,String>params)throws Throwable{
      ObjectMapper mapper=new ObjectMapper();
      Map<String,Object>modelMap=new HashMap<String,Object>();
       
      try {
         iBlogService.blogAdd(params);
         
         modelMap.put("res","SUCCESS");
      } catch (Exception e) {
         e.printStackTrace();
         modelMap.put("res","FAILED");
      }
      
      return mapper.writeValueAsString(modelMap);
   }
   
   
	@RequestMapping(value = "/blogMUpdate")
	public ModelAndView blogMUpdate(HttpSession session, @RequestParam HashMap<String, String> params, 
								 ModelAndView mav) throws Throwable {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		HashMap<String, String> data = iBlogService.getBlogMDetailCon(params);
		
		mav.addObject("page", page);
		mav.addObject("data", data);
		
		mav.setViewName("blog/blogMUpdate");
		
		return mav;
		
	}
	
   @RequestMapping(value = "/blogMUpdateAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8" ) 
   @ResponseBody
   public String blogMUpdateAjax(@RequestParam HashMap<String, String> params) throws Throwable{
      ObjectMapper mapper = new ObjectMapper();
      
      Map<String, Object> modelMap = new HashMap <String, Object>();
      
      int resultCnt = iBlogService.blogMUpdateAjax(params);
      
      modelMap.put("resultCnt", resultCnt);
      
      return mapper.writeValueAsString(modelMap);
      
   }
   

	@RequestMapping(value = "/blogDeleteAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String blogDeleteAjax(HttpSession session, @RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();

		params.put("mno", String.valueOf(session.getAttribute("sMno")));
		
		try {
			iBlogService.blogDelete(params);

			modelMap.put("res", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("res", "FAILED");
		}

		return mapper.writeValueAsString(modelMap);
	}
	
}
