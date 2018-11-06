package com.example.springmall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller	// 뷰가 없어도 사용할 수 있도록
public class HiController {
	@RequestMapping("/hi")	// hi라는 요청이 들어오면
	public String hi() {
		System.out.println("Hi Spring boot!");
		return "hi";	// forward -> WEB-INF/jsp/hi.jsp
	}
}
