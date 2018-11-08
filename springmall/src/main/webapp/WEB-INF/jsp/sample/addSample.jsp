<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addSample</title>
<!-- bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jquery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(document).ready(()=>{
        $('#sampleId').focus();
        $('#sampleId').blur(()=>{
            if($('#sampleId').val().length < 1){
                $('#idHelper').text('아이디를 입력하세요');
                $('#sampleId').focus();
            }else{
                $('#idHelper').text('');
            }
        });
        $('#samplePw').blur(()=>{
            if($('#samplePw').val().length < 1){
                $('#pwHelper').text('비밀번호를 입력하세요');
                $('#samplePw').focus();
            }else{
                $('#pwHelper').text('');
            }
        });
        $('#submitBtn').click(()=>{
            if($('#sampleId').val().length == 0 || $('#samplePw').val().length == 0){
            	alert('모든 칸을 입력하세요');
            }else{
                $('#addSampleForm').submit();
            }
        });
    });
</script>
</head>
<body>
	<h1>addSample</h1>
	<form action="/sample/addSample" method="post" id="addSampleForm">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" id="sampleId" name="sampleId" class="form-control" placeholder="아이디"><span id="idHelper"></span></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" id="samplePw" name="samplePw" class="form-control" placeholder="패스워드"><span id="pwHelper"></span></td>
				<td><button type="submit" class="btn btn-primary" id="submitBtn">가입</button></td>
			</tr>
		</table>
	</form>
</body>
</html>