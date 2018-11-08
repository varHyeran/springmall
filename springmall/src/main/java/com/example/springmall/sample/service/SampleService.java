package com.example.springmall.sample.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	
	// 4-1 수정 전
	public Sample getSample(int sampleNo) {
		System.out.println("SampleService.getSample()");
		return sampleMapper.selectOne(sampleNo);
	}
	
	// 4-2 수정
	public int modifySample(Sample sample) {
		System.out.println("SampleService.modifySample()");
		return sampleMapper.updateSample(sample);
	}
	
	// 3. 입력
	public int addSample(Sample sample) {
		System.out.println("SampleService.addSample()");
		return sampleMapper.insertSample(sample);
	}
	
	// 2. 삭제
	public int removeSample(int sampleNo) {
		System.out.println("SampleService.removeSample()");
		return sampleMapper.deleteSample(sampleNo);

	}
	
	// 1. 샘플 목록
	public List<Sample> getSampleAll(HashMap<String, Object> map) {
		System.out.println("SampleService.getSampleAll()");
		// 페이징
		int rowPerPage = 10;
		int startRow = ((int)map.get("currentPage")-1)*rowPerPage;
		int totalCount = sampleMapper.selectSampleAllCount();
		int lastPage = totalCount/rowPerPage;
		if(totalCount % rowPerPage != 0) {
			lastPage++;
		}
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		return sampleMapper.selectSampleAll(map);
	}
}
