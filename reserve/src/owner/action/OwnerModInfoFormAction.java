package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import owner.svc.OwnerInfoSvc;
import vo.ActionForward;
import vo.Owner;

public class OwnerModInfoFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		
		
		String id = request.getParameter("id");
		
		OwnerInfoSvc ownerInfoSvc = new OwnerInfoSvc();
		Owner owner = ownerInfoSvc.getOwner(id);
		
		if(owner != null) {
			request.setAttribute("owner", owner);
			forward = new ActionForward();
			forward.setPath("/owner/ownerModInfoForm.jsp");
		} else {
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
