<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="vo.Owner" %>
    <%
    	Owner owner = (Owner)request.getAttribute("owner");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><title>:::점장회원정보수정|야먹자:::</title></title>
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
  height: 800px; /* Should be removed. Only for demonstration */
}


/* 콘텐츠*/
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
  <li><a class="active" href="mainLoginOwner.com">Home</a></li>
<%
	request.setCharacterEncoding("utf-8");
	if(session.getAttribute("owner_id") == null){
%>
  <li style="float:right"><a href="login.com">로그인</a></li>
  <li style="float:right"><a href="join.com">회원가입</a></li>
</ul>
<%
	} else{
%>
		<li style="float:right"><a href="ownerMyPage.own?owner_id=<%=session.getAttribute("owner_id") %>"><%=session.getAttribute("owner_id") %>님 환영합니다.</a></li>
		<li style="float:right"><a href="ownerLogout.own">로그아웃</a></li>
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
  			<li><a href="ownerModInfoForm.own?owner_id=<%=session.getAttribute("owner_id") %>">회원 정보 수정</a></li>

  			<li><a href="ownerRegiMarketForm.own?owner_id=<%=session.getAttribute("owner_id") %>">가게 정보 등록</a></li>
  			<li><a href="boardRegInfoForm.bo?owner_id=<%=session.getAttribute("owner_id") %>">메뉴 등록</a></li>
  			<li><a href="ownerRegiMarketList.own?owner_id=<%=session.getAttribute("owner_id") %>">가게 등록 리스트</a></li>
  			<li><a href="reservationList.own?owner_id=<%=session.getAttribute("owner_id") %>">예약 내역</a></li>
  			<li><a href="ownerDeleteForm.own?owner_id=<%=session.getAttribute("owner_id") %>">회원탈퇴</a></li>
  						
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">
  	<form class="modal-content" name="ownerModInfoForm" action="ownerModInfoPro.own" method="post" >
	
	
	 <div class="container">
    <h1>회원 정보 수정</h1>
    <p>빈칸을 채워 주세요.</p>
    <hr>

    <label for="owner_id"><b>아이디</b></label>
    <input type="text" placeholder="Enter Id" name="owner_id" id="owner_id" value="<%=owner.getOwner_id() %>" readonly required >

    <label for="owner_pw"><b>비밀번호</b></label>
    <input type="password" placeholder="Enter Password" name="owner_pw" id="owner_pw" value='<%=owner.getOwner_pw()%>' required>

    <label for="owner_name"><b>이름</b></label>
    <input type="text" placeholder="Enter Name" name="owner_name" id="owner_name"  value='<%=owner.getOwner_name()%>'required>
    
    <label for="owner_age"><b>나이</b></label>
    <input type="text" placeholder="Enter Age" name="owner_age" id="owner_age" value='<%=owner.getOwner_age()%>' required>
    
    <label for="owner_gender"><b>성별</b> </label><P>
    <span  style="background-color:#f1f1f1; width: 100%; padding: 15px; margin: 5px 0 22px 0;">
    			<input type="radio" name="owner_gender" id="owner_gender1" value="남" ${member.gender eq '남' ? 'checked':''} >남자
		 		<input type="radio" name="owner_gender" id="owner_gender2" value="여" ${member.gender eq '여' ? 'checked':''} >여자<p></p></span>
    
    <label for="owner_number"><b>전화번호</b></label>
    <input type="text" placeholder="Enter Tell Number" name="owner_number" id="owner_number" value='<%=owner.getOwner_number()%>' required>
    
    <label for="owner_email"><b>이 메일</b></label>
    <input type="text" placeholder="Enter Email" name="owner_email" id="owner_email" value='<%=owner.getOwner_email()%>' required>

    <div class="clearfix">
      <button type="button" class="cancelbtn" onclick="history.back()">뒤로 가기</button>
      <button type="submit" class="signupbtn"> 수정 하기</button>
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