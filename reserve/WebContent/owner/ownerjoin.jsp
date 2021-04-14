<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::점장회원가입|야먹자:::</title>
<script>
	function formCheck(f) {
		if(f.owner_id.value.trim()==""){
			alert("아이디를 입력하세요!");
			f.id.value="";
			f.id.focus();
			return false;
		}
		if(f.owner_pw.value.trim()==""){
			alert("비밀번호를 입력하세요!");
			f.pass.value="";
			f.pass.focus();
			return false;
			}
		if(f.owner_pw.value.length < 4 || f.owner_pw.value.length >10){
			alert("비밀번호는 4~10자로 설정하세요");
			f.pass.value="";
			f.pass.focus();
			return false;
			}
		if(f.owner_name.value.trim()==""){
			alert("이름을 입력하세요!");
			f.name.value="";
			f.name.focus();
			return false;
			}
		if(isNaN(f.owner_age.value)){
			alert("숫자만 입력하세요!");
			f.age.value="";
			f.age.focus();
			return false;
			}
		ownerjoin.submit();
		
		
		
	}
</script>
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
.footer {
  background-color: #343a40 !important;
  padding: 10px;
  width:100%;
  height:100px;
  
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
<jsp:include page="../head.jsp"></jsp:include>
<form class="modal-content" name="ownerjoin" action="ownerJoin.own" method="post" >
	
	
	 <div class="container">
    <h1>회원 가입</h1>
    <p>빈칸을 채워 주세요.</p>
    <hr>

    <label for="owner_id"><b>아이디</b></label>
    <input type="text" placeholder="Enter Id" name="owner_id" id="owner_id" readonly required>
     <input type="button" name="idSearch" id="idsearch" value="검색" onclick="window.open('ownerIdCheck.own','','width=500, height=300')"/>

    <label for="owner_pw"><b>비밀번호</b></label>
    <input type="password" placeholder="Enter Password" name="owner_pw" id="owner_pw" required>

    <label for="owner_name"><b>이름</b></label>
    <input type="text" placeholder="Enter Name" name="owner_name" id="owner_name"required>
    
    <label for="owner_age"><b>나이</b></label>
    <input type="text" placeholder="Enter Age" name="owner_age" id="owner_age"required>
    
    <label for="owner_gender"><b>성별</b> </label><P>
    <span  style="background-color:#f1f1f1; width: 100%; padding: 15px; margin: 5px 0 22px 0;"><input type="radio" name="owner_gender" id="owner_gender1" value="남" checked >남자
		 		<input type="radio" name="owner_gender" id="owner_gender2" value="여">여자<p></p></span>
    
    <label for="owner_number"><b>전화번호</b></label>
    <input type="text" placeholder="Enter Tell Number" name="owner_number" id="owner_number"required>
    
    <label for="owner_email"><b>이 메일</b></label>
    <input type="text" placeholder="Enter Email" name="owner_email" id="owner_email"required>

    <div class="clearfix">
      <button type="button" class="cancelbtn" onclick="history.back()">뒤로 가기</button>
      <button type="submit" class="signupbtn">회원가입</button>
    </div>
  </div>
</form>
<div class="footer">
  <p>Copyright &copy; Your Website 2020</p>
</div>
</body>

</html>