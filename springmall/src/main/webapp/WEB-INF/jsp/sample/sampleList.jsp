<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sampleList</title>
<!-- bootstrap CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- jquery CDN -->
</head>
<body>
	<h1 align="center">sampleList</h1>
	<table class="table" style="width:60%;height:100px;margin:auto;text-align:center;">	<!-- 샘플리스트 -->
		<thead>
			<tr>
				<td></td><td></td><td></td><td></td>
				<td>
					<a href="/sample/addSample">
	            		<button type="button" class="btn btn-danger">회원가입</button>
	        		</a>
	       		</td>
	        </tr>
			<tr>
				<td>SAMPLE NO</td>
				<td>SAMPLE ID</td>
				<td>SAMPLE PW</td>
				<td>DLETE</td>
				<td>UPDATE</td>
			</tr>
		</thead>
		<tbody>
		<!-- model안의 sampleList 가져와서 사용 -->
			<c:forEach var="sample" items="${sampleList}">
				<tr>
					<td>${sample.sampleNo}</td>
					<td>${sample.sampleId}</td>
					<td>${sample.samplePw}</td>
					<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}">DELETE</a></td>
					<td><a href="/sample/modifySample?sampleNo=${sample.sampleNo}">UPDATE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<!-- 페이징 -->
		<div class="form-group text-center">
			<c:if test="${currentPage > 1}">	<!-- 현재페이지가 1보다 크다면 이전버튼 생성 -->
			<a href="/sample/sampleList?currentPage=1" class="btn btn-link"><<</a>
				<a href="/sample/sampleList?currentPage=${currentPage-1}" class="btn btn-info">이전</a>
			</c:if>
	        
	        <c:forEach var = "click" begin="${startPage}" end="${endPage}" step="1">
	            <c:if test = "${click!=currentPage}">
	                <a href="/sample/sampleList?currentPage=${click}">${click}</a>
	            </c:if>
	            <c:if test = "${click == currentPage}">
	                ${click}
	            </c:if>
	        </c:forEach>

			<c:if test="${currentPage < lastPage}">		<!-- 현재페이지가 마지막페이지보다 작다면 다음버튼 생성 -->
				<a href="/sample/sampleList?currentPage=${currentPage+1}" class="btn btn-info">다음</a>
				<a href="/sample/sampleList?currentPage=${lastPage}" class="btn btn-link">>></a>
			</c:if>
		</div>
		<!-- 검색 -->
		<form action="/sample/sampleList" method="post">
			<table style="margin:auto;text-align:center;">
				<tr>
					<td>
						<select name="category" class="form-control">
							<option value="no">NO</option>
							<option value="id">ID</option>
						</select>
					</td>
					<td>
						<input type = "text" name="search" class="form-control form-control">
					</td>
					<td>
						<button type="submit" class="btn">검색</button>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>