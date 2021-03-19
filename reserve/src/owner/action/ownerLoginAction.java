package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import owner.svc.OwnerLoginService;
import vo.ActionForward;
import vo.Owner;

public class ownerLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		ActionForward forward=null;

		String id= request.getParameter("owner_id");
		String pw= request.getParameter("owner_pw");
		
		
		
		OwnerLoginService ownerLoginService = new OwnerLoginService();
		Owner owner = ownerLoginService.getOwner(id);

		if(owner !=null) {
			if(owner.getOwner_pw().equals(pw)) {
				session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				
				session.setAttribute("owner_no", owner.getOwner_no());
				
				
				forward = new ActionForward();
				//forward.setRedirect(true);
				forward.setPath("ownerMyPage.own");
			}else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 실패1');");
				out.println("history.back()");
				out.println("</script>");
			}
		}  else {


			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패2');");
			out.println("history.back()");
			out.println("</script>");

		}
		return forward;
	}
	
}


			
