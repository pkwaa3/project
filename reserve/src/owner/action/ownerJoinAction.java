package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import owner.svc.OwnerJoinService;
import vo.ActionForward;
import vo.Owner;

public class ownerJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Owner owner=new Owner();
   		boolean joinResult=false;
   		
   		owner.setOwner_id(request.getParameter("owner_id"));
   		owner.setOwner_pw(request.getParameter("owner_pw"));
   		owner.setOwner_name(request.getParameter("owner_name"));
   		owner.setOwner_age(request.getParameter("owner_age"));
   		owner.setOwner_gender(request.getParameter("owner_gender"));
   		owner.setOwner_number(request.getParameter("owner_number"));
   		owner.setOwner_eamil(request.getParameter("owner_email"));
   		
   		OwnerJoinService ownerJoinService = new OwnerJoinService();
   		joinResult=ownerJoinService.joinMember(owner);
   		
   		ActionForward forward = null;
   		if(joinResult==false){
   			response.setContentType("text/html;charset=UTF-8");
   			PrintWriter out = response.getWriter();
   			out.println("<script>");
   			out.println("alert('회원등록실패')");
   			out.println("history.back()");
   			out.println("</script>");
	   	}
   		else{
   	    
   		response.setContentType("text/html;charset=utf-8");
		
   		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('회원가입하였습니다.');");
		out.println("location.href='ownerLoginForm.own'");
		out.println("</script>");
   		}
   		return forward;
}
}