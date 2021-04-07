package owner.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import board.svc.BoardModInfoSvc;
import owner.svc.MarketInfoSvc;
import vo.ActionForward;
import vo.Board;
import vo.Menu;
import vo.Restaurant;

public class MenuModInfoFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		
		String owner_id = (String) session.getAttribute("owner_id");
		String restNo = request.getParameter("rest_no");
		
		BoardModInfoSvc boardModInfoSvc = new BoardModInfoSvc();
		Board board = boardModInfoSvc.getboardModInfo(restNo);
		request.setAttribute("board", board);
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		
		BoardModInfoSvc menuModInfoSvc = new BoardModInfoSvc();
		menuList = menuModInfoSvc.getMenuModInfo(restNo);
		request.setAttribute("menuList", menuList);
		
		
			
			forward = new ActionForward();
			forward.setPath("/owner/menuModInfoForm.jsp");
		
		
		
		return forward;
	}

}
