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
	<h1>sampleList</h1>
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
</body>
</html>