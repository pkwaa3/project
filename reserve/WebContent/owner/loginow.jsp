<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="ownerLogin" action="../ownerLogin.ow" method="post">
<table border="0">
	<tr>
		<td>아아디 : </td>
		<td><input type="text" id="owner_id" name="owner_id" /></td>
	</tr>
	<tr>
		<td>비밀번호 : </td>
		<td><input type="password" id="owner_pw" name="owner_pw" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="로그인"></td>
		<td><a href="" >회원가입</a></td>
	</tr>
</table>
</form>
</body>
</html>