package com.example.springmall.sample.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleMapper {	// 추상메서드, 추상클래스, 인터페이스		// 완전하게 순수한 추상메서드는 굳이 클래스로 만들필요가 없다. 인터페이스로 만듦
	// 1. select all, 전체행
	List<Sample> selectSampleAll(HashMap<String, Object> map);	// public, abstract
	int selectSampleAllCount();
	// 2. delete
	int deleteSample(int sampleNo);
	// 3. insert
	int insertSample(Sample sample);
	// 4. select one
	public abstract Sample selectOne(int sampleNo);
	// 5. update
	int updateSample(Sample sample);
	// 6. search
	List<Sample> searchSample(HashMap<String, Object> map);
}
