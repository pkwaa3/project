package owner.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import owner.svc.MarketInfoSvc;
import vo.ActionForward;
import vo.Restaurant;

public class MarketModInfoFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		
		String owner_id = (String) session.getAttribute("owner_id");
		String restNo = request.getParameter("rest_no");
		
		
		MarketInfoSvc marketInfoSvc = new MarketInfoSvc();
		Restaurant restaurant = marketInfoSvc.getRestaurant(restNo);
		request.setAttribute("restaurant", restaurant);
		
		
			
			forward = new ActionForward();
			forward.setPath("/owner/marketModInfoForm.jsp");
		
		
		
		return forward;
	}

}
