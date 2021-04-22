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
import board.svc.BoardRegService;

import board.svc.RestSearchService;

import vo.ActionForward;
import vo.Board;
import vo.Menu;

public class BoardRegAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("owner_id");

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

		String board1 = multi.getParameter("board_subject");
		// System.out.println(board1);
		RestSearchService restsvc = new RestSearchService();
		int rest_no = restsvc.findRestNo(board1);
		// System.out.println(rest_no);

		board = new Board();
		board.setBoard_subject(multi.getParameter("board_subject"));
		board.setBoard_content(multi.getParameter("board_content"));
		board.setOwner_no(Integer.parseInt(multi.getParameter("owner_no")));
		board.setAddr(multi.getParameter("addr"));
		board.setRest_no(rest_no);

		String[] menuName = multi.getParameterValues("menu_name");
		String[] menuPrice = multi.getParameterValues("menu_price");
		// String[] menuImg =multi.getParameterValues("menu_img");

		int j=menuName.length;
		int k=1;
		Enumeration files = multi.getFileNames();

		while (files.hasMoreElements()) {
			int i = j-k;
			System.out.println(menuName.length);
			System.out.println(files.hasMoreElements());
			System.out.println(i);
			Menu menu = null;
			if (i == j-1) {
				String file = (String) files.nextElement();
				board.setMain_org_img(multi.getOriginalFileName(file));
				board.setMain_sys_img(multi.getFilesystemName(file));
				System.out.println(multi.getOriginalFileName(file));
				System.out.println(menuName[i]);
				System.out.println(Integer.parseInt(menuPrice[i]));
			}else if(i<0) {
				break;
			}else {
				menu = new Menu();
				menu.setMenu_name(menuName[i+1]);
				menu.setMenu_price(Integer.parseInt(menuPrice[i+1]));
				String file = (String) files.nextElement();
				menu.setMenu_org_img(multi.getOriginalFileName(file));
				menu.setMenu_sys_img(multi.getFilesystemName(file));
				System.out.println(menuName[i]);
				System.out.println(Integer.parseInt(menuPrice[i]));
				System.out.println(multi.getOriginalFileName(file));
				
			}

			list.add(menu);
			k++;
		}
//		System.out.println(list.size());
//		for (int j = 1; j < list.size(); j++) {
//			System.out.println(list.get(j).getMenu_name());
//			System.out.println(list.get(j).getMenu_price());
//			System.out.println(list.get(j).getMenu_org_img());
//			System.out.println(list.get(j).getMenu_sys_img());
//		}

		// menu.setMenu_price(Integer.parseInt(multi.getParameter("menu_price")));
		// menu.setMenu_img(multi.getParameter("menu_img"));

		BoardRegService boardRegService = new BoardRegService();
		boolean isBoRegSuccess = boardRegService.registArticle(board);

		// boolean isMeRegSuccess = boardRegService.registArticle(list);

		boolean isMeRegSuccess = boardRegService.registArticle(list, rest_no);
		
		if (isBoRegSuccess && isMeRegSuccess) {
			response.setContentType("text/html;charset=utf-8");
   			PrintWriter out = response.getWriter();
   			out.println("<script>");
   			out.println("alert('가게정보 등록 완료');");
   			out.println("location.href='ownerMyPage.own?owner_id="+id+"'");
   			out.println("</script>");
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
