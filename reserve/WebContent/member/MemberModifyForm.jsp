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
<form action="memberMod.mem" name="memberModForm" method="post">
	<table border=1>
		<tr>
			<td>아이디 : </td>
			<td colspan="2"><input type="text" name="member_id" id="member_id" value="<%=member.getMember_id() %>" /></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td colspan="2"><input type="password" name="member_pw" id="member_pw" value="<%=member.getMember_pw() %>"  /></td>
		</tr>
		<tr>
			<td>이름 :</td>
			<td colspan="2"><input type="text" name="member_name" id="member_name" value="<%=member.getMember_name() %>" ></td>
		</tr>
		<tr>
			<td>나이 :</td>
			<td colspan="2"><input type="text" name="member_age" id="member_age" value="<%=member.getMember_age() %>" ></td>
		</tr>
		<tr>
			<td>성별 :</td>
			<td colspan="2"><input type="radio" name="member_gender" value="남" ${member.member_gender eq '남' ? 'checked' : '' } id="gender1" />남자
			 <input type="radio" name="member_gender" value="여" ${member.member_gender eq '여' ? 'checked' : '' } id="gender2" />여자</td>
			 
		</tr>
		<tr>
			<td>전화번호 :</td>
			<td colspan="2"><input type="text" name="member_number" id="member_number" value="<%=member.getMember_number() %>" ></td>
		</tr>
		<tr>
			<td>이메일 주소 :</td>
			<td colspan="2"><input type="text" name="member_email" id="member_email" value="<%=member.getMember_email() %>"></td>
		</tr>
		<tr>
			<td><a href="javascript:memberModForm.submit()">수정</a></td>
			<td><a href="javascrip:memberModForm.reset()">초기화</a></td>
			<td><a href="history.back()">뒤로 가기</a></td>
			
		</tr>
		
	</table>
	</form>
</body>
</html>