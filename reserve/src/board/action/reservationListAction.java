package board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import owner.svc.OwnerRegiMarketListService;
import vo.ActionForward;
import vo.Restaurant;

public class reservationListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		int owner_no = (int)session.getAttribute("owner_no");
		
		OwnerRegiMarketListService ownerRegiMarketListService = new OwnerRegiMarketListService();
		ArrayList<Restaurant> restList = new ArrayList<>();
		
		restList= ownerRegiMarketListService.getRestList(owner_no);
		
		
		if(restList != null) {
			request.setAttribute("restList", restList);
			forward= new ActionForward();
			forward.setPath("reservationInfoForm.own");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('조회실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
