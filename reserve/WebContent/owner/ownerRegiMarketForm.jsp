<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form class="modal-content" name="ownerRegiMarketForm" action="ownerRegiMarketForm.own" method="post" >
	
	
	 <div class="container">
    <h1>가게 정보</h1>
    <p>빈칸을 채워 주세요.</p>
    <hr>

    <label for="rest_name"><b>가게 이름</b></label>
    <input type="text" placeholder="Enter Market Name" name="rest_name" id="rest_name" required>
	
	<label for="rest_local"><b>지역</b></label>
    <input type="text" placeholder="Enter Address" name="rest_local" id="rest_local" required>
	
    <label for="rest_address"><b>주소</b></label>
    <input type="text" placeholder="Enter Address" name="rest_address" id="rest_address" required>

    <label for="rest_number"><b>전화번호</b></label>
    <input type="text" placeholder="Enter Tell Number" name="rest_number" id="rest_number"required>
    
    <label for="rest_kind"><b>메뉴 종류</b> </label><P> 	
    <span  style="background-color:#f1f1f1; width: 100%; padding: 15px; margin: 5px 0 22px 0;">
    			<input type="checkbox" name="rest_kind" id="hansik" value="한식" checked >한식
		 		<input type="checkbox" name="rest_kind" id="yangsik" value="양식">양식<p></p></span>
    
    

    <div class="clearfix">
      <button type="button" class="cancelbtn">취소</button>
      <button type="submit" class="signupbtn">등록</button>
    </div>
  </div>
</form>
</body>
</html>