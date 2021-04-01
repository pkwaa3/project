package board.action;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import board.svc.ReservationService;
import member.svc.MemberInfoService;
import member.svc.MemberNoService;
import vo.ActionForward;
import vo.Reservation;

public class ReservationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("member_id");
		System.out.println(request.getParameter("date"));
		System.out.println(request.getParameter("time"));
		System.out.println(request.getParameter("head"));
	//	Date date = new Date();
		
		int time = Integer.parseInt(request.getParameter("time"));
		int head = Integer.parseInt(request.getParameter("head"));
		
		//멤버 아이디로 번호 조회
		MemberNoService memberNoService = new MemberNoService();
		int memberNo= memberNoService.getMember(id);
		
		Reservation reservation = new Reservation();
		//reservation.setDate(date);
		reservation.setMember_no(memberNo);
		reservation.setTime(time);
		reservation.setHead(head);
		
		
		ReservationService reservationService = new ReservationService();
		boolean reserv = reservationService.reservation(reservation);
		
		if(reserv != false) {
			forward= new ActionForward();
			forward.setRedirect(true);
			forward.setPath("history.back();");
		} else {
			response.setContentType("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('예약실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
