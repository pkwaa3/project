package review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import review.svc.ReviewWriteProService;
import vo.ActionForward;
import vo.Review;

public class ReviewWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ActionForward forward = null;
		Review review = new Review();
		
		
		
		System.out.println(session.getAttribute("id"));
		System.out.println(session.getAttribute("owner_id"));
		System.out.println(request.getParameter("board_no"));
		System.out.println(request.getParameter("review_content"));
		
		review.setMember_id((String)session.getAttribute("member_id"));
		review.setOwner_id((String)session.getAttribute("owner_id"));
		review.setBoard_no(Integer.parseInt(request.getParameter("board_no")));
		review.setReview_content("review_content");
		
		
		ReviewWriteProService reviewWriteProService = new ReviewWriteProService();
		boolean isWriteSuccess = reviewWriteProService.registArticle(review);
		
		
		
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardView.bo");
		}
		return forward;
	}

}
