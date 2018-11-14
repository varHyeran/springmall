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
import com.example.springmall.sample.vo.SampleFile;
import com.example.springmall.sample.vo.SampleRequest;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/sampleList", method=RequestMethod.POST)
	public String searchSample(Model model, @RequestParam(value="category") Sample sample, @RequestParam(value="search") String search) {
		System.out.println("SampleController.searchSample()");
		HashMap<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("sampleNo", sample.getSampleNo());
        searchMap.put("search", search);
		List<Sample> returnSearchSample = sampleService.searchSample(searchMap);
		model.addAttribute("searchSample", returnSearchSample);
		model.addAttribute("no", searchMap.get("sampleNo"));
		model.addAttribute("id", searchMap.get("sampleId"));
		return "/sample/sampleList";
	}
	
	/*
	 * 4-1. 수정 폼
	 * @method	modifySample
     * @why		sampleNo에 해당하는 회원정보를 가져와 model객체에 데이터를 넘기고 view로 포워드
     * @param	Model model, int sampleNo
     */
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.GET)
	public String modifySample(Model model, @RequestParam(value="sampleNo") int sampleNo) {	
		System.out.println("SampleController.modifySample() 수정 폼");
		HashMap<String, Object> map = sampleService.getSample(sampleNo);
		model.addAttribute("sample", map.get("sample"));
		model.addAttribute("sampleFile", map.get("sampleFile"));
		return "/sample/modifySample";	
	}
	
	/*
	 * 4-2. 수정 액션
	 * @method	modifySample
     * @why		sample vo를 매개변수로 보내 수정처리 후 리다이렉트
     * @param	Sample sample
     */
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.POST)
	public String modifySample(Sample sample) {
		System.out.println("SampleController.modifySample() 수정 액션");
		
		sampleService.modifySample(sample);
		return "redirect:/sample/sampleList";
	}
	
	/*
	 * 3-1. 입력 폼
	 * @method	addSample
     * @why		회원가입 폼 보여주기
     */
	@RequestMapping(value="/sample/addSample", method=RequestMethod.GET)
	public String addSample() {
		System.out.println("SampleController.addSample() 입력 폼");
		return "/sample/addSample";
	}
	
	/*
	 * 3-2. 입력 액션
	 * @method	addSample
     * @why		sample vo를 매개변수로 보내 입력처리 후 리다이렉트
     * @param	Sample sample
     */
	@RequestMapping(value="/sample/addSample", method=RequestMethod.POST)
	public String addSample(Model model, SampleRequest sampleRequest) {	// command 객체. vo.sample 데이터부분에 변수명과 input name이 같아야한다	// Sample의 친구들이 존재할 수 있다
		// command객체의 멤버변수 == input태그 name속성, 표준setter로 존재
		System.out.println("SampleController.addSample() 입력 액션");
		System.out.println("SampleRequest.multipartFile 입력 액션: " + sampleRequest.getMultipartFile());
		sampleService.addSample(sampleRequest);
		return "redirect:/sample/sampleList";
	}
	
	/*
	 * 2. 삭제
	 * @method	removeSample
     * @why		sampleNo에 해당하는 데이터를 삭제하고 리다이렉트
     * @param	int sampleNo 
     */
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {	// 스프링은 매개변수 타입을 모두 자기가 바꾼다
		System.out.println("SampleController.removeSample()");
		sampleService.removeSample(sampleNo);
		
		return "redirect:/sample/sampleList";	// redirect라는 문자열이 있으면 view가 아니다(없으면 view의 이름이라고 생각)
	}
	
	/*
	 * 1. 샘플 목록
	 * @method	sampleList
     * @why		currentPage를 매개변수로 보내고 데이터를 매핑해와 model객체에 데이터를 넘기고 리스트를 보여주는 view로 포워드
     * @param	Model model, int currentPage
     */
	@RequestMapping(value="/sample/sampleList", method=RequestMethod.GET)
	public String sampleList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {	// Model model = new Model();
		System.out.println("SampleController.sampleList()");
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("currentPage", currentPage);
        List<Sample> sampleList = sampleService.getSampleAll(map);
        model.addAttribute("sampleList", sampleList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", (int)map.get("lastPage"));
        model.addAttribute("startPage", map.get("startPage"));
        model.addAttribute("endPage", map.get("endPage"));
		return "/sample/sampleList";
	}
}
