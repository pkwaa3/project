package board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import board.svc.CartAddService;
import board.svc.CartOverlapSvc;
import board.svc.MemberNoService1;
import member.svc.MemberNoService;
import restaurant.svc.RestNoService;
import vo.ActionForward;
import vo.Cart;

public class CartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println(id);

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String restName = request.getParameter("restName");
		String img = request.getParameter("img");

		// 멤버 아이디로 번호 조회
		MemberNoService1 memberNoService = new MemberNoService1();
		int memberNo = memberNoService.getMemberno(id);

		// 멤버아이디로 중복검사
		CartOverlapSvc cartOverlapSvc = new CartOverlapSvc();
		int cartOver = cartOverlapSvc.cart(memberNo, restName);

		// 보드번호로 식당번호 조회
		RestNoService restNoService = new RestNoService();
		int restNo = restNoService.getRestNo(boardNum);
		System.out.println(memberNo);
		System.out.println(restName);
		System.out.println(cartOver);
		if (cartOver > 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 있는 가게입니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {

			Cart cart = new Cart();
			cart.setImg(img);
			cart.setMember_no(memberNo);
			cart.setRest_no(restNo);
			cart.setRestName(restName);

			CartAddService cartAddSvc = new CartAddService();
			int addCart = cartAddSvc.addCart(cart);

			if (addCart > 0) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('찜목록에 추가되었습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
		}

		return forward;
	}

}
