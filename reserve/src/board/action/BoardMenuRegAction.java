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
import com.oreilly.servlet.multipart.MultipartParser;

import action.Action;
import board.svc.BoardRegSvc;
import board.svc.MenuRegistSvc;
import board.svc.RestNoSvc;
import vo.ActionForward;
import vo.Board;
import vo.Menu;

public class BoardMenuRegAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String realFolder = "";
		
		//한번에 업로드 할 수 있는 파일의 크기
		String saveFolder = "/upload";
		String encType = "utf-8";
		int maxSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		//MultipartRequest multi = new MultipartParser(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String menu_img = multi.getFilesystemName("menu_img");
		
		
		
		
		
		
		System.out.println("menu_img = "+multi.getParameter("menu_img"));
		System.out.println("menu_img = "+menu_img);
		
		
		//owner_no가져오기
		HttpSession session = request.getSession();
		int owner_no = (int) session.getAttribute("owner_no");
		//rest_no찾기
		String board_subject= multi.getParameter("board_subject");
		int rest_no;
		RestNoSvc restNoSvc = new RestNoSvc();
		rest_no = restNoSvc.searchRestNo(board_subject);
		
		System.out.println("board_subject =" + multi.getParameter("board_subject"));
		System.out.println("board_kind =" + multi.getParameter("kind"));
		System.out.println("board_content =" + multi.getParameter("board_content"));
		System.out.println("owner_no =" + owner_no);
		System.out.println("rest_no =" + rest_no);
		
		//board 값 넣기
		Board board = new Board();
		board.setBoard_subject(multi.getParameter("board_subject"));
		board.setKind(multi.getParameter("kind"));
		board.setBoard_content(multi.getParameter("board_content"));
		board.setOwner_no(owner_no);
		board.setRest_no(rest_no);
		
		//board 값 insert, 확인
		BoardRegSvc boardRegSvc = new BoardRegSvc();
		boolean isBoardSuccess = boardRegSvc.registBoard(board);
		
		
		System.out.println("mult menu name = "+multi.getParameterValues("menu_name"));
		
		//메뉴 배열 가져오기
		String[] menuName= multi.getParameterValues("menu_name");
		String[] menuPrice = multi.getParameterValues("menu_price");
		String[] menuImg =multi.getParameterValues("menu_img");
		
		System.out.println("menuNAme = "+menuName);
		System.out.println("menuPrice ="+menuPrice);
		System.out.println("menuImg ="+menuImg);
		
		//메뉴 리스트 등록하기
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		Menu menu = new Menu();
		for(int i=0; i<menuName.length; i++) {
			menu.setBoard_no(board.getBoard_no());
			menu.setRest_no(rest_no);
			menu.setMenu_name(menuName[i]);
			menu.setMenu_price(Integer.parseInt(menuPrice[i]));
			menu.setMenu_img(menuImg[i]);
			menuList.add(menu);
		}
		
		
		System.out.println(menuList.get(1).getMenu_name());
		for(int j=0; j<menuList.size();j++) {
			System.out.println(menuList.get(j).getMenu_name());
			System.out.println(menuList.get(j).getMenu_price());
			System.out.println(menuList.get(j).getMenu_img());
		}
		
		//파일 업로드 될 서버상의 물리적인 경로
		MenuRegistSvc menuRegistSvc = new MenuRegistSvc();
		boolean isMenuSuccess = menuRegistSvc.registMenu(menuList);
		
		
		
		
		ActionForward forward = null;
		
		if(isBoardSuccess && isMenuSuccess) {
			forward = new ActionForward("ownerMyPage.own", true);
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
