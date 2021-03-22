<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>
    <%
	request.setCharacterEncoding("utf-8");
	String openInit="false";
	if(request.getParameter("openInit")!=null) {
		openInit="true";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	function init() {
		if(<%=openInit%>){
			document.getElementById("id").value=opener.document.getElementById("id").value;
		}
	}
	function ok(v) {
		opener.idcheck=v.trim();
		opener.document.getElementById("id").value=v;
		opener.chkId=true;
		window.close();
	}
</script>
</head>
<body onload="init()">
<form action="memberIdCheck.mem" method="post" name=f>
	<input type="text" name="id" id="id">
	<input type="submit" value="중복확인">
</form>
<%
if(request.getParameter("id")!=null && !request.getParameter("id").trim().equals("")){

String chk_id = request.getParameter("id");

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql="select * from member where member_id=?";
	
try {
	Context init = new InitialContext();
	DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MySQL");
	con = ds.getConnection();
	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,chk_id);
	rs = pstmt.executeQuery();
	if(rs.next()){
		out.println("사용 불가능한 아이디입니다.");
	}else{
		out.println("사용 가능한 아이디입니다.");
		out.print("<a href='#' onclick=\"ok('"+chk_id+"')\")>사용하기</a></h3>");
	}
} catch(Exception e) {
	e.printStackTrace();
}finally {
	if(rs != null) {
		rs.close();
	}
	if(pstmt != null) {
		pstmt.close();
	}
	if(con != null) {
		con.close();
	}

}
}
%>
</body>
</html>