package board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

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
		
		
		if(owner != null) {	
		ArrayList<Restaurant> list = new ArrayList<>();
		list= boardRegFormService.getRestInfo(owner.getOwner_no());
		
		request.setAttribute("list", list);
		
		if(list.size() !=0 ) {
			
			forward = new ActionForward();
			forward.setPath("boardRegForm.bo?owner_id="+id);
		}else {
			list=null;
			forward=null;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록된 가게가 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		} else {
			
			forward=null;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록된 가게가 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
			
		
		
		
		return forward;
	}

}
