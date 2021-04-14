<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::점장로그인|야먹자:::</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
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
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}


.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}



/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 30%; /* Could be more or less, depending on screen size */
}



</style>
</head>
<body>

<form class="modal-content" name="ownerLoginForm" action="ownerLogin.own" method="post">
 

    <div class="container">
      <label for="id"><b>아이디</b></label>
      <input type="text" placeholder="Enter ID" name="owner_id" id="owner_id"  required>

      <label for="owner_pw"><b>비밀번호</b></label>
      <input type="password" placeholder="Enter Password" name="owner_pw" id="owner_pw" required>
        
      <button type="submit">로그인</button>
     
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="history.back()" class="cancelbtn">뒤로 가기</button>
      <span class="psw"> <a href="ownerJoinForm.own">회원가입</a></span>
    </div>
  </form>

</body>
</html>