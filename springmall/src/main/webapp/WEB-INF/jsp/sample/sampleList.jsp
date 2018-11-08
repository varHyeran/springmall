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
	    <a href="/sample/addSample">
            <button type="button" class="btn btn-danger">회원가입</button>
        </a>
	<table class="table">
		<thead>
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
					<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}">DLETE</a></td>
					<td><a href="/sample/modifySample?sampleNo=${sample.sampleNo}">UPDATE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<div class="form-group text-center">
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/sample/sampleList?currentPage=${currentPage-1}" class="btn btn-info">이전</a>
			</c:if>
			<c:if test="${currentPage < lastPage}">
				<a href="${pageContext.request.contextPath}/sample/sampleList?currentPage=${currentPage+1}" class="btn btn-info" align="center">다음</a>
			</c:if>
		</div>
</body>
</html>