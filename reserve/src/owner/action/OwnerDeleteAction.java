package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberDeleteService;
import owner.svc.OwnerDeleteService;
import vo.ActionForward;

public class OwnerDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =null;
		HttpSession session = request.getSession();
		
		String owner_id = request.getParameter("owner_id");
		String owner_pw = request.getParameter("owner_pw");
		System.out.println(owner_id);
		
		OwnerDeleteService ownerDeleteService = new OwnerDeleteService();
		boolean isDeleteSuccess = ownerDeleteService.deleteOwner(owner_id, owner_pw);
		
		if(isDeleteSuccess) {
			
			forward = new ActionForward();
			forward.setRedirect(true);
			session.invalidate();
			forward.setPath("main.com");
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
