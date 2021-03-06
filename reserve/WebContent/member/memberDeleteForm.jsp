<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::회원탈퇴|야먹자:::</title>
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
/* 컨텐츠 */
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password]{
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  pad	;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 30%; /* Could be more or less, depending on screen size */
  padding:5px;
}
.footer {
  background-color: #343a40 !important;
  padding: 10px;
  width:100%;
  height:30px;
  
  bottom:0;
  align:center;
  padding-top:3rem;
  padding-bottom:3rem;
}
.footer p{	
	text-align:center;
	margin:0;
	color:#fff;
	align:center;
	size:1.5em;
}
</style>
</head>
<body>
<nav id="topmenu">
<ul >
  <li><a class="active" href="main.com">Home</a></li>
<%
	request.setCharacterEncoding("utf-8");
	if(session.getAttribute("id") == null){
%>
  <li style="float:right"><a href="login.com">로그인</a></li>
  <li style="float:right"><a href="join.com">회원가입</a></li>
</ul>
<%
	} else{
%>
		<li style="float:right"><a href="memberMyPage.mem"><%=session.getAttribute("id") %>님 환영합니다.</a></li>
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
			<li><a href="cartList.bo?member_id=${id }">찜 목록</a></li>
  			<li><a href="memberDeleteForm.mem?member_id=<%=session.getAttribute("id") %>">회원탈퇴</a></li>
  				
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">
  
  		<form class="modal-content" action="memberDelete.mem" method="post">
	
	
	 <div class="container">
    <h1>회원 탈퇴</h1>
    <hr>
	<input type="hidden" name="id" id="id" value="<%=session.getAttribute("id") %>" />
	
	
    <label for="pw"><b>탈퇴하려면 비밀번호를 입력하세요</b></label>
    <input type="password" name="pass" id="pass" />
	
	
    
    <div class="clearfix">
      <button type="button" class="cancelbtn" onclick="history.back()">뒤로 가기</button>
      <button type="submit" class="signupbtn">탈퇴하기</button>
    </div>
  </div>
</form>
  
  </div>
</div>
<div class="footer">

  <p>Copyright &copy; Your Website 2020</p>
</div>
</body>
</html>