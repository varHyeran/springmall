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
	<h1 align="center">modifySample</h1>
		<form action="/sample/modifySample" method="post" id="modifySampleForm" enctype="multipart/form-data">
			<table class = "table" style="width:40%;height:100px;margin:auto;">
				<tr>
					<th>NO</th>
					<td><input type="text" name="sampleNo" class="form-control" value="${sample.sampleNo}" readonly></td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input type="text" name="sampleId" class="form-control" value="${sample.sampleId}" readonly></td>
				</tr>
				<tr>
					<th rowspan="2">FILE</th>
					<td><a href="#"><input type="text" style="cursor:pointer" name="formFileName" class="form-control" value="${sampleFile.sampleFileName}${dot}${sampleFile.sampleFileExt}"></a></td>
				</tr>
				<tr>
					<td><input type="file" name="multipartFile"></td>
				</tr>
				<tr>
					<th>PW</tj>
					<td><input type="password" id="samplePw" name="samplePw" class="form-control"><span id="pwHelper"></span></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit" id="submitBtn" class="btn btn-primary" align="center">수정</button>
					<a href="/sample/sampleList" class="btn btn-warning">홈으로</a></td>
				</tr>
			</table>
		</form>
</body>
</html>