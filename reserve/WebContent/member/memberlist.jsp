<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberMod.mem" name="memberModForm" method="post">
		아이디 :
		<%=request.getParameter("id") %>
		비밀번호 :<%=request.getParameter("pass") %><br> 
		<a href="memberModForm.mem?id=<%=request.getParameter("id") %>"> 회원정보수정하기 </a>

</form>
</body>
</html>