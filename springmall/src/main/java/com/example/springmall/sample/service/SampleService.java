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
@Transactional	// 메소드 처리 도중 에러가 났을 때 자동으로 롤백
public class SampleService {
	@Autowired	// 의존관계를 자동설정할 때 사용
	private SampleMapper sampleMapper;
	
	public Sample searchSample(Sample sample, String search) {
		System.out.println("SampleService.searchSample()");
		return sampleMapper.selectSearch(sample, search);
		
	}
	
	/*
	 * 4-1 수정 화면
	 * @method	getSample
     * @why		sampleNo에 해당하는 회원정보 출력
     * @param	int sampleNo
     */
	public Sample getSample(int sampleNo) {
		System.out.println("SampleService.getSample()");
		return sampleMapper.selectOne(sampleNo);
	}

	/*
	 * 4-2 수정
	 * @method	modifySample
     * @why		sample vo를 통해  회원수정
     * @param	Sample sample
     */
	public int modifySample(Sample sample) {
		System.out.println("SampleService.modifySample()");
		return sampleMapper.updateSample(sample);
	}
	
	/*
	 * 3. 입력
	 * @method	addSample
     * @why		sample vo를 통해 회원가입
     * @param	Sample sample
     */
	public int addSample(Sample sample) {
		System.out.println("SampleService.addSample()");
		return sampleMapper.insertSample(sample);
	}
	
	/*
	 * 2. 삭제
	 * @method	removeSample
     * @why		sampleNo에 해당하는 데이터를 삭제하기 위해 
     * @param	int sampleNo 
     */
	public int removeSample(int sampleNo) {
		System.out.println("SampleService.removeSample()");
		return sampleMapper.deleteSample(sampleNo);
	}
	
	/*
	 * 1. 샘플 목록
	 * @method	getSampleAll
     * @why		currentPage와 rowPerPage를 이용해 데이터를 가져오고 페이징을 위한 처리 
     * @param	currentPage가 있는 map(currentPage를 매개변수로 보내려고 했는데 오류가 나서 일담 맵으로..) 
     * @return	샘플리스트
     */
	public List<Sample> getSampleAll(HashMap<String, Object> map) {
		System.out.println("SampleService.getSampleAll()");
		// 페이징
		int rowPerPage = 10;	// 한페이지에 행이 10개
		int startRow = ((int)map.get("currentPage")-1)*rowPerPage;	// 1페이지는 0행부터 2페이지는 10행부터...
		int totalCount = sampleMapper.selectSampleAllCount();	// 전체 행 갯수
		int lastPage = totalCount/rowPerPage;	// 마지막 페이지
		if(totalCount % rowPerPage != 0) {	// 전체행을 페이지당 행으로 나눴을 때 나머지가 0이 아니면 lastPage를 1더해준다.
			lastPage++;
		}
		int pageBlock = 5;	// 한블럭당 5페이지씩
		int startPage = (((int)map.get("currentPage")-1)/pageBlock)*pageBlock+1;	// 시작페이지
		int endPage = startPage + pageBlock-1;	// 끝페이지
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		return sampleMapper.selectSampleAll(map);
	}
}
