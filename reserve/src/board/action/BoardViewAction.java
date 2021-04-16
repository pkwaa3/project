package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.BoardViewService;
import review.svc.ReviewListService;
import vo.ActionForward;
import vo.Board;
import vo.Menu;
import vo.PageInfo;
import vo.Review;

public class BoardViewAction implements Action {

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
	
		
		
		
		
		int reviewPage = 1;
		int limit = 10;
		int limitPage = 10;
		
		
		if(request.getParameter("reviewPage") != null) {
			reviewPage = Integer.parseInt(request.getParameter("page"));
		}
		ReviewListService reviewListService = new ReviewListService();
		int listCount = reviewListService.getListCount();
		int maxPage = (int)((double)listCount/limit + 0.95);
		int startPage = (((int)((double)reviewPage / limitPage + 0.9)) -1) * limitPage + 1;
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEnd_page(endPage);
		pageInfo.setList_count(listCount);
		pageInfo.setMax_page(maxPage);
		pageInfo.setPage(reviewPage);
		pageInfo.setStart_page(startPage);
		
		ArrayList<Review> articleList = new ArrayList<>();
		articleList = reviewListService.getArticleList(reviewPage, limit, board_no);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		//ActionForward forward = new ActionForward();
		
		forward.setPath("boardViewInfo.bo");
		
		
		return forward;
	}

}
