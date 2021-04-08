package review.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import review.svc.ReviewListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.Review;

public class ReviewListProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int page = 1;
		int limit = 10;
		int limitPage = 10;
		String board_no = request.getParameter("board_no");
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ReviewListService reviewListService = new ReviewListService();
		int listCount = reviewListService.getListCount();
		int maxPage = (int)((double)listCount/limit + 0.95);
		int startPage = (((int)((double)page / limitPage + 0.9)) -1) * limitPage + 1;
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEnd_page(endPage);
		pageInfo.setList_count(listCount);
		pageInfo.setMax_page(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStart_page(startPage);
		
		ArrayList<Review> articleList = new ArrayList<>();
		articleList = reviewListService.getArticleList(page, limit, board_no);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");
		
		return forward;
	}

}
