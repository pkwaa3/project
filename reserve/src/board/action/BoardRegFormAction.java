package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.BoardRegFormService;
import vo.ActionForward;
import vo.Owner;
import vo.Restaurant;

public class BoardRegFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;
		
		String id=request.getParameter("id");
		
		BoardRegFormService boardRegFormService = new BoardRegFormService();
		Owner owner = boardRegFormService.getOwnerInfo(id);
		
		if(owner != null) {
			request.setAttribute("owner",owner);
			int owner_no = owner.getOwner_no();
			Restaurant rest = boardRegFormService.getRestInfo(owner_no);
			
			if(rest != null) {
				request.setAttribute("rest", rest);
				forward = new ActionForward();
				forward.setPath("boardRegForm.bo?owner_id="+id);
			
			}
			
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('오류');");
			out.println("<location.href=main.com>");
			out.println("<script>");
		}
		
		
		
		
		return forward;
	}

}
