<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
		if(f.owner_pw.value.length < 5 || f.owner_pw.value.length >10){
			alert("비밀번호는 5~10자로 설정하세요");
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
</head>
<body>
<form name="ownerjoin" action="../ownerjoin.own" method="post">
	<table>
		 <tr>
		 	<td colspan="2">회원가입</td>
		 </tr>	
		 <tr>
		 	<td><label for="owner_id">아이디 :</label></td>
		 	<td><input type="text" name="owner_id" id="owner_id" /></td>
		 </tr>
		 <tr>
		 	<td><label for="owner_pw">비밀번호 :</label></td>
		 	<td><input type="password" name="owner_pw" id="owner_pw" /></td>
		 </tr>
		  <tr>
		 	<td><label for="owner_name">이름 :</label></td>
		 	<td><input type="text" name="owner_name" id="owner_name" /></td>
		 </tr>
		  <tr>
		 	<td><label for="owner_age">나이 :</label></td>
		 	<td><input type="text" name="owner_age" id="owner_age" /></td>
		 </tr>
		  <tr>
		 	<td><label for="owner_gender">성별 :</label></td>
		 	<td><input type="radio" name="owner_gender" id="owner_gender1" value="남">남자
		 		<input type="radio" name="owner_gender" id="owner_gender2" value="여">여자</td>
		 </tr>
		 <tr>
		 	<td><label for="owner_number">전화번호 :</label></td>
		 	<td><input type="text" name="owner_nember" id="owner_number" /></td>
		 </tr>
		 <tr>
		 	<td><label for="owner_email">이메일 :</label></td>
		 	<td><input type="text" name="owner_email" id="owner_email" /></td>
		 </tr>
		 <tr>
		 	<td colspan="2"><a href="javascript:formCheck(document.ownerjoin);">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:ownerjoin.reset()">다시작성</a></td>		 
		 </tr>
	</table>
</form>
</body>
</html>