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
import restaurant.svc.RestNoService;
import vo.ActionForward;
import vo.Member;
import vo.Reservation;

public class ReservationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= new ActionForward();
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("id");
		//String board_no=(String)session.getAttribute("board_no");
		//String id=request.getParameter("id");
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String head = request.getParameter("head");
		String restName= request.getParameter("restName");
		
		System.out.println(id);
		System.out.println(board_no+"board_no");
		System.out.println(request.getParameter("board_no")+"board_no");
		System.out.println(date+"date");
		System.out.println(request.getParameter("date")+"date");
		System.out.println(time+"time");
		System.out.println(request.getParameter("time")+"time");
		System.out.println(head+"head");
		System.out.println(request.getParameter("head")+"head");
		
		
		//System.out.println(date);
	//	Date date = new Date();
		
		
		//멤버 아이디로 멤버 조회
		MemberNoService memberNoService = new MemberNoService();
		Member member= memberNoService.getMember(id);
		
		
		//보드번호로 식당번호 조회
		RestNoService restNoService= new RestNoService();
		int restNo = restNoService.getRestNo(board_no);
				
		Reservation reservation = new Reservation();
		reservation.setDate(date);
		reservation.setMember_no(member.getMember_no());
		reservation.setTime(time);
		reservation.setHead(head);
		reservation.setRest_no(restNo);
		reservation.setRestName(restName);
		reservation.setMemberName(member.getMember_name());
		reservation.setMemberNum(member.getMember_number());
		
		ReservationService reservationService = new ReservationService();
		boolean reserv = reservationService.reservation(reservation);
		
		if(reserv != false) {
//			forward= new ActionForward();
//			forward.setRedirect(true);
//			forward.setPath("boardViewMem.bo?board_no="+board_no);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('예약되었습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('예약실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
