package com.gd.test.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Aspect
public class CommonAOP {
	//Pointcut -> 적용범위
	//@Pointcut(범위설정)
	/*
	 * 범위
	 * execution -> include필터
	 * !execution -> exclude필터
	 * * -> 모든것
	 * *(..) -> 모든 메소드
	 * .. -> 모든 경로
	 * && -> 필터 추가, 그리고
	 * || -> 필터 추가, 또는
	 */
	@Pointcut("execution(* com.gd.test..MembersController.*(..))"
			+ "&&!execution(* com.gd.test..MembersController.*Login*(..))"
			+ "&&!execution(* com.gd.test..MembersController.loginTop(..))"
			+ "||execution(* com.gd.test..BoardController.*Add(..))"
			+ "||execution(* com.gd.test..BoardController.*Update(..))"
			+ "||execution(* com.gd.test..BoardController.*Delete(..))")
	public void testAOP() {}
	
	//ProceedingJoinPoint -> 대상 적용 이벤트 필터
	/*
	 * @Before -> 메소드 실행 전
	 * @After -> 메소드 실행 후
	 * @After-returning -> 메소드 정상실행 후
	 * @After-throwing -> 메소드 예외 발생 후
	 * @Around -> 모든 동작시점
	 */
	@Around("testAOP()")
	public ModelAndView testAOP(ProceedingJoinPoint joinPoint)
														throws Throwable {
		ModelAndView mav = new ModelAndView();
		
		//Request 객체 취득
		HttpServletRequest request
		= ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("sMno") != null) {
			mav = (ModelAndView) joinPoint.proceed(); //기존 이벤트 처리 행위를 이어서 진행
		} else {
			mav.setViewName("redirect:memberLogin");
		}
		
		System.out.println("------- testAOP 실행됨 ------");
		
		return mav;
	}
}













