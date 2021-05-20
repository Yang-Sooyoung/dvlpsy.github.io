package com.example.SpringBoot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.SpringBoot.dto.MemberDTO;

@Repository("daoDB")
public interface MainMapper {
	
	public List<MemberDTO> selectMember();
	
}