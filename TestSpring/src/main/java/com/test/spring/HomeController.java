package com.test.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// @RequestMapping : value에 지정된 주소가 요청되면 다음 메소드를 실행한다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		// home이라는 view를 열것이다.
		return "home";
		// InternalResourceViewResolver : View정보가 넘어올 때 경로에 머릿말과 꼬릿말을 추가
		// prefix : 머릿말
		// suffix : 꼬릿말
		// home -> /WEB-INF/views/ + home + .jsp => /WEB-INF/views/home.jsp
	}
	
}
