package company.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import company.svc.CompanyLoginService;
import vo.ActionForward;
import vo.Company;

public class companyLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Company company = new Company();
		
		company.setCom_id(request.getParameter("com_id"));
		company.setCom_pw(request.getParameter("com_pw"));
		
		CompanyLoginService companyLoginService = new CompanyLoginService();
		boolean loginResult = companyLoginService.login(company);
		
		ActionForward forward=null;
		if(loginResult) {
			forward=new ActionForward();
			session.setAttribute("id", company.getCom_id());
			forward.setPath("company/companylist.jsp");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패');");
			out.println("'location.href='./companylogin.jsp';");
			out.println("</script>");
		}
		
		
		
		return forward;
	}

}
