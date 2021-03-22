package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberLoginSvc;
import vo.ActionForward;
import vo.Member;


public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		ActionForward forward = null;
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberLoginSvc loginSvc = new MemberLoginSvc();
		Member member = loginSvc.getMember(id);
		
		if(member != null) {
			
			if(member.getMember_pw().equals(pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("pass", pass);
				
				
				forward = new ActionForward();
				//forward.setRedirect(true);
				forward.setPath("main.com");
			
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 실패');");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
