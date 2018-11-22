package com.example.springmall.sample.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.springmall.sample.mapper.SampleFileMapper;
import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleFile;
import com.example.springmall.sample.vo.SampleRequest;

@Service
@Transactional	// 메소드 처리 도중 에러가 났을 때 자동으로 롤백
public class SampleService {
	@Autowired	// 의존관계를 자동설정할 때 사용
	private SampleMapper sampleMapper;
	@Autowired
	private SampleFileMapper sampleFileMapper;
	
	
	
	public List<Sample> searchSample(HashMap<String, Object> searchMap) {
		System.out.println("SampleService.searchSample()");
		if(searchMap.get("category") == "") {
			System.out.println("Please set sampleNo or sampleId");
		}
		System.out.println(searchMap.get("category") + "<==== 서비스 카테고리");
		System.out.println(searchMap.get("search") + "<==== 서비스 서치");
		return sampleMapper.searchSample(searchMap);
	}
	
	/*
	 * 4-1 수정 화면
	 * @method	getSample
     * @why		sampleNo에 해당하는 회원정보 출력
     * @param	int sampleNo
     */
	public HashMap<String, Object> getSample(int sampleNo) {
		System.out.println("SampleService.getSample()");
		HashMap<String, Object> map = new HashMap<String, Object>();
		SampleFile sampleFile =sampleFileMapper.selectSampleFile(sampleNo);
		Sample sample = sampleMapper.selectOne(sampleNo);
		map.put("sampleFile", sampleFile);
		map.put("sample", sample);
		return map;
	}

	/*
	 * 4-2 수정
	 * @method	modifySample
     * @why		sample vo를 통해  회원수정
     * @param	Sample sample
     */
	public void modifySample(SampleRequest sampleRequest, String formFileName, MultipartHttpServletRequest request, HttpServletResponse response) {
		System.out.println("SampleService.modifySample()");
		// 파일 외 회원정보 수정
		Sample sample = new Sample();
		sample.setSampleNo(sampleRequest.getSampleNo());
		sample.setSamplePw(sampleRequest.getSamplePw());
		sampleMapper.updateSample(sample);
		// 파일 수정
		SampleFile sampleFile = new SampleFile();
		MultipartFile multipartFile = sampleRequest.getMultipartFile();
		// 1. SampleFileNo : AutoIncrement
		// 2. SampleNo
		sampleFile.setSampleNo(sampleRequest.getSampleNo()); // insertSample(sample) 후에 PK값이 sample 자리에 채워진다
		// 3. SampleFilePath(상대경로 지정, 디렉토리 없으면 디렉토리 추가)
		String path = request.getSession().getServletContext().getRealPath("realPath\\uploads");
		System.out.println(path + "<---- path");
		File fileSaveDir = new File(path);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
			System.out.println("디렉토리 생성 완료");
		}
		sampleFile.setSampleFilePath(path);
		// 4. 확장자
		System.out.println("multipartFile.getOriginalFilename() : " + multipartFile.getOriginalFilename());
		String originalFileName = multipartFile.getOriginalFilename();
		int find = originalFileName.lastIndexOf(".");
		String ext = originalFileName.substring(find+1);
		System.out.println(ext + "<-------------ext");
		sampleFile.setSampleFileExt(ext);
		// 5. 이름
		String filename = UUID.randomUUID().toString();
		sampleFile.setSampleFileName(filename);
		// 6. 타입
		sampleFile.setSampleFileType(multipartFile.getContentType());
		// 7. 크기
		sampleFile.setSampleFileSize(multipartFile.getSize());

			if(sampleRequest.getMultipartFile().getOriginalFilename().length() != 0) {	// 파일업로드 수정
				if(formFileName.length() != 0) {	// 기존 회원정보에서 파일이 있을 때(formFileName -> modifySample.jsp참고)
					sampleFileMapper.modifySampleFile(sampleFile);
					File beforeFile = new File(path + "\\" + formFileName);
					beforeFile.delete();
					File afterFile = new File(path + "\\" + filename + "." + ext);
						try {
							multipartFile.transferTo(afterFile);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
				} else {	// 기존 회원정보에서 파일이 없을 때
					File f = new File(path + "\\" + filename + "." + ext);
						try {
							multipartFile.transferTo(f);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					sampleFileMapper.insertSampleFile(sampleFile);
				}
			}
		// 다운로드
			
			String downloadPath = response.getContentType();
			if(formFileName != null) {
				System.out.println(downloadPath + "<-----------downloadPath");
			}
			
					//.getSession().getServletContext().getRealPath("\\downloads");
/*			File fileDownload = new File(downloadPath);
				if(!fileDownload.exists()) {
					fileDownload.mkdirs();
					System.out.println("다운로드 폴더 생성 성공");
				}*/
	}
	
	/*
	 * 3. 입력
	 * @method	addSample
     * @why		sample vo를 통해 회원가입
     * @param	Sample sample
     */
	public void addSample(SampleRequest sampleRequest, MultipartHttpServletRequest request) {
		System.out.println("SampleService.addSample()");
		// 1
		Sample sample = new Sample();
		sample.setSampleId(sampleRequest.getSampleId());
		sample.setSamplePw(sampleRequest.getSamplePw());
		sampleMapper.insertSample(sample);	// auto increment에 의해 sampleNo가 만들어짐
		// 2
		SampleFile sampleFile = new SampleFile();
		MultipartFile multipartFile = sampleRequest.getMultipartFile();
		// 1. SampleFileNo : AutoIncrement
		// 2. SampleNo
		sampleFile.setSampleNo(sample.getSampleNo()); // insertSample(sample) 후에 PK값이 sample 자리에 채워진다
		// 3. SampleFilePath(상대경로 지정, 디렉토리 없으면 디렉토리 추가)
		String path = request.getSession().getServletContext().getRealPath("realPath\\uploads");
		System.out.println(path + "<---- path");
		File fileSaveDir = new File(path);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
			System.out.println("디렉토리 생성 완료");
		}
		sampleFile.setSampleFilePath(path);
		// 4. 확장자
		System.out.println("multipartFile.getOriginalFilename() : " + multipartFile.getOriginalFilename());
		String originalFileName = multipartFile.getOriginalFilename();
		int find = originalFileName.lastIndexOf(".");
		String ext = originalFileName.substring(find+1);
		System.out.println(ext + "<-------------ext");
		sampleFile.setSampleFileExt(ext);
		// 5. 이름
		String filename = UUID.randomUUID().toString();
		sampleFile.setSampleFileName(filename);
		// 6. 타입
		sampleFile.setSampleFileType(multipartFile.getContentType());
		// 7. 크기
		sampleFile.setSampleFileSize(multipartFile.getSize());
		// 내가 원하는 이름의 빈파일을 하나 만들자
		File f = new File(path + "\\" + filename + "." + ext);
		// multipartFile 안에 있는 파일을 빈파일로 복사하자
		try {
			multipartFile.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sampleFileMapper.insertSampleFile(sampleFile);
		
		// 1+2 -> @Transactional

		/*
		 * SampleRequest --> Sample, SampleFile
		 * 1. multipartfile 파일데이터 -> 저장
		 * 2. multipartfile 정보 -> 새로운정보 추가 -> SampleFile
		 */
	}

	/*
	 * 2. 삭제
	 * @method	removeSample
     * @why		sampleNo에 해당하는 데이터를 삭제하기 위해 
     * @param	int sampleNo 
     */
	public int removeSample(int sampleNo) {
		System.out.println("SampleService.removeSample()");
		SampleFile sampleFile = sampleFileMapper.selectSampleFile(sampleNo);
		System.out.print(sampleFile + "<-------sampleFile");
		String path = sampleFile.getSampleFilePath();
		String filename = sampleFile.getSampleFileName();
		String ext = sampleFile.getSampleFileExt();
		File f = new File(path + "\\" + filename + "." + ext);
		System.out.println(f+ "<------------f");
		f.delete();
		sampleFileMapper.removeSampleFile(sampleNo);
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
