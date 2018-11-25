package com.example.springmall.sample.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class SampleDownloadController {
	@RequestMapping("/file/{fileName:.+}")
	public void sampleFileDownload(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileName") String fileName) throws IOException {
		System.out.println("SampleDownloadController.sampleFileDownload()");
		// 상대경로
		String path = request.getSession().getServletContext().getRealPath("/realPath/uploads");
		System.out.println(path+"<--path");
		// 파일의 File 객체 생성
		File file = new File(path+"/"+fileName);
		System.out.println(file+"<--file");
		/*파일이 존재할 때*/
		if (file.exists()) {
			System.out.println("file exist");
			//get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				System.out.println(mimeType+"<--mimeType");
				//unknown mimetype so set the mimetype to application/octet-stream
				mimeType = "application/octet-stream";
			}

			response.setContentType(mimeType);

			/**
			 * In a regular HTTP response, the Content-Disposition response header is a
			 * header indicating if the content is expected to be displayed inline in the
			 * browser, that is, as a Web page or as part of a Web page, or as an
			 * attachment, that is downloaded and saved locally.
			 * 
			 */

			/**
			 * Here we have mentioned it to show inline
			 */
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());
		/*파일이 존재하지 않을 때*/
		}else {
			System.out.println("file not exist");
		}
	}
}