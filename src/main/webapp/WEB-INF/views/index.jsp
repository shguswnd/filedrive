<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		
	</head>
	<body>
		<ul>
		<form id="store"  action="${pageContext.request.contextPath}/drive" method="post" enctype="multipart/form-data">
			<div style="margin-top: 15px;">
			  <label for="formFileLg" class="form-label">파일업로드</label>
			  <input class="form-control form-control-lg" name="file" id="formFileLg" type="file">
			</div>
			
			<!-- 제출 버튼 -->
			<div class="d-grid" style="margin-top: 30px;">
				<button class="btn btn-primary rounded-pill btn-lg" id="submitButton" type="submit">파일전송</button>
			</div>
		</form>
		</ul>
	</body>
</html>
