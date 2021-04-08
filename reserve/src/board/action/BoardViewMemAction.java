package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.BoardViewService;
import vo.ActionForward;
import vo.Board;
import vo.Menu;

public class BoardViewMemAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_no=1;
		if(request.getParameter("board_no") != null)
			board_no = Integer.parseInt((request.getParameter("board_no")));
		String page= request.getParameter("page");
		
		BoardViewService boardViewService = new BoardViewService();
		ArrayList<Menu> list = new ArrayList<Menu>();
		Board board = boardViewService.getArticle(board_no);
		list= boardViewService.getMenu(board_no);
		
		request.setAttribute("board", board);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setPath("boardViewInfoMem.bo");
		
		
		return forward;
	}

}
