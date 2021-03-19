package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberModService;
import vo.ActionForward;
import vo.Member;

public class MemberModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member_id") != null) {
			Member member = new Member();
			member.setMember_id(request.getParameter("member_id"));
			member.setMember_pw(request.getParameter("member_pw"));
			member.setMember_name(request.getParameter("member_name"));
			member.setMember_age(request.getParameter("member_age"));
			member.setMember_gender(request.getParameter("member_gender"));
			member.setMember_number(request.getParameter("member_number"));
			member.setMember_email(request.getParameter("member_email"));
		
			MemberModService memberModService = new MemberModService();
			boolean isModifySuccess = memberModService.modifyMember(member);
			
			if(isModifySuccess) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("");
			}
			else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back();");
				out.println("</script>");
			}
		
		
		}
			
		
		
		return forward;
	}

}