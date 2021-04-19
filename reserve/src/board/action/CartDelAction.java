package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import board.svc.CartDelSvc;
import vo.ActionForward;

public class CartDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("member_id");
		String cartNo=request.getParameter("cart_no");
		
		CartDelSvc cartDelSvc=new CartDelSvc();
		int cartDel=cartDelSvc.delete(cartNo);
		
		if(cartDel>0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('찜목록에서 삭제되었습니다.');");
			out.println("location.href='memberMyPage.mem?member_id="+id+"';");
			out.println("</script>");
			
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('취소실패. 관리자에게 문의하여주세요');");
			out.println("history.back();");
			out.println("</script>");
			
		}
		
		
		return forward;
	}

}
