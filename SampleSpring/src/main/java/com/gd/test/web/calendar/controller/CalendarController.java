package com.gd.test.web.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {
	@RequestMapping(value = "/calendar")
	public ModelAndView calendar(ModelAndView modelAndView) {
		
		modelAndView.setViewName("calendar/calendar");
		
		return modelAndView;
	}
}
