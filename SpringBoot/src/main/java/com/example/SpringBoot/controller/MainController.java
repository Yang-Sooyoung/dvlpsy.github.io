package com.example.SpringBoot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringBoot.services.memberservice.MemberImpl;

@Controller
public class MainController {
	@Resource(name="ServiceMember")
	private MemberImpl aa;

	@RequestMapping(value="/")
	public String main(Model model) {
		
		aa.execute(model);
		
		return "index";
	}
}