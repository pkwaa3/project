package owner.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import owner.svc.OwnerRegiMarketListService;
import vo.ActionForward;
import vo.Restaurant;

public class ownerRegiMarketListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		int owner_no = (int) session.getAttribute("owner_no");
		
		OwnerRegiMarketListService ownerRegiMarketListService = new OwnerRegiMarketListService();
		 
		
		ArrayList<Restaurant> restList = new ArrayList<>();
		restList = ownerRegiMarketListService.getRestList(owner_no);
		
		request.setAttribute("restList", restList);
		for(int i=0; i<restList.size(); i++) {
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("ownerRegiMarketListForm.own");
		return forward;
	}

}
