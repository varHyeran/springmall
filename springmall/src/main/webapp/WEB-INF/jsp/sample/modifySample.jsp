<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifySample</title>
<!-- bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jquery CDN -->
</head>
<body>
	<h1>modifySample</h1>
		<form action="/sample/modifySample" method="post">
			<table>
				<tr>
					<th>NO</th>
					<td><input type="text" name="sampleNo" class="form-control" value="${sample.sampleNo}" readonly></td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input type="text" name="sampleId" class="form-control" value="${sample.sampleId}" readonly></td>
				</tr>
				<tr>
					<th>PW</tj>
					<td><input type="password" name="samplePw" class="form-control"></td>
					<td><button type="submit" class="btn btn-primary" class="btn btn-primary">수정</button></td>
				</tr>
			</table>
		</form>
</body>
</html>