<%@page import="java.util.ArrayList"%>
<%@page import="vo.Restaurant"%>
<%@page import="vo.Owner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Owner owner= (Owner)request.getAttribute("owner");
ArrayList<Restaurant> list = (ArrayList<Restaurant>)request.getAttribute("list");
	
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
/*컨텐트*/
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
  width: 50%; /* Could be more or less, depending on screen size */
  padding:5px;
}
</style>
<script>
	var cnt = 1;
	var oTbl;
	//row추가
	function insRow() {
		cnt++;
		oTbl = document.getElementById("addTable");
		var oRow = oTbl.insertRow();
		oRow.onmouseover = function() {
		oTbl.clickedRowIndex = this.rowIndex
		}; //클릭한 로우 위치확인

		var oCell1 = oRow.insertCell();
		var oCell2 = oRow.insertCell();
		var oCell3 = oRow.insertCell();
		//삽입될 폼 태그
		var frmTag1 = "<tr><td><label for='menu_name'> 상품명 : </label><input type='text' name='menu_name' id='menu_name' style='width:200px;height:10px;'/></td>";
		var frmTag2 = "<td><label for='menu_price'>가격 : </label><input type='text' name='menu_price' id='menu_price' style='width:200px;height:10px;' />원</td>";
		var frmTag3 = "<td>사진 등록 : <input type='file' name='menu_img'id='menu_img'> </td>";
		frmTag3 += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'> ";
		
		oCell1.innerHTML = frmTag1;
		oCell2.innerHTML = frmTag2;
		oCell3.innerHTML = frmTag3;
	}
	//row삭제
	function removeRow() {
		oTbl.deleteRow(oTbl.clickedRowIndex);
	}
	function frmCheck() {
		var frm = document.f;
		for (var i = 0; i < frm.elements.length - 1; i++) {
			if (frm.elements[i].name.indexOf("fileName") > -1) {
				if (!frm.elements[i].value) {
					alert("업로드 할 파일을 선택하세요");
					frm.elements[i].focus();
					return false;
				}

			}
		}
	}
</script>
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
  			<li><a href="boardRegForm.bo?owner_id=<%=session.getAttribute("owner_id") %>">가게 등록</a></li>
  			<li><a href="">예약 내역</a></li>
  			<li><a href="ownerDeleteForm.own?owner_id=<%=session.getAttribute("owner_id") %>">회원탈퇴</a></li>
  			
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">
  	
  	<form class="modal-content" name="boardRegForm"  action="boardMenuReg.bo" method="post" enctype="multipart/form-data" onsubmit="return frmCheck()">
	
	
	
	 <div class="container">
    <h1>가게 정보</h1>
    <p>빈칸을 채워 주세요.</p>
    <hr>
	<input type="hidden" name="owner_no" id="owner_no" value="<%=owner.getOwner_no() %>"  /><%=owner.getOwner_no() %>


	
    <label for="board_subject"><b>가게선택</b></label><br>
<%
	if(list != null){
		
		for(int i=0; i<list.size();i++){
%>
   <input type="radio" name="board_subject" id="board_subject" value="<%=list.get(i).getName() %>" /><%=list.get(i).getName() %>&nbsp;

   <input type="hidden" name="rest_no" id="rest_no" value="<%=list.get(i).getRest_no() %>" />



<%		
	}} else{
%>
	<input type="text" name="board_subject" id="board_subject" />
<%
	}

%>
	
	
	<br><br><label for="kind"><b>메뉴 종류</b> </label><P> 	
    <span  style="background-color:#f1f1f1; width: 100%; padding: 15px; margin: 5px 0 22px 0;">
    			
    			<input type="checkbox" name="kind" id="hansik" value="한식" checked >한식
		 		<input type="checkbox" name="kind" id="yangsik" value="양식">양식
		 		<input type="checkbox" name="kind" id="joongsik" value="중식">중식
		 		<input type="checkbox" name="kind" id="ilsik" value="일식">일식<p></p></span>

	<br><br><label for="board_content"><b>메뉴등록</b></label> &nbsp;&nbsp;<input name="addButton" type="button" style="cursor: pointer"
			onClick="insRow()" value="메뉴 추가">
    <table id="addTable">
    	<tr>		
    		<td><label for="menu_name">상품 명 : </label> <input type="text" name="menu_name" id="menu_name" style="width:200px;height:10px;"/></td>
    		<td><label for="menu_price">가격 : </label><input type="text" name="menu_price" id="menu_price" style="width:200px;height:10px;" />원</td>
    		<td><label for="menu_img">사진 등록 : </label><input type="file" name="menu_img" id="menu_img" /> <br> </td>
		</tr>    		
    	
    </table>
    
     <br><br>
    <label for="board_content"><b>가게 설명</b></label><br>
    <textarea rows="30" cols="100" name="board_content" id="board_content" ></textarea>
    
    
    
    <div class="clearfix">
      <button type="button" class="cancelbtn">취소</button>
      <button type="submit" class="signupbtn">등록</button>
    </div>
  </div>
</form>
  </div>
</div>

</body>
</html>