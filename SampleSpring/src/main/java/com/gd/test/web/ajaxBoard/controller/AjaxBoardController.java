package com.gd.test.web.ajaxBoard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gd.test.common.CommonProperties;
import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.ajaxBoard.service.IAjaxBoardService;

@Controller
public class AjaxBoardController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxBoardController.class);

	@Autowired
	public IAjaxBoardService iAjaxBoardService;

	@Autowired
	public IPagingService iPagingService;

	@RequestMapping(value = "/ajaxBoard")
	public ModelAndView ajaxBoard(ModelAndView modelAndView) throws Throwable {
		modelAndView.setViewName("ajaxBoard/ajaxBoard");

		return modelAndView;
	}

	@RequestMapping(value = "/ajaxBoardInsertResult", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String ajaxBoardInsertResult(@RequestParam HashMap<String, String> params, ModelAndView modelAndView)
			throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();

		try {
			iAjaxBoardService.insertBoard(params);

			modelMap.put("message", CommonProperties.RESULT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("message", CommonProperties.RESULT_ERROR);
			modelMap.put("errorMessage", e.getMessage());
		}

		return mapper.writeValueAsString(modelMap);
	}

	@RequestMapping(value = "/ajaxBoardReadList", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String ajaxBoardReadList(@RequestParam HashMap<String, String> params, ModelAndView modelAndView)
			throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();

		try {
			int count = iAjaxBoardService.getBoardCount(params);

			PagingBean pb = iPagingService.getPagingBean(Integer.parseInt(params.get("page")), count);
			params.put("startCount", Integer.toString(pb.getStartCount()));
			params.put("endCount", Integer.toString(pb.getEndCount()));

			List<HashMap<String, String>> list = iAjaxBoardService.getBoardList(params);

			modelMap.put("pb", pb);
			modelMap.put("list", list);

			modelMap.put("message", CommonProperties.RESULT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("message", CommonProperties.RESULT_ERROR);
			modelMap.put("errorMessage", e.getMessage());
		}

		return mapper.writeValueAsString(modelMap);
	}

	@RequestMapping(value = "/ajaxBoardReadDetail", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String ajaxBoardReadDetail(HttpServletRequest request, ModelAndView modelAndView) throws Throwable {

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();

		try {
			String boardNo = request.getParameter("boardNo");

			iAjaxBoardService.updateHitCnt(boardNo);

			HashMap<String, String> params = iAjaxBoardService.getBoardDetail(boardNo);

			modelMap.put("params", params);

			modelMap.put("message", CommonProperties.RESULT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("message", CommonProperties.RESULT_ERROR);
			modelMap.put("errorMessage", e.getMessage());
		}

		return mapper.writeValueAsString(modelMap);
	}

	@RequestMapping(value = "/ajaxBoardPassCheckResult", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String ajaxBoardPassCheckResult(@RequestParam HashMap<String, String> params, ModelAndView modelAndView)
			throws Throwable {

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();

		try {
			String result = iAjaxBoardService.checkPass(params);

			modelMap.put("result", result);

			modelMap.put("message", CommonProperties.RESULT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("message", CommonProperties.RESULT_ERROR);
			modelMap.put("errorMessage", e.getMessage());
		}

		return mapper.writeValueAsString(modelMap);
	}

	@RequestMapping(value = "/ajaxBoardUpdateResult", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String ajaxBoardUpdateResult(@RequestParam HashMap<String, String> params, ModelAndView modelAndView)
			throws Throwable {

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();

		try {
			iAjaxBoardService.updateBoard(params);

			modelMap.put("message", CommonProperties.RESULT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("message", CommonProperties.RESULT_ERROR);
			modelMap.put("errorMessage", e.getMessage());
		}

		return mapper.writeValueAsString(modelMap);
	}

	@RequestMapping(value = "/ajaxBoardDeleteResult", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String ajaxBoardDeleteResult(@RequestParam HashMap<String, String> params, ModelAndView modelAndView)
			throws Throwable {

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();

		try {
			iAjaxBoardService.deleteBoard(params);

			modelMap.put("message", CommonProperties.RESULT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("message", CommonProperties.RESULT_ERROR);
			modelMap.put("errorMessage", e.getMessage());
		}

		return mapper.writeValueAsString(modelMap);
	}
}
