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
import com.gd.test.web.test.service.IBookService;

@Controller
public class BookController {
	@Autowired
	public IBookService iBookService;
	
	@Autowired
	public IPagingService iPagingService;

	@RequestMapping(value = "/bookList")
	public ModelAndView bookList(@RequestParam HashMap<String, String> params, 
								 ModelAndView mav) throws Throwable {
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		int cnt = iBookService.getBookCnt(params);
		
		PagingBean pb = iPagingService.getPagingBean(page, cnt, 10, 10);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iBookService.getBookList(params);

		mav.addObject("page", page);
		mav.addObject("pb", pb);
		mav.addObject("list", list);

		mav.setViewName("test/bookList");

		return mav;
	}

	@RequestMapping(value = "/bookDetail")
	public ModelAndView bookDetail(@RequestParam HashMap<String, String> params, 
								   ModelAndView mav) throws Throwable { //조회수 넣을꺼면 여기. 보드컨트롤러 참조
		
		HashMap<String, String> data = iBookService.getBook(params);

		mav.addObject("data", data);

		mav.setViewName("test/bookDetail");

		return mav;
	}


	@RequestMapping(value = "/bookAdd")
	public ModelAndView bookAdd(ModelAndView mav) {

		mav.setViewName("test/bookAdd");

		return mav;
	}

	@RequestMapping(value = "/bookAdds")
	public ModelAndView bookAdds(@RequestParam HashMap<String, String> params, 
								 ModelAndView mav) throws Throwable {
		try {
			iBookService.addBook(params);
			// redirect:주소 ==> 주소에 해당하는 컨트롤러 매핑으로 이동한다. 단, get방식만 지원
			mav.setViewName("redirect:bookList");
		} catch (Exception e) {
			e.printStackTrace();

			mav.setViewName("test/bookAdds");
		}

		return mav;
	}

	@RequestMapping(value = "/bookUpdate")
	public ModelAndView bookUpdate(@RequestParam HashMap<String, String> params, 
								   ModelAndView mav) throws Throwable { //조회수 넣을꺼면 여기. 보드컨트롤러 참조

		HashMap<String, String> data = iBookService.getBook(params);

		mav.addObject("data", data);

		mav.setViewName("test/bookUpdate");

		return mav;
	}

	@RequestMapping(value = "/bookUpdates")
	public ModelAndView bookUpdates(@RequestParam HashMap<String, String> params, 
									ModelAndView mav) throws Throwable {
		try {
			int cnt = iBookService.updateBook(params);
			if (cnt > 0) {
				mav.addObject("res", "SUCCESS");
			} else {
				mav.addObject("res", "FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("res", "EXCEPTION");
		}
		mav.setViewName("test/bookUpdates");

		return mav;
	}

	@RequestMapping(value = "/bookDelete")
	public ModelAndView bookDelete(@RequestParam HashMap<String, String> params, 
								   ModelAndView mav) throws Throwable {
		try {
			int cnt = iBookService.deleteBook(params);

			if (cnt > 0) {
				mav.addObject("res", "SUCCESS");
			} else {
				mav.addObject("res", "FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("res", "EXCEPTION");
		}

		mav.setViewName("test/bookDelete");

		return mav;
	}
}
