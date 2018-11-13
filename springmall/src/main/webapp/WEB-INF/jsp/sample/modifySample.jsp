<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifySample</title>
<!-- bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jquery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(document).ready(()=>{
        $('#samplePw').focus();
        $('#samplePw').blur(()=>{
            if($('#samplePw').val().length < 1){
                $('#pwHelper').text('비밀번호를 입력하세요');
                $('#samplePw').focus();
            }else{
                $('#pwHelper').text('');
            }
        });
        $('#submitBtn').click(()=>{
            if($('#samplePw').val().length == 0){
            	alert('비밀번호를 입력하세요');
            }else{
                $('#modifySampleForm').submit();
            }
        });
    });
</script>
</head>
<body>
	<h1>modifySample</h1>
		<form action="/sample/modifySample" method="post" id="modifySampleForm">
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
					<th>FILE</th>
					<td><input type="text" name="sampleFild" value="${fileName}"></td>
				</tr>
				<tr>
					<th>PW</tj>
					<td><input type="password" id="samplePw" name="samplePw" class="form-control"><span id="pwHelper"></span></td>
					<td><button type="submit" id="submitBtn" class="btn btn-primary" class="btn btn-primary">수정</button></td>
				</tr>
			</table>
		</form>
</body>
sssssssss->>>>>>${filename}
</html>