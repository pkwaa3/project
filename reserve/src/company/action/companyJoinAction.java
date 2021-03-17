package company.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import company.svc.CompanyJoinService;
import vo.ActionForward;
import vo.Company;

public class companyJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Company company = new Company();
		boolean joinResult = false;
		ActionForward forward =null;
		company.setCom_id(request.getParameter("company_id"));
		company.setCom_pw(request.getParameter("company_pw"));
		company.setCom_admin(request.getParameter("company_admin"));
		
		CompanyJoinService companyJoinService = new CompanyJoinService();
		joinResult=companyJoinService.joinMember(company);
		
		if(joinResult == false) {
			response.setContentType("text/html;charset=UTF-8");
   			PrintWriter out = response.getWriter();
   			out.println("<script>");
   			out.println("alert('회원등록실패')");
   			out.println("history.back()");
   			out.println("</script>");
		}else{
   			response.setContentType("text/html;charset=UTF-8");
   			PrintWriter out = response.getWriter();
   			out.println("<script>");
   			out.println("alert('회원등록성공')");
   			out.println("location.href='ownerLoginForm.own'");
   			out.println("</script>");
   	    //forward = new ActionForward();
   	    //forward.setRedirect(true);
		//forward.setPath("owner/ownerlogin.jsp");
		
		
		
	}
		return forward;

	}
}