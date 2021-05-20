package com.gd.test.web.board.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.board.service.IBoardService;

@Controller
public class BoardController {
	@Autowired
	public IBoardService iBoardService;
	
	@Autowired
	public IPagingService iPagingService;
	
	@RequestMapping(value = "/boardList")
	public ModelAndView boardList(@RequestParam HashMap<String, String> params,
								ModelAndView mav) throws Throwable {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		int cnt = iBoardService.getBoardCnt(params);
		
		PagingBean pb = iPagingService.getPagingBean(page, cnt, 10, 10);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iBoardService.getBoardList(params);
		
		mav.addObject("page", page);
		mav.addObject("pb", pb);
		mav.addObject("list", list);
		
		mav.setViewName("board/boardList");
		
		return mav;
	}
	
	@RequestMapping(value = "/boardAdd")
	public ModelAndView boardAdd(ModelAndView mav) {
		
		mav.setViewName("board/boardAdd");
		
		return mav;
	}
	
	@RequestMapping(value = "/boardAdds")
	public ModelAndView boardAdds(@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		try {
			iBoardService.boardAdd(params);
			
			mav.setViewName("redirect:boardList");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("board/boardAdds");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/boardDetail")
	public ModelAndView boardDetail(@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		iBoardService.updateBoardHit(params);
		
		HashMap<String, String> board = iBoardService.getBoard(params);
		
		mav.addObject("board", board);
		
		mav.setViewName("board/boardDetail");
		
		return mav;
	}
	
	@RequestMapping(value = "/boardUpdate")
	public ModelAndView boardUpdate(@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		iBoardService.updateBoardHit(params);
		
		HashMap<String, String> board = iBoardService.getBoard(params);
		
		mav.addObject("board", board);
		
		mav.setViewName("board/boardUpdate");
		
		return mav;
	}
	
	@RequestMapping(value = "/boardUpdates")
	public ModelAndView boardUpdates(@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		try {
			int cnt = iBoardService.boardUpdate(params);
			if(cnt > 0) {
				mav.addObject("res", "SUCCESS");
			} else {
				mav.addObject("res", "FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("res", "EXCEPTION");
		}
		mav.setViewName("board/boardUpdates");
		
		return mav;
	}
	
	@RequestMapping(value = "/boardDelete")
	public ModelAndView boardDelete(@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		try {
			int cnt = iBoardService.boardDelete(params);
			if(cnt > 0) {
				mav.addObject("res", "SUCCESS");
			} else {
				mav.addObject("res", "FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("res", "EXCEPTION");
		}
		mav.setViewName("board/boardDelete");
		
		return mav;
	}
}
