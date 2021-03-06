package board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.ReservOwService;
import vo.ActionForward;
import vo.Reservation;

public class ReservInfoOwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int rest_no = Integer.parseInt(request.getParameter("rest_no"));
		System.out.println(rest_no);
		
		ReservOwService reservOwSvc= new ReservOwService();
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		list=reservOwSvc.getInfo(rest_no);
		
		if(list!=null) {
			forward = new ActionForward();
			request.setAttribute("list", list);
			
			//forward.setRedirect(true);
			forward.setPath("reservInfoOwForm.own");
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
