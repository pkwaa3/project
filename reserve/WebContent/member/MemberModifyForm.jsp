<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberMod.mem" name="memberMod" method="post">
	<table border=1>
		<tr>
			<td>아이디 : </td>
			<td colspan="2">${member.member_id }<input type="hidden" name="member_id" id="member_id" value="${member.member_id }" /></td>
		</tr>
	<tr>
			<td>비밀번호 : </td>
			<td colspan="2"><input type="password" name="member_pw" id="member_pw" value="${member.member_pw }" ></td>
		</tr>
		<tr>
			<td>이름 :</td>
			<td colspan="2"><input type="text" name="member_name" id="member_name" value="${member.member_name }" ></td>
		</tr>
		<tr>
			<td>나이 :</td>
			<td colspan="2"><input type="text" name="member_age" id="member_age" value="${member.member_age }" ></td>
		</tr>
		<tr>
			<td>성별 :</td>
			<td colspan="2"><input type="radio" name="member_gender" value="남" ${member.member_gender eq '남' ? 'checked' : '' } id="gender1" />남자
			 <input type="radio" name="member_gender" value="여" ${member.member_gender eq '여' ? 'checked' : '' } id="gender2" />여자</td>
			 
		</tr>
		<tr>
			<td>전화번호 :</td>
			<td colspan="2"><input type="text" name="member_number" id="member_number" value="${member.member_number }" ></td>
		</tr>
		<tr>
			<td>이메일 주소 :</td>
			<td colspan="2"><input type="text" name="member_email" id="member_email" value="${member_member.email }"></td>
		</tr>
		<tr>
			<td><a href="javascript:memberMod.submit()">수정</a></td>
			<td><a href="javascrip:memberMod.reset()">초기화</a></td>
			<td><a href="history.back()">뒤로 가기</a></td>
			
		</tr>
		
	</table>
	</form>
</body>
</html>