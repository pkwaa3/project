<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
		if(isNaN(f.age.value)){
			alert("숫자만 입력하세요!");
			f.age.value="";
			f.age.focus();
			return false;
			}
		joinform.submit();
		
		
		
	}
</script>
</head>
<body>
<form name="memberJoinForm" action="../memberJoinProccess.mem" method="post">
	<table>
		 <tr>
		 	<td colspan="2">회원가입</td>
		 </tr>	
		 <tr>
		 	<td><label for="id">아이디 :</label></td>
		 	<td><input type="text" name="id" id="id" /></td>
		 </tr>
		 <tr>
		 	<td><label for="pass">비밀번호 :</label></td>
		 	<td><input type="password" name="pass" id="pass" /></td>
		 </tr>
		  <tr>
		 	<td><label for="name">이름 :</label></td>
		 	<td><input type="text" name="name" id="name" /></td>
		 </tr>
		  <tr>
		 	<td><label for="age">나이 :</label></td>
		 	<td><input type="text" name="age" id="age" /></td>
		 </tr>
		  <tr>
		 	<td><label for="gender">성별 :</label></td>
		 	<td><input type="radio" name="gender" id="gender1" value="남">남자
		 		<input type="radio" name="gender" id="gender2" value="여">여자</td>
		 </tr>
		 <tr>
		 	<td><label for="number">전화번호 :</label></td>
		 	<td><input type="text" name="nember" id="number" /></td>
		 </tr>
		 <tr>
		 	<td><label for="email">이메일 :</label></td>
		 	<td><input type="text" name="email" id="email" /></td>
		 </tr>
		 <tr>
		 	<td colspan="2"><a href="javascript:formCheck(document.memberJoinForm);">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:memberJoinForm.reset()">다시작성</a></td>		 
		 </tr>
	</table>
</form>
</body>
</html>