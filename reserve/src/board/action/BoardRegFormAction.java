package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import board.svc.BoardRegFormService;
import vo.ActionForward;
import vo.Owner;
import vo.Restaurant;

public class BoardRegFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("owner_id");
		System.out.println(id);
		
		BoardRegFormService boardRegFormService = new BoardRegFormService();
		Owner owner = boardRegFormService.getOwnerInfo(id);
		request.setAttribute("owner",owner);
		
		
			
		Restaurant rest = boardRegFormService.getRestInfo(owner.getOwner_no());
		request.setAttribute("rest", rest);
		
	
		System.out.println("2"+owner.getOwner_no());
		System.out.println("3"+rest.getRest_no());
			
			
			
//			if(rest != null) {
//				request.setAttribute("rest", rest);
//				int rest_no = rest.getRest_no();
//				forward = new ActionForward();
//				forward.setPath("boardRegForm.bo?owner_id="+id);
//				
//				System.out.println(rest_no);
//				System.out.println(rest);
//			}
			
//		else {
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('오류');");
//			out.println("<location.href=main.com>");
//			out.println("<script>");
//		}
		
		
		
		
		return forward;
	}

}
