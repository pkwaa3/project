package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberDeleteService;
import vo.ActionForward;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =null;
		HttpSession session = request.getSession();
		
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		
		System.out.println(id);
		System.out.println(pass);
		MemberDeleteService memberDeleteService = new MemberDeleteService();
		boolean isDeleteSuccess = memberDeleteService.deleteMember(id,pass);
		
		if(isDeleteSuccess) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원탈퇴하셨습니다.');");
			out.println("location.href='main.com';");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴실패');");
			out.println("history.back();");
			out.println("</script>");
		}
	
		
		return forward;
	}

}
