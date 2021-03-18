package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.svc.MemberInfoService;
import vo.ActionForward;
import vo.Member;

public class MemberModInfoFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
				
		String id= request.getParameter("id");
		
		MemberInfoService memberInfoService = new MemberInfoService();
		Member member = memberInfoService.getMember(id);
		
		if(member != null) {
			request.setAttribute("member", member);
			forward = new ActionForward();
			forward.setPath("member/MemberModifyForm.jsp");
			
			
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요');");
			out.println("<location.href=ownerLoginForm.own>");
			out.println("<script>");
		}
				
		
		return forward;
	}

}
