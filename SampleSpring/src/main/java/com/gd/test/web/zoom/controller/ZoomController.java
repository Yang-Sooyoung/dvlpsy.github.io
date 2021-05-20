package com.gd.test.web.zoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ZoomController {
	@RequestMapping(value = "/zoom")
	public ModelAndView zoom(ModelAndView modelAndView) {
		
		modelAndView.setViewName("zoom/zoom");
		
		return modelAndView;
	}
}
