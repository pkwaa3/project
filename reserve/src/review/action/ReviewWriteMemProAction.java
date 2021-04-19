package review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import review.svc.ReviewWriteProService;
import vo.ActionForward;
import vo.Review;

public class ReviewWriteMemProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ActionForward forward = null;
		Review review = new Review();
		
		String board_no = request.getParameter("board_no");
		String page = request.getParameter("page");
		System.out.println(request.getParameter("nowPage"));
		
		System.out.println(session.getAttribute("id"));
		System.out.println(session.getAttribute("owner_id"));
		System.out.println(request.getParameter("board_no"));
		System.out.println(request.getParameter("review_content"));
		
		if(session.getAttribute("owner_id") != null || session.getAttribute("id") != null) {
		
		review.setMember_id((String)session.getAttribute("id"));
		review.setOwner_id((String)session.getAttribute("owner_id"));
		review.setBoard_no(Integer.parseInt(request.getParameter("board_no")));
		review.setReview_content(request.getParameter("review_content"));
		
		
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
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록되었습니다.')");
			out.println("location.reload();");
			out.println("</script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardViewMem.bo?board_no="+board_no+"&page="+page);
		}
		
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요')");
			out.println("history.back();");
			out.println("</script>");
			
		}
		
		
		
		return forward;
	}

}
