package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

import board.action.BoardRegAction;
import board.action.BoardRegFormAction;
import board.action.BoardViewAction;
import board.action.BoardViewMemAction;
import board.action.CartAddAction;
import board.action.CartListAction;
import board.action.MarketSearchAction;
import board.action.ReservationAction;
import board.action.reservationListAction;
import board.action.MarketSearchMemberAction;
import board.action.MenuModInfoProAction;
import board.action.ReservInfoAction;
import board.action.ReservInfoOwAction;
import member.action.MemberDeleteAction;
import member.action.MemberJoinProAction;
import member.action.MemberLogOutAction;
import member.action.MemberLoginAction;
import member.action.MemberModAction;
import member.action.MemberModInfoFormAction;
import company.action.companyJoinAction;
import company.action.companyLoginAction;
import owner.action.MarketModInfoFormAction;
import owner.action.MenuModInfoFormAction;
import owner.action.OwnerDeleteAction;
import owner.action.OwnerLogOutAction;
import owner.action.OwnerModInfoFormAction;
import owner.action.OwnerModInfoProAction;
import owner.action.OwnerRegiMarketProAction;
import owner.action.marketModInfoProAction;
import owner.action.ownerJoinAction;
import owner.action.ownerLoginAction;
import owner.action.ownerRegiMarketListAction;
import review.action.ReviewListProAction;
import review.action.ReviewWriteProAction;
import vo.ActionForward;

/**
 * Servlet implementation class reservFrontController
 */
@WebServlet(urlPatterns = { "*.mem", "*.own", "*.com", "*.bo" })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);

		if (command.equals("/loginForm.log")) {
			forward = new ActionForward();
			forward.setPath("/member/loginForm.jsp");
		}
		// 멤버 로그인 폼
		else if (command.equals("/memberLoginForm.mem")) {
			forward = new ActionForward();
			forward.setPath("/member/memberLoginForm.jsp");
		}

		// 멤버 로그인 프로세스
		else if (command.equals("/memberLoginProccess.mem")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 멤버 회원가입 폼
		else if (command.equals("/memberJoinForm.mem")) {
			forward = new ActionForward();
			forward.setPath("/member/memberJoinForm.jsp");
		}
		// 멤버 회원가입 프로세스
		else if (command.equals("/memberJoinProccess.mem")) {
			action = new MemberJoinProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 오너 회원 정보 수정 폼
		else if (command.equals("/ownerModInfoForm.own")) {
			action = new OwnerModInfoFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 오너 회원 정보 수정 프로
		else if (command.equals("/ownerModInfoPro.own")) {
			action = new OwnerModInfoProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 오너 마이페이지 폼
		else if (command.equals("/ownerMyPage.own")) {
			forward = new ActionForward();
			forward.setPath("/owner/ownerMyPage.jsp");
		}

		// 오너 가게 정보 폼
		else if (command.equals("/ownerRegiMarketForm.own")) {
			forward = new ActionForward();
			forward.setPath("/owner/ownerRegiMarketForm.jsp");
		}
		// 오너 가게 정보 프로
		else if (command.equals("/ownerRegiMarketPro.own")) {
			action = new OwnerRegiMarketProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 오너 로그아웃
		else if (command.equals("/ownerLogout.own")) {
			action = new OwnerLogOutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 오너 회원 탈퇴 폼
		else if (command.equals("/ownerDeleteForm.own")) {
			forward = new ActionForward();
			forward.setPath("owner/ownerDeleteForm.jsp");
		}
		// 오너 회원탈퇴 액션
		else if (command.equals("/ownerDelete.own")) {
			action = new OwnerDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 멤버 마이페이지 폼
		else if (command.equals("/memberMyPage.mem")) {
			forward = new ActionForward();
			forward.setPath("member/memberMyPage.jsp");
		}
		// 오너 마이페이지 폼
		else if (command.equals("/ownerMyPage.own")) {
			forward = new ActionForward();
			forward.setPath("owner/ownerMyPage.jsp");
		}
		// 오너 로그인 메인 폼
		else if (command.equals("/mainLoginOwner.com")) {
			forward = new ActionForward();
			forward.setPath("/mainLoginOwner.jsp");
		}
		// 멤버 회원가입 아이디 조회
		else if (command.equals("/memberIdCheck.mem")) {
			forward = new ActionForward();
			forward.setPath("member/memberIdCheck.jsp");
		}
		// 오너 회원가입 아이디 조회
		else if (command.equals("/ownerIdCheck.own")) {
			forward = new ActionForward();
			forward.setPath("owner/ownerIdCheck.jsp");
		}
		// 가게등록 리스트 액션
		else if (command.equals("/ownerRegiMarketList.own")) {
			action = new ownerRegiMarketListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 가게등록 리스트 폼
		else if (command.equals("/ownerRegiMarketListForm.own")) {
			forward = new ActionForward();
			forward.setPath("/owner/ownerRegiMarketList.jsp");
		}

		// 마켓 서치 리스트 액션
		else if (command.equals("/marketSearch.bo")) {
			action = new MarketSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 마켓 서치 리스트 상단바 액션
		else if (command.equals("/marketSearch1.bo")) {
			action = new MarketSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 마켓 서치 리스트 폼
		else if (command.equals("/marketSerchForm.bo")) {
			forward = new ActionForward();

			forward.setPath("/board/marketSerchForm.jsp");
		}

		// 마켓 서치 리스트 액션 멤버
		else if (command.equals("/marketSearchMember.bo")) {
			action = new MarketSearchMemberAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// forward.setPath("/board/marketSerchForm.jsp");
		}

		// 마켓 서치 리스트 액션 멤버
		else if (command.equals("/marketSearchMember.bo")) {
			action = new MarketSearchMemberAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		// 마켓 서치 리스트 폼 멤버로
		else if (command.equals("/marketSerchFormMember.bo")) {
			forward = new ActionForward();
			forward.setPath("/board/marketSerchFormMember.jsp");
		}

		// 가게 정보 수정 폼
		else if (command.equals("/marketModInfoForm.own")) {
			action = new MarketModInfoFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 가게 정보 수정 프로
		else if (command.equals("/marketModInfoPro.own")) {
			action = new marketModInfoProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 메뉴 정보 수정 폼

		else if (command.equals("/menuModInfoForm.own")) {
			action = new MenuModInfoFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/menuModInfoForm.own")) {
			action = new MenuModInfoFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 메뉴 정보 수정 프로
		else if (command.equals("/menuModInfoPro.own")) {
			action = new MenuModInfoProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 리뷰 작성 프로
				else if (command.equals("/reviewWritePro.bo")) {
					action = new ReviewWriteProAction();
					try {
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		// 리뷰 리스트 프로
				else if (command.equals("/reviewListPro.bo")) {
					action = new ReviewListProAction();
					try {
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		
		
		
		
		

		// ㅈㅇ우
		// 오너 로그인 액션
		else if (command.equals("/ownerLogin.own")) {
			action = new ownerLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 오너 로그인 폼
		else if (command.equals("/ownerLoginForm.own")) {
			forward = new ActionForward();
			forward.setPath("owner/ownerlogin.jsp");
		}
		// 오너 회원가입
		else if (command.equals("/ownerJoin.own")) {
			action = new ownerJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 오너 회원가입 폼
		else if (command.equals("/ownerJoinForm.own")) {
			forward = new ActionForward();
			forward.setPath("owner/ownerjoin.jsp");
		}
		// 컴퍼니 로그인 액션
		else if (command.equals("/companyLogin.com")) {
			action = new companyLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 컴퍼니 로그인 폼
		else if (command.equals("/companyLoginForm.com")) {
			forward = new ActionForward();
			forward.setPath("company/companylogin.jsp");
		}
		// 컴퍼니 회원가입
		else if (command.equals("/companyJoin.com")) {
			action = new companyJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 컴퍼니 회원가입 폼
		else if (command.equals("/companyJoinForm.com")) {
			forward = new ActionForward();
			forward.setPath("company/companyjoin.jsp");
		}
		// 멤버 정보수정
		else if (command.equals("/memberMod.mem")) {
			action = new MemberModAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 맴버 인포 폼
		else if (command.equals("/memberModInfoForm.mem")) {
			action = new MemberModInfoFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 멤버 회원 탈퇴 폼
		else if (command.equals("/memberDeleteForm.mem")) {
			forward = new ActionForward();
			forward.setPath("member/memberDeleteForm.jsp");
		}
		// 맴버 회원탈퇴 액션
		else if (command.equals("/memberDelete.mem")) {
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 메인 폼
		else if (command.equals("/main.com")) {
			forward = new ActionForward();
			forward.setPath("/main.jsp");
		}
		// 멤버 로그아웃
		else if (command.equals("/memberLogout.mem")) {
			action = new MemberLogOutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 리스트 글 등록액션 이거 하던거
		else if (command.equals("/boardReg.bo")) {
			action = new BoardRegAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 리스트 글등록 인포 폼
		else if (command.equals("/boardRegInfoForm.bo")) {
			action = new BoardRegFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 리스트 글등록 폼
		else if (command.equals("/boardRegForm.bo")) {
			forward = new ActionForward();
			forward.setPath("owner/boardReg.jsp");
		}
		// 뷰페이지액션
		else if (command.equals("/boardView.bo")) {
			action = new BoardViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 뷰페이지멤버액션
		else if (command.equals("/boardViewMem.bo")) {
			action = new BoardViewMemAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 뷰페이지
		else if (command.equals("/boardViewInfo.bo")) {
			forward = new ActionForward();
			forward.setPath("board/boardView1.jsp");
		}
		// 예약하기 액션
		else if (command.equals("/reservation.bo")) {
			action = new ReservationAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 뷰페이지멤버12311
		else if (command.equals("/boardViewInfoMem.bo")) {
			forward = new ActionForward();
			forward.setPath("board/boardView2.jsp");
		}

		// 뷰페이지
		else if (command.equals("/boardViewInfo.bo")) {
			forward = new ActionForward();
			forward.setPath("board/boardView1.jsp");
		}
		// 예약하기 액션
		else if (command.equals("/reservation.bo")) {
			action = new ReservationAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 뷰페이지멤버
		else if (command.equals("/boardViewInfoMem.bo")) {
			forward = new ActionForward();
			forward.setPath("board/boardView2.jsp");
		}
		// 예약내역 멤버 액션
		else if (command.equals("/reservInfo.mem")) {
			action = new ReservInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 예약내역 폼멤버
		else if (command.equals("/reservInfoForm.mem")) {
			forward = new ActionForward();
			forward.setPath("board/reservInfo.jsp");
		}
		// 예약 가게 리스트 오너 액션
		else if (command.equals("/reservationList.own")) {
			action = new reservationListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 예약 가게 리스트 오너 폼
		else if (command.equals("/reservationInfoForm.own")) {
			forward = new ActionForward();
			forward.setPath("board/reservationList.jsp");
		}
		// 예약내역 오너 액션
		else if (command.equals("/reservInfoOw.own")) {
			action = new ReservInfoOwAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 예약내역 폼오너
		else if (command.equals("/reservInfoOwForm.own")) {
			forward = new ActionForward();
			forward.setPath("board/reservationInfoOwn.jsp");
		}
		// 찜하기 액션
//		else if (command.equals("/cartList.bo")) {
//			action = new CartListAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		// 찜하기 폼
		else if (command.equals("/cartList.bo")) {
			forward = new ActionForward();
			forward.setPath("board/CartList.jsp");
		}
		// 찜하기폼 액션
		else if (command.equals("/cartAdd.bo")) {
			action = new CartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}
}