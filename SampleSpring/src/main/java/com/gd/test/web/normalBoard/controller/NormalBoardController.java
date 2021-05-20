package com.gd.test.web.normalBoard.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.ajaxBoard.service.IAjaxBoardService;

@Controller
public class NormalBoardController {
	private static final Logger logger = LoggerFactory.getLogger(NormalBoardController.class);

	@Autowired
	public IAjaxBoardService iAjaxBoardService;

	@Autowired
	public IPagingService iPagingService;

	@RequestMapping(value = "/normalList")
	public ModelAndView ajaxBoard(@RequestParam HashMap<String, String> params, ModelAndView modelAndView) throws Throwable {
		try {
			// 페이징 정보 추가
			int page = 1;
			
			if (params.get("page") != null && params.get("page") != "") {
				page = Integer.parseInt(params.get("page"));
			}
			
			int count = iAjaxBoardService.getBoardCount(params);

			PagingBean pb = iPagingService.getPagingBean(page, count);
			params.put("startCount", Integer.toString(pb.getStartCount()));
			params.put("endCount", Integer.toString(pb.getEndCount()));

			List<HashMap<String, String>> list = iAjaxBoardService.getBoardList(params);

			modelAndView.addObject("page", page);
			modelAndView.addObject("pb", pb);
			modelAndView.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView.setViewName("normalBoard/list");

		return modelAndView;
	}
	
	@RequestMapping(value = "/normalWrite")
	public ModelAndView normalWrite(ModelAndView modelAndView) throws Throwable {
		modelAndView.setViewName("normalBoard/write");
		
		return modelAndView;
	}

	@RequestMapping(value = "/normalWriteS", method = RequestMethod.POST)
	public ModelAndView normalWriteS(@RequestParam HashMap<String, String> params, ModelAndView modelAndView)
			throws Throwable {
		try {
			iAjaxBoardService.insertBoard(params);
			modelAndView.addObject("result", 1);
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("result", 0);
		}
		
		modelAndView.setViewName("normalBoard/write_s");
		
		return modelAndView;
	}

	@RequestMapping(value = "/normalDetail", method = RequestMethod.POST)
	public ModelAndView ajaxBoardReadDetail(HttpServletRequest request, @RequestParam HashMap<String, String> params, ModelAndView modelAndView) throws Throwable {

		try {
			String boardNo = request.getParameter("boardNo");

			iAjaxBoardService.updateHitCnt(boardNo);

			HashMap<String, String> data = iAjaxBoardService.getBoardDetail(boardNo);

			modelAndView.addObject("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		modelAndView.setViewName("normalBoard/detail");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/normalUpdate", method = RequestMethod.POST)
	public ModelAndView normalUpdate(HttpServletRequest request, @RequestParam HashMap<String, String> params, ModelAndView modelAndView) throws Throwable {
		
		try {
			String boardNo = request.getParameter("boardNo");
			
			HashMap<String, String> data = iAjaxBoardService.getBoardDetail(boardNo);
			
			modelAndView.addObject("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView.setViewName("normalBoard/update");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/normalUpdateS", method = RequestMethod.POST)
	public ModelAndView normalUpdateS(@RequestParam HashMap<String, String> params, ModelAndView modelAndView) throws Throwable {
		
		try {
			String check = iAjaxBoardService.checkPass(params);
			
			modelAndView.addObject("check", check);

			if(check.equals("TRUE")) {
				iAjaxBoardService.updateBoard(params);
				modelAndView.addObject("result", 1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("result", 0);
		}
		
		modelAndView.setViewName("normalBoard/update_s");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/normalDeleteS", method = RequestMethod.POST)
	public ModelAndView normalDeleteS(@RequestParam HashMap<String, String> params, ModelAndView modelAndView) throws Throwable {
		
		try {
			String check = iAjaxBoardService.checkPass(params);
			
			modelAndView.addObject("check", check);
			
			if(check.equals("TRUE")) {
				iAjaxBoardService.deleteBoard(params);
				
				modelAndView.addObject("result", 1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("result", 0);
		}
		
		modelAndView.setViewName("normalBoard/delete_s");
		
		return modelAndView;
	}
}
