package com.example.springmall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	// Controller인 애들을 모두 서블릿으로
public class HiController {
	@RequestMapping("/hi")	// hi라는 요청이 들어오면
	public String hi() {
		System.out.println("Hi Spring boot!");
		return "hi";	// forward -> /WEB-INF/jsp/hi.jsp
	}
}
