<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@page import="java.util.*" %>
     <%@ page import="vo.Restaurant" %>
    <%
    	
    	Restaurant restaurant = (Restaurant)request.getAttribute("restaurant");
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
  <li style="float:right"><a href="index/login.jsp">로그인</a></li>
  <li style="float:right"><a href="index/login.jsp">회원가입</a></li>
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
  			<li><a href="">예약 내역</a></li>
  			<li><a href="ownerDeleteForm.own?owner_id=<%=session.getAttribute("owner_id") %>">회원탈퇴</a></li>
  			
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">
  
  	<form class="modal-content" name="marketModInfoForm" action="marketModInfoPro.own" method="post" >
	
	
	 <div class="container">
    <h1>가게 정보 수정</h1>
    <p>빈칸을 채워 주세요.</p>
    <hr>
	<label for="rest_no"><b>가게 번호</b></label>
    <input type="hidden"  name="rest_no" id="rest_no" value="<%=restaurant.getRest_no() %>" required>
	<label for="owner_no"><b>오너 번호</b></label>
    <input type="hidden"  name="owner_no" id="owner_no" value="<%=restaurant.getOwner_no() %>" required>
	
    <label for="name"><b>가게 이름</b></label>
    <input type="text"  name="name" id="name" value="<%=restaurant.getName() %>" required>
	
	<label for="local"><b>지역</b></label><p>
    <select name="local" id="local" value="<%=restaurant.getLocal() %>" required>
			 <option value="서울">서울</option>
			 <option value="인천">인천</option>
			 <option value="대전">대전</option>
    		<option value="대구">대구</option>
    		<option value="울산">울산</option>
    		<option value="부산">부산</option>
    		<option value="광주">광주</option>
 	</select>
	
	<p>
    <label for="address"><b>주소</b></label>
    <input type="text" placeholder="Enter Address" name="address" id="address" value="<%=restaurant.getAddress() %>" required>

    <label for="tell"><b>전화번호</b></label>
    <input type="text" placeholder="Enter Tell Number" name="tell" id="tell" value="<%=restaurant.getTell() %>" required>
    
    <label for="kind"><b>메뉴 종류</b> </label><P> 	
    <span  style="background-color:#f1f1f1; width: 100%; padding: 15px; margin: 5px 0 22px 0;">
    			
    			<input type="checkbox" name="kind" id="hansik" value="한식" checked >한식
		 		<input type="checkbox" name="kind" id="yangsik" value="양식">양식
		 		<input type="checkbox" name="kind" id="joongsik" value="중식">중식
		 		<input type="checkbox" name="kind" id="ilsik" value="일식">일식<p></p></span>
   	 
   	<label for="open"><b>오픈시간</b></label><p>
    <input type="number" name="open" id="open" value="<%=restaurant.getOpen() %>" required><p>
    
    <label for="close"><b>마감시간</b></label><p>
    <input type="number" name="close" id="close" value="<%=restaurant.getClose() %>" required><p>
 
    
    <label for="max_head"><b>최대 수용 인원</b></label>
    <input type="text" placeholder="Enter Tell Number" name="max_head" id="max_head" value="<%=restaurant.getMax_head() %>" required>

    <div class="clearfix">
      <button type="button" class="cancelbtn" onclick="history.back()">뒤로 가기</button>
      <button type="submit" class="signupbtn">수정 하기</button>
    </div>
  </div>
</form>
  </div>
</div>

</body>
</html>