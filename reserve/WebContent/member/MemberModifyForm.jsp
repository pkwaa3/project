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
<style>
/*탑 목록*/
#topmenu {

}
#topmenu ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

#topmenu li {
  float: left;
  border-right:1px solid #bbb;
}

#topmenu li:last-child {
  border-right: none;
}

#topmenu li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

#topmenu li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}

/*콘텐트 목록*/
#contentList {

}
#contentList ul {
	background-color: #333;
	margin: 0;
 	 padding: 0;
  	overflow: hidden;
  	
}
#contentList ul li {

}
#contentList li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
#contentList li a:hover:not(.active) {
  background-color: #111;
}

/*헤더*/
.header {
  background-color: #f1f1f1;
  padding: 30px;
  text-align: center;
  font-size: 35px;
}
/*본문 목록*/
.row:after {
  content: "";
  display: table;
  clear: both;
}
.column {
  float: left;
  width: 20%;
  padding: 10px;
  height: 500px; /* Should be removed. Only for demonstration */
}
</style>
</head>
<body>

<nav id="topmenu">
<ul >
  <li><a class="active" href="main.com?id=${id }">Home</a></li>
<%
	request.setCharacterEncoding("utf-8");
	if(session.getAttribute("id") == null){
%>
  <li style="float:right"><a href="index/login.jsp">로그인</a></li>
  <li style="float:right"><a href="index/login.jsp">회원가입</a></li>
</ul>
<%
	} else{
%>
		<li style="float:right"><a href="memberMyPage.mem?id=<%=session.getAttribute("id") %>"><%=session.getAttribute("id") %>님 환영합니다.</a></li>
		<li style="float:right"><a href="memberLogout.mem">로그아웃</a></li>
		</ul>
<%
	}
%>
</nav>

<div class="header">
	<h2>마이 페이지</h2><p>
</div>
<div class="row">
  <div class="column" style="background-color:#aaa;">
  	<nav id="contentList">
  		<ul>
  			<li><a href="memberModInfoForm.mem?id=<%=session.getAttribute("id") %>">회원 정보 수정</a></li>
			<li><a href="reservInfo.mem?member_id=${id }">예약 내역</a></li>
  			<li><a href="memberDeleteForm.mem?member_id=<%=session.getAttribute("id") %>">회원탈퇴</a></li>
  			<li><a href="cartList.bo?member_id=${id }">찜 목록</a></li>	
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">
  	
  </div>
</div>

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