package board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import board.svc.BoardRegService;
import vo.ActionForward;
import vo.Board;
import vo.Menu;

public class BoardRegAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("owner_id");
		ActionForward forward = null;
		Board board = null;
		ArrayList<Menu> list = new ArrayList<Menu>();
		String realFolder="";
		String saveFolder="/upload";
		int fileSize=20*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);
		MultipartRequest multi=new MultipartRequest(request,realFolder,fileSize,"utf-8",new DefaultFileRenamePolicy());
		
		board = new Board();
		board.setBoard_subject(multi.getParameter("board_subject"));
		board.setKind(multi.getParameter("kind"));
		board.setBoard_content(multi.getParameter("board_content"));
		board.setOwner_no(Integer.parseInt(multi.getParameter("owner_no")));
		board.setRest_no(Integer.parseInt(multi.getParameter("rest_no")));
		
		for(int i = 0; i<list.size();i++) {
			Menu menu = new Menu();
			menu.setMenu_name(multi.getParameter("menu_name"));
			menu.setMenu_price(Integer.parseInt(multi.getParameter("menu_price")));
			menu.setMenu_img(multi.getParameter("menu_img"));
			menu.setRest_no(Integer.parseInt(multi.getParameter("rest_no")));
			
			list.add(menu);
		}
		
		BoardRegService boardRegService = new BoardRegService();
		boolean isBoRegSuccess = boardRegService.registArticle(board);
		boolean isMeRegSuccess = boardRegService.registArticle(list);
		if(isBoRegSuccess && isMeRegSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("ownerMyPage.own?owner_id="+id);
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글쓰기 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
			
		
		
		
		
		return forward;
	}

}
