package board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.CartListService;
import member.svc.MemberNoService;
import vo.ActionForward;
import vo.Cart;

public class CartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String id = request.getParameter("member_id");
		
		//멤버 아이디로 번호 조회
		MemberNoService memberNoService = new MemberNoService();
		int memberNo= memberNoService.getMember(id);

		ArrayList<Cart> list = new ArrayList<Cart>();
		CartListService cartListSvc = new CartListService();
		list = cartListSvc.getList(memberNo);

		System.out.println(list);
		System.out.println(memberNo);
		System.out.println(id);
		forward = new ActionForward();
		forward.setPath("cartListForm.bo");
		request.setAttribute("list", list);

		return forward;
	}

}
