<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberDelete.mem" method="post">
<table border="0">
	<tr>
		<td>탈퇴하려면 비밀번호 입력</td>
		<td><input type="password" name="pass" id="pass" /></td>
		<td><input type="hidden" name="id" id="id" value="<%=request.getParameter("id") %>"/></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="탈퇴하기" /></td>
		
</table>
</form>
</body>
</html>