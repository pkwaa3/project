<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	function formCheck(f) {
		if(f.company_id.value.trim()==""){
			alert("아이디를 입력하세요!");
			f.id.value="";
			f.id.focus();
			return false;
		}
		if(f.company_pw.value.trim()==""){
			alert("비밀번호를 입력하세요!");
			f.pass.value="";
			f.pass.focus();
			return false;
			}
		if(f.company_pw.value.length < 4 || f.company_pw.value.length >10){
			alert("비밀번호는 4~10자로 설정하세요");
			f.pass.value="";
			f.pass.focus();
			return false;
			}
		
		companyjoin.submit();
		
		
		
	}
</script>
</head>
<body>
<form name="companyjoin" action="companyJoin.com" method="post">
	<table>
		 <tr>
		 	<td colspan="2">회원가입</td>
		 </tr>	
		 <tr>
		 	<td><label for="company_id">아이디 :</label></td>
		 	<td><input type="text" name="company_id" id="company_id" /></td>
		 </tr>
		 <tr>
		 	<td><label for="company_pw">비밀번호 :</label></td>
		 	<td><input type="password" name="company_pw" id="company_pw" /></td>
		 </tr>
		  <tr>
		 	<td><label for="company_admin">사용자 직함,이름:</label></td>
		 	<td><input type="text" name="company_admin" id="company_admin" /></td>
		 </tr>
		 <tr>
		 	<td colspan="2"><a href="javascript:formCheck(document.companyjoin);">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:companyjoin.reset()">다시작성</a></td>		 
		 </tr>
	</table>
</form>
</body>
</html>