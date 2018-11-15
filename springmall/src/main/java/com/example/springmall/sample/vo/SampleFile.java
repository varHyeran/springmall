package com.example.springmall.sample.vo;

public class SampleFile {
	// ai
	private int sampleFileNo;
	// insert sample
	private int sampleNo;
	// multipartfile
	private String sampleFilePath;
	private String sampleFileName;
	private String sampleFileExt;
	private String sampleFileType;
	private long sampleFileSize;
	private String sampleFileDate;
	
	public int getSampleFileNo() {
		return sampleFileNo;
	}
	public void setSampleFileNo(int sampleFileNo) {
		this.sampleFileNo = sampleFileNo;
		System.out.println(sampleFileNo + "<---- SampleFile.setSampleFileNo");
	}
	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
		this.sampleNo = sampleNo;
		System.out.println(sampleNo + "<---- SampleFile.setSampleNo");
	}
	public String getSampleFilePath() {
		return sampleFilePath;
	}
	public void setSampleFilePath(String sampleFilePath) {
		this.sampleFilePath = sampleFilePath;
		System.out.println(sampleFilePath + "<---- SampleFile.setSampleFilePath");
	}
	public String getSampleFileName() {
		return sampleFileName;
	}
	public void setSampleFileName(String sampleFileName) {
		this.sampleFileName = sampleFileName;
		System.out.println(sampleFileName + "<---- SampleFile.setSampleFileName");
	}
	public String getSampleFileExt() {
		return sampleFileExt;
	}
	public void setSampleFileExt(String sampleFileExt) {
		this.sampleFileExt = sampleFileExt;
		System.out.println(sampleFileExt + "<---- SampleFile.setSampleFileExt");
	}
	public String getSampleFileType() {
		return sampleFileType;
	}
	public void setSampleFileType(String sampleFileType) {
		this.sampleFileType = sampleFileType;
		System.out.println(sampleFileType + "<---- SampleFile.setSampleFileType");
	}
	public long getSampleFileSize() {
		return sampleFileSize;
	}
	public void setSampleFileSize(long sampleFileSize) {
		this.sampleFileSize = sampleFileSize;
		System.out.println(sampleFileSize + "<---- SampleFile.setSampleFileSize");
	}
	public String getSampleFileDate() {
		return sampleFileDate;
	}
	public void setSampleFileDate(String sampleFileDate) {
		this.sampleFileDate = sampleFileDate;
		System.out.println(sampleFileDate + "<---- SampleFile.setSampleFileDate");
	}
	@Override
	public String toString() {
		return "SampleFile [sampleFileNo=" + sampleFileNo + ", sampleNo=" + sampleNo + ", sampleFilePath="
				+ sampleFilePath + ", sampleFileName=" + sampleFileName + ", sampleFileExt=" + sampleFileExt
				+ ", sampleFileType=" + sampleFileType + ", sampleFileSize=" + sampleFileSize + ", sampleFileDate="
				+ sampleFileDate + "]";
	}
}
