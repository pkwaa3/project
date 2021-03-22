<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.Owner" %>
    <%
    	Owner owner = (Owner)request.getAttribute("owner");
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
<jsp:include page="../head.jsp" />
<body>


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
</body>
</html>