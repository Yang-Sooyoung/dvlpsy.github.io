package com.gd.test.web.fancybox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FancyboxController {
	@RequestMapping(value = "/fancybox")
	public ModelAndView calendar(ModelAndView modelAndView) {
		
		modelAndView.setViewName("fancybox/fancybox");
		
		return modelAndView;
	}
}
