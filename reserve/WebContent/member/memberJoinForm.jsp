<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::일반회원가입|야먹자:::</title>
<script>
	function formCheck(f) {
		if(f.id.value.trim()==""){
			alert("아이디를 입력하세요!");
			f.id.value="";
			f.id.focus();
			return false;
		}
		if(f.pass.value.trim()==""){
			alert("비밀번호를 입력하세요!");
			f.pass.value="";
			f.pass.focus();
			return false;
			}
		if(f.pass.value.length < 5 || f.pass.value.length >10){
			alert("비밀번호는 5~10자로 설정하세요");
			f.pass.value="";
			f.pass.focus();
			return false;
			}
		if(f.name.value.trim()==""){
			alert("이름을 입력하세요!");
			f.name.value="";
			f.name.focus();
			return false;
			}
		if(f.age.value.trim()==""){
			alert("나이를 입력하세요!");
			f.age.value="";
			f.age.focus();
			return false;
			}
		if(isNaN(f.age.value)){
			alert("숫자만 입력하세요!");
			f.age.value="";
			f.age.focus();
			return false;
			}
		if(f.number.value.trim()==""){
			alert("전화번호를 입력하세요!");
			f.number.value="";
			f.number.focus();
			return false;
			}
		if(f.email.value.trim()==""){
			alert("이메일을 입력하세요!");
			f.email.value="";
			f.email.focus();
			return false;
			}
		
		memberJoinForm.submit();
		
		
		
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
</style>
</head>
<body>
<form class="modal-content" name="memberJoinForm" action="memberJoinProccess.mem" method="post" >
	
	
	 <div class="container">
    <h1>회원 가입</h1>
    <p>빈칸을 채워 주세요.</p>
    <hr>

    <label for="id"><b>아이디</b></label>
    <input type="text" placeholder="Enter Id" name="id" id="id"  readonly required>
    <input type="button" name="idSearch" id="idsearch" value="검색" onclick="window.open('memberIdCheck.mem','','width=500, height=300')"/>

    <label for="pass"><b>비밀번호</b></label>
    <input type="password" placeholder="Enter Password" name="pass" id="pass" required>

    <label for="name"><b>이름</b></label>
    <input type="text" placeholder="Enter Name" name="name" id="name"required>
    
    <label for="age"><b>나이</b></label>
    <input type="text" placeholder="Enter Age" name="age" id="age"required>
    
    <label for="gender"><b>성별</b> </label><P>
    <span  style="background-color:#f1f1f1; width: 100%; padding: 15px; margin: 5px 0 22px 0;"><input type="radio" name="gender" id="gender1" value="남" checked >남자
		 		<input type="radio" name="gender" id="gender2" value="여">여자<p></p></span>
    
    <label for="number"><b>전화번호</b></label>
    <input type="text" placeholder="Enter Tell Number" name="number" id="number"required>
    
    <label for="email"><b>이 메일</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email"required>

    <div class="clearfix">
      <button type="button" class="cancelbtn" onclick="history.back()">취소</button>
      <button type="submit" class="signupbtn">회원가입</button>
    </div>
  </div>
</form>
</body>
</html>