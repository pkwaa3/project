package owner.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import owner.svc.OwnerLoginService;
import vo.ActionForward;
import vo.Owner;

public class ownerLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Owner owner = new Owner();
		
		
		owner.setOwner_id(request.getParameter("owner_id"));
		owner.setOwner_pw(request.getParameter("owner_pw"));
		
		OwnerLoginService ownerLoginService = new OwnerLoginService();
		boolean loginResult = ownerLoginService.login(owner);
		ActionForward forward=null;

		if(loginResult ==false) {

			forward=new ActionForward();
			session.setAttribute("id",owner.getOwner_id());
			forward.setPath("ownerMyPage.own");
			
		}  else {
			forward=new ActionForward();
			session.setAttribute("id",owner.getOwner_id());
			forward.setPath("ownerMyPage.own");
		}
		return forward;
	}

}
