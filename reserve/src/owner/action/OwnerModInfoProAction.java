package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import owner.svc.OwnerModInfoProSvc;
import vo.ActionForward;
import vo.Owner;

public class OwnerModInfoProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		
			Owner owner = new Owner();
			System.out.println(request.getParameter("owner_id"));
			owner.setOwner_id(request.getParameter("owner_id"));
			owner.setOwner_pw(request.getParameter("owner_pw"));
			owner.setOwner_name(request.getParameter("owner_name"));
			owner.setOwner_age(request.getParameter("owner_age"));
			owner.setOwner_gender(request.getParameter("owner_gender"));
			owner.setOwner_number(request.getParameter("owner_number"));
			owner.setOwner_email(request.getParameter("owner_email"));
	    
	    	OwnerModInfoProSvc ownerModInfoProSvc = new OwnerModInfoProSvc();
	    	boolean isModifySuccess = ownerModInfoProSvc.modifyOwnerInfo(owner);
	    	
	    	if(isModifySuccess) {
	    		session.setAttribute("owner_id", owner.getOwner_id());
				session.setAttribute("owner_pw", owner.getOwner_pw());
	    		response.setContentType("text/html;charset=utf-8");
	    		PrintWriter out = response.getWriter();
	    		out.println("<script>");
	    		out.println("alert('수정되었습니다.');");
	    		out.println("location.href='ownerMyPage.own?owner_id="+owner.getOwner_id()+"'");
	    		out.println("</script>");
	    		
	    		
				
	    		
	    		
	    		
	    	} else {
	    		response.setContentType("text/html;charset=utf-8");
	    		PrintWriter out = response.getWriter();
	    		out.println("<script>");
	    		out.println("alert('수정실패하였습니다.');");
	    		out.println("history.back();");
	    		out.println("</script>");
	    	}
		
		
		return forward;
	}

}
