<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::일반회원로그인|야먹자:::</title>
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

.footer {
  background-color: #343a40 !important;
  padding: 10px;
  width:100%;
  height:30px;
  position:fixed;
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
  <form class="modal-content" name="memberLoginForm" action="memberLoginProccess.mem" method="post">
 

    <div class="container">
      <label for="id"><b>아이디</b></label>
      <input type="text" placeholder="Enter ID" name="id" id="id"required>

      <label for="pass"><b>비밀번호</b></label>
      <input type="password" placeholder="Enter Password" name="pass" id="pass" required>
        
      <button type="submit">로그인</button>
     
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="history.back()" class="cancelbtn">뒤로 가기</button>
      <span class="psw"> <a href="memberJoinForm.mem">회원가입</a></span>
    </div>
  </form>
<div class="footer">
  <p>Copyright &copy; Your Website 2020</p>
</div>
</body>
</html>