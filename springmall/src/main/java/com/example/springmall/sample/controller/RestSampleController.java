package com.example.springmall.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmall.sample.vo.Sample;

@RestController // 리퀘스트 매핑 매서드들은 뷰를 리턴하는 게 아니고 객체를 리턴함
public class RestSampleController {	// REST API 내가 가지고있는 DB의 결과를 오픈시켜주겠다. xml이나 json결과물을 리턴
	@RequestMapping(value="/sample/getRestSample")
	public Sample getRestSample() {
		return new Sample(1, "guest", "1234");	// {"sampleNo":1)
	}
}
