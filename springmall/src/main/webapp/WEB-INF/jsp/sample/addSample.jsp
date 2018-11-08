<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addSample</title>
<!-- bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jquery CDN -->
</head>
<body>
	<h1>addSample</h1>
	<form action="/sample/addSample" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" id="id" name="sampleId" class="form-control" placeholder="아이디"><span id="pwHelper"></span></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" id="pw" name="samplePw" class="form-control" placeholder="패스워드"><span id="pwHelper"></span></td>
				<td><button type="submit" class="btn btn-primary" id="submit">가입</button></td>
			</tr>
		</table>
	</form>
</body>
</html>