package board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.ReservInfoService;
import board.svc.RestaurantFindService;
import member.svc.MemberNoService;
import vo.ActionForward;
import vo.Reservation;

public class ReservInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;
		
		String id=request.getParameter("member_id");
		
		//아이디로 번호조회
		MemberNoService memberNoService= new MemberNoService();
		int memberNo = memberNoService.getMember(id);
		
		
		ReservInfoService reservInfoSvc= new ReservInfoService();
		System.out.println(memberNo);
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		//Reservation reserv=reservInfoSvc.getInfo(memberNo);
		list=reservInfoSvc.getInfo(memberNo);
		
		
		//가게번호로 식당이름 찾기
		RestaurantFindService restFindService = new RestaurantFindService();
		String[] name= restFindService.getName(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getReserv_no());
			System.out.println(name[i]);
		}
		
		if(list!=null) {
			forward = new ActionForward();
			request.setAttribute("list", list);
			request.setAttribute("name", name);
			//forward.setRedirect(true);
			forward.setPath("reservInfoForm.mem");
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
