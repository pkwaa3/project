package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.CartSearchSvc;
import vo.ActionForward;

public class CartViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= new ActionForward();
		int restNo=Integer.parseInt(request.getParameter("rest_no"));
		
		System.out.println(restNo);
		//식당번호로 보드번호 검색
		CartSearchSvc cartSearchSvc = new CartSearchSvc();
		String boardNo=cartSearchSvc.getboard(restNo);
		
		request.setAttribute(boardNo, "board_no");
		forward.setPath("boardViewInfoMem.bo");
		
		
		
		return forward;
	}

}
