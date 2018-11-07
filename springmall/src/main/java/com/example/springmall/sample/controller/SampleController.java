package com.example.springmall.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;
	
	// 1. 샘플 목록
	@RequestMapping(value="/sample/sampleList", method=RequestMethod.GET)
	public String sampleList(Model model) {	// Model model = new Model();
		List<Sample> sampleList = sampleService.getSampleAll();
		model.addAttribute("sampleList", sampleList);
		return "/sample/sampleList";
		/*
		 *  옛날방식
		 *  ModelAndView mav = new ModelAndView();
		 *  mav.setModel();
		 *  mav.setViewName();
		 *  return mav;
		 */
	}
	
	// 2. 삭제
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {	// 스프링은 매개변수 타입을 모두 자기가 바꾼다
		if(sampleService.removeSample(sampleNo)==1) {
			System.out.println(sampleNo + "번 데이터 삭제 성공");
		}
		return "redirect:/sample/sampleList";	// redirect라는 문자열이 있으면 view가 아니다(없으면 view의 이름이라고 생각)
	}
}
