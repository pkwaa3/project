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
			
			owner.setOwner_id(request.getParameter("id"));
			owner.setOwner_pw(request.getParameter("pass"));
			owner.setOwner_name(request.getParameter("name"));
			owner.setOwner_age(request.getParameter("age"));
			owner.setOwner_gender(request.getParameter("gender"));
			owner.setOwner_number(request.getParameter("number"));
			owner.setOwner_email(request.getParameter("email"));
	    	
	    	OwnerModInfoProSvc ownerModInfoProSvc = new OwnerModInfoProSvc();
	    	boolean isModifySuccess = ownerModInfoProSvc.modifyOwnerInfo(owner);
	    	
	    	if(isModifySuccess) {
	    		forward = new ActionForward();
	    		forward.setPath("memberInfo.mem?id="+owner.getOwner_id());
	    		forward.setRedirect(true);
	    		response.setContentType("text/html;charset=utf-8");
	    		PrintWriter out = response.getWriter();
	    		out.println("<script>");
	    		out.println("alert('수정되었습니다.');");
	    		out.println("history.back();");
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
