package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import owner.svc.MarketModInfoProSvc;
import owner.svc.OwnerModInfoProSvc;
import vo.ActionForward;
import vo.Restaurant;

public class marketModInfoProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String owner_id = (String) session.getAttribute("owner_id");
		
			Restaurant restaurant = new Restaurant();
			
			String restNo = request.getParameter("rest_no"); 
			restaurant.setRest_no(Integer.parseInt(request.getParameter("rest_no")));
			restaurant.setOwner_no(Integer.parseInt(request.getParameter("owner_no")));
			restaurant.setName(request.getParameter("name"));
			restaurant.setKind(request.getParameter("kind"));
			restaurant.setAddress(request.getParameter("address"));
			restaurant.setLocal(request.getParameter("local"));
			restaurant.setMax_head(request.getParameter("max_head"));
			restaurant.setOpen(request.getParameter("open"));
			restaurant.setClose(request.getParameter("close"));
			restaurant.setTell(request.getParameter("tell"));
	    
	    	MarketModInfoProSvc marketModInfoProSvc = new MarketModInfoProSvc();
	    	boolean isModifySuccess = marketModInfoProSvc.modifyRestaurantInfo(restaurant);
	    	
	    	if(isModifySuccess) {
	    		response.setContentType("text/html;charset=utf-8");
	    		PrintWriter out = response.getWriter();
	    		out.println("<script>");
	    		out.println("alert('수정되었습니다.');");
	    		out.println("</script>");
	    		
	    	
	    		forward = new ActionForward();
	    		forward.setPath("ownerRegiMarketListForm.own?owner_id=" + "owner_id");
	    		
	    		
	    	} else {
	    		response.setContentType("text/html;charset=utf-8");
	    		PrintWriter out = response.getWriter();
	    		out.println("<script>");
	    		out.println("alert('수정실패하였습니다.');");
	    		out.println("history.back();");
	    		out.println("</script>");
	    	}
		
		
		return forward;
	}

}
