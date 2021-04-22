package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberDeleteService;
import owner.svc.OwnerDelSvc;
import owner.svc.OwnerDeleteService;
import owner.svc.OwnerNoService;
import vo.ActionForward;

public class OwnerDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =null;
		HttpSession session = request.getSession();
		
		String owner_id = request.getParameter("owner_id");
		String owner_pw = request.getParameter("owner_pw");
		System.out.println(owner_id);
		//아이디로 번호찾기
		OwnerNoService ownerNoService = new OwnerNoService();
		int ownerNo=ownerNoService.getNo(owner_id);
		
		//번호로 가게 삭제
		OwnerDelSvc ownerDelSvc = new OwnerDelSvc();
		boolean isDel =ownerDelSvc.Del(ownerNo);
		
		OwnerDeleteService ownerDeleteService = new OwnerDeleteService();
		boolean isDeleteSuccess = ownerDeleteService.deleteOwner(owner_id, owner_pw);
		
		if(isDeleteSuccess) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴되었습니다.');");
			out.println("location.href='main.com';");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
