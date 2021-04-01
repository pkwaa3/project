package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.MarketSearchService;
import vo.ActionForward;
import vo.Board;
import vo.PageInfo;


public class MarketSearchMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = 1;
		int limit = 12;
		int limitPage = 10;
		String local = request.getParameter("where");
		String kind = request.getParameter("menu");
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		MarketSearchService marketSearchService = new MarketSearchService();
		int listCount = marketSearchService.getListCount(local, kind);
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
		
		ArrayList<Board> searchList = new ArrayList<>();
		searchList = marketSearchService.getSeletSearch(page, limit, local, kind);
		
		System.out.println(listCount);
		System.out.println(maxPage);
		System.out.println(startPage);
		System.out.println(endPage);
		System.out.println(local);
		System.out.println(kind);
		
		request.setAttribute("local", local);
		request.setAttribute("kind", kind);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("searchList", searchList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/marketSerchFormMember.bo");
		
		return forward;
	}

}
