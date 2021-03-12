package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.svc.MemberJoinService;
import vo.ActionForward;
import vo.MemberBean;
import vo.Owner;

public class ownerJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Owner owner=new Owner();
   		boolean joinResult=false;
   		
   		owner.setOwner_id(request.getParameter("owner_id"));
   		owner.setOwner_pw(request.getParameter("owner_pw"));
   		owner.setOwner_name(request.getParameter("owner_name"));
   		owner.setOwner_age(Integer.parseInt(request.getParameter("owner_age")));
   		owner.setOwner_gender(request.getParameter("owner_gender"));
   		owner.setOwner_eamil(request.getParameter("owner_email"));
   		
   		MemberJoinService memberJoinService = new MemberJoinService();
   		joinResult=memberJoinService.joinMember(member);
   		
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
   	    forward = new ActionForward();
   		forward.setRedirect(true);
   		forward.setPath("./memberLogin.me");
   		}
   		return forward;
}
}