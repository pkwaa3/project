package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.svc.MemberJoinProSvc;
import vo.ActionForward;
import vo.Member;

public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		Member member = new Member();
		
		member.setMember_id(request.getParameter("id"));
		member.setMember_pw(request.getParameter("pass"));
		member.setMember_name(request.getParameter("name"));
		member.setMember_age(request.getParameter("age"));
		member.setMember_gender(request.getParameter("gender"));
		member.setMember_number(request.getParameter("number"));
		member.setMember_email(request.getParameter("email"));
		
		
		MemberJoinProSvc joinProSvc = new MemberJoinProSvc();
		boolean isJoinSuccess = joinProSvc.joinMember(member);
		
		
		if(isJoinSuccess) {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입하였습니다.');");
			out.println("location.href='memberLoginForm.mem'");
			out.println("</script>");
			
		} else {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원등록 실패하였습니다.');");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		return forward;
	}

}
