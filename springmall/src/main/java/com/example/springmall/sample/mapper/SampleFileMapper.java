package com.example.springmall.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.SampleFile;

@Mapper
public interface SampleFileMapper {
	int insertSampleFile(SampleFile sampleFile);
	SampleFile selectSampleFile(int sampleNo);
	int removeSampleFile(int sampleNo);
	int modifySampleFile(SampleFile sampleFile);
}
