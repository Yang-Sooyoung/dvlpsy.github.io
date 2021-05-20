package com.example.SpringBoot.services.memberservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.SpringBoot.dao.MainMapper;
import com.example.SpringBoot.dto.MemberDTO;

@Service("ServiceMember")
public class MemberImpl implements ServiceMember{
	
	@Resource(name="daoDB")
	private MainMapper mm;
	
	@Override
	public int execute(Model model) {
		
		List<MemberDTO> testDto = mm.selectMember();
		System.out.println("값 확인 : "+mm.selectMember());
		model.addAttribute("test",testDto);
		
		return 0;
	}

}