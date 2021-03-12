package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.action.MemberJoinProAction;
import member.action.MemberLoginAction;
import vo.ActionForward;

/**
 * Servlet implementation class reservFrontController
 */
@WebServlet(urlPatterns = {"*.mem","*.own","*.com"})
public class reservFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		
		if(command.equals("/loginForm.log")) {
			forward = new ActionForward();
			forward.setPath("/member/loginForm.jsp");
		}
		
		//멤버 로그인 프로세스
		else if(command.equals("/memberLoginProccess.mem")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		//멤버 회원가입 폼
		else if(command.equals("/memberJoinForm.mem")) {
			forward = new ActionForward();
			forward.setPath("/member/memberJoinForm.jsp");
		}
		//멤버 회원가입 프로세스
		else if(command.equals("/memberJoinProccess.mem")) {
			action = new MemberJoinProAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
