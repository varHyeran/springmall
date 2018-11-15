package com.example.springmall.sample.vo;

import org.springframework.web.multipart.MultipartFile;

public class SampleRequest {
	private int sampleNo;
	private String sampleId;
	private String samplePw;
	private MultipartFile multipartFile;
	
	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
		this.sampleNo = sampleNo;
		System.out.println(sampleNo + "<-----SampleRequest.setSampleNo");
	}
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
		System.out.println(sampleId + "<-----SampleRequest.setSampleId");
	}
	public String getSamplePw() {
		return samplePw;
	}
	public void setSamplePw(String samplePw) {
		this.samplePw = samplePw;
		System.out.println(samplePw + "<-----SampleRequest.setSamplePw");
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
		System.out.println(multipartFile + "<-----SampleRequest.setMultipartFile");
	}
	@Override
	public String toString() {
		return "SampleRequest [sampleNo=" + sampleNo + ", sampleId=" + sampleId + ", samplePw=" + samplePw
				+ ", multipartFile=" + multipartFile + "]";
	}
}
