package board.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import board.svc.MenuModProService;
import vo.ActionForward;
import vo.Board;
import vo.Menu;

public class MenuModInfoProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("owner_id");
		String rest_no = request.getParameter("rest_no");

		// int rest_no = Integer.parseInt(request.getParameter("rest_no"));
		// int rest_no = (int) session.getAttribute("rest_no");

		ActionForward forward = null;
		Board board = null;
		ArrayList<Menu> list = new ArrayList<Menu>();

		String realFolder = "";
		String saveFolder = "/upload";
		int fileSize = 20 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8",
				new DefaultFileRenamePolicy());

		//String board1 = multi.getParameter("board_subject");
		// System.out.println(board1);
		//RestSearchService restsvc = new RestSearchService();
		//int rest_no = restsvc.findRestNo(board1);
		// System.out.println(rest_no);

		board = new Board();
		board.setBoard_subject(multi.getParameter("board_subject"));
		board.setBoard_content(multi.getParameter("board_content"));
		//board.setOwner_no(Integer.parseInt(multi.getParameter("owner_no")));
		board.setAddr(multi.getParameter("addr"));
		board.setRest_no(Integer.parseInt(multi.getParameter("rest_no")));
		
		String[] menuNo = multi.getParameterValues("menu_no");
		String[] menuName = multi.getParameterValues("menu_name");
		String[] menuPrice = multi.getParameterValues("menu_price");
		// String[] menuImg =multi.getParameterValues("menu_img");
		
	
		
		int i = 0;

		Enumeration files = multi.getFileNames();

		while (files.hasMoreElements()) {
			//System.out.println(menuName.length);
			//System.out.println(files.hasMoreElements());
			Menu menu = null;
			if (i < 1) {
				String file = (String) files.nextElement();
				board.setMain_org_img(multi.getOriginalFileName(file));
				board.setMain_sys_img(multi.getFilesystemName(file));
			
				
			} else {
				menu = new Menu();
				menu.setMenu_no(Integer.parseInt(menuNo[i]));
				menu.setMenu_name(menuName[i]);
				menu.setMenu_price(Integer.parseInt(menuPrice[i]));
				String file = (String) files.nextElement();
				menu.setMenu_org_img(multi.getOriginalFileName(file));
				menu.setMenu_sys_img(multi.getFilesystemName(file));
				list.add(menu);
			}

			
			i++;
		}
//		System.out.println(list.size());
//		for (int j = 1; j < list.size(); j++) {
//		    System.out.println(list.get(j).getMenu_no());
//			System.out.println(list.get(j).getMenu_name());
//			System.out.println(list.get(j).getMenu_price());
//			System.out.println(list.get(j).getMenu_org_img());
//			System.out.println(list.get(j).getMenu_sys_img());
//		}

		// menu.setMenu_price(Integer.parseInt(multi.getParameter("menu_price")));
		// menu.setMenu_img(multi.getParameter("menu_img"));

		MenuModProService menuModProService = new MenuModProService();
		boolean isBoardModSuccess = menuModProService.BoardModPro(board);

		// boolean isMeRegSuccess = boardRegService.registArticle(list);

		boolean isMenuModSuccess = menuModProService.MenuModPro(list);

		if (isBoardModSuccess && isMenuModSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("ownerMyPage.own?owner_id=" + id);
		} else {
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
