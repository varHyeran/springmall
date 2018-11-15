package com.example.springmall.sample.vo;

public class Sample {
	private int sampleNo;
	private String sampleId;
	private String samplePw;
	private SampleFile sampleFile;
	
	
	public Sample() {
		super();
	}

	public Sample(int sampleNo, String sampleId, String samplePw) {
		super();
		this.sampleNo = sampleNo;
		this.sampleId = sampleId;
		this.samplePw = samplePw;
	}

	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
		this.sampleNo = sampleNo;
		System.out.println(sampleNo + "<-----Sample.setSampleNo");
	}
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
		System.out.println(sampleId + "<-----Sample.setSampleId");
	}
	public String getSamplePw() {
		return samplePw;
	}
	public void setSamplePw(String samplePw) {
		this.samplePw = samplePw;
		System.out.println(samplePw + "<-----Sample.setSamplePw");
	}
	public SampleFile getSampleFile() {
		return sampleFile;
	}
	public void setSampleFile(SampleFile sampleFile) {
		this.sampleFile = sampleFile;
		System.out.println(sampleFile + "<-----Sample.setSampleFile");
	}

	@Override
	public String toString() {
		return "Sample [sampleNo=" + sampleNo + ", sampleId=" + sampleId + ", samplePw=" + samplePw + ", sampleFile="
				+ sampleFile + "]";
	}
}
