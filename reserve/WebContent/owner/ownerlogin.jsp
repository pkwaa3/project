<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap{
	margin-top:20%;
	margin-bottom:20%;
	margin-right:10%;
	margin-left:10%;
}
table{
	background:skyblue;
	text-align:center;
	
}
.td{
	font-size:3em;
	
}

</style>
</head>
<body align:"center">
<div id="wrap">
<form name="ownerLoginForm" action="ownerLogin.own" method="post">
<table>
	<tr>
		<td>아이디 : </td>
		<td><input type="text" id="owner_id" name="owner_id" /></td>
	</tr>
	<tr>
		<td>비밀번호 : </td>
		<td><input type="password" id="owner_pw" name="owner_pw" /></td>
	</tr>
	<tr>
		<td><a href="javascript:ownerLoginForm.submit()">로그인</a></td>
		<td><a href="ownerJoinForm.own" >회원가입</a></td>
	</tr>
</table>
</form>
</div>
</body>
</html>