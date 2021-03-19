package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import owner.svc.RestaurantRegiProSvc;
import vo.ActionForward;
import vo.Restaurant;


public class OwnerRegiMarketProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		Restaurant restaurant = new Restaurant();
		
		
		
		restaurant.setName(request.getParameter("name"));
		restaurant.setKind(request.getParameter("kind"));
		restaurant.setAddress(request.getParameter("address"));
		restaurant.setLocal(request.getParameter("local"));
		restaurant.setMax_head(request.getParameter("max_head"));
		restaurant.setOpen(request.getParameter("open"));
		restaurant.setClose(request.getParameter("close"));
		
		RestaurantRegiProSvc restaurantRegiProSvc = new RestaurantRegiProSvc();
		boolean isRegiSuccess = restaurantRegiProSvc.regiRestaurant(restaurant);
		if(isRegiSuccess) {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 되었습니다.');");
			out.println("location.href='ownerMyPage.own'");
			out.println("</script>");
			
		} else {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패하였습니다.');");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		return forward;
	}

}
