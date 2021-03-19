<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.Owner"%>
    <%
	Owner owner = (Owner)request.getAttribute("Owner");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
<form class="modal-content" name="ownerRegiMarketForm" action="ownerRegiMarketPro.own" method="post" >
	
	
	 <div class="container">
    <h1>가게 정보</h1>
    <p>빈칸을 채워 주세요.</p>
    <hr>
	<input type="hidden" name="owner_no" id="owner_no" value="<%=owner.getOwner_no() %>" />
	
	
    <label for="name"><b>가게 이름</b></label>
    <input type="text" placeholder="Enter Market Name" name="name" id="name" required>
	
	<label for="local"><b>지역</b></label><p>
    <select name="local" id="local" required>
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
    <input type="text" placeholder="Enter Address" name="address" id="address" required>

    <label for="tell"><b>전화번호</b></label>
    <input type="text" placeholder="Enter Tell Number" name="tell" id="tell"required>
    
    <label for="kind"><b>메뉴 종류</b> </label><P> 	
    <span  style="background-color:#f1f1f1; width: 100%; padding: 15px; margin: 5px 0 22px 0;">
    			
    			<input type="checkbox" name="kind" id="hansik" value="한식" checked >한식
		 		<input type="checkbox" name="kind" id="yangsik" value="양식">양식
		 		<input type="checkbox" name="kind" id="joongsik" value="중식">중식
		 		<input type="checkbox" name="kind" id="ilsik" value="일식">일식<p></p></span>
   	 
   	<label for="open"><b>오픈시간</b></label><p>
    <input type="number" name="open" id="open" required><p>
    
    <label for="close"><b>마감시간</b></label><p>
    <input type="number" name="close" id="close" required><p>
 
    
    <label for="max_head"><b>최대 수용 인원</b></label>
    <input type="text" placeholder="Enter Tell Number" name="max_head" id="max_head"required>

    <div class="clearfix">
      <button type="button" class="cancelbtn">취소</button>
      <button type="submit" class="signupbtn">등록</button>
    </div>
  </div>
</form>
</body>
</html>