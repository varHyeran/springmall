package com.example.springmall.sample.controller;

import java.util.HashMap;
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
	
	// 4-1. 수정 폼
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.GET)
	public String modifySample(Model model, @RequestParam(value="sampleNo") int sampleNo) {	
		System.out.println("SampleController.modifySample() 수정 폼");
		Sample sample = sampleService.getSample(sampleNo);
		model.addAttribute("sample", sample);
		return "/sample/modifySample";	
	}
	
	// 4-2. 수정 액션
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.POST)
	public String modifySample(Sample sample) {
		System.out.println("SampleController.modifySample() 수정 액션");
		sampleService.modifySample(sample);
		return "redirect:/sample/sampleList";
	}
	
	// 3-1. 입력 폼
	@RequestMapping(value="/sample/addSample", method=RequestMethod.GET)
	public String addSample() {
		System.out.println("SampleController.addSample() 입력 폼");
		return "/sample/addSample";
		// jquery, bootstrap, Sample command객체
	}
	
	// 3-2. 입력 액션
	@RequestMapping(value="/sample/addSample", method=RequestMethod.POST)
	public String addSample(Sample sample) {	// command 객체. vo.sample 데이터부분에 변수명과 input name이 같아야한다	// Sample의 친구들이 존재할 수 있다
		// command객체의 멤버변수 == input태그 name속성, 표준setter
		System.out.println("SampleController.addSample() 입력 액션");
		sampleService.addSample(sample);
		return "redirect:/sample/sampleList";
	}
	
	// 2. 삭제
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {	// 스프링은 매개변수 타입을 모두 자기가 바꾼다
		System.out.println("SampleController.removeSample()");
		sampleService.removeSample(sampleNo);
		return "redirect:/sample/sampleList";	// redirect라는 문자열이 있으면 view가 아니다(없으면 view의 이름이라고 생각)
	}
	
	// 1. 샘플 목록
	@RequestMapping(value="/sample/sampleList", method=RequestMethod.GET)
	public String sampleList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {	// Model model = new Model();
		System.out.println("SampleController.sampleList()");
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("currentPage", currentPage);
        List<Sample> sampleList = sampleService.getSampleAll(map);
        model.addAttribute("sampleList", sampleList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", (int)map.get("lastPage"));
		return "/sample/sampleList";
	}
}
