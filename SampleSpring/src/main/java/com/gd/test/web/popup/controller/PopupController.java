package com.gd.test.web.popup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PopupController {
	@RequestMapping(value = "/popup")
	public ModelAndView popup(ModelAndView modelAndView) {
		
		modelAndView.setViewName("popup/popup");
		
		return modelAndView;
	}
}
