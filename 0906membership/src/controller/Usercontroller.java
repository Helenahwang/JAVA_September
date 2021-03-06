package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import service.UserService;
import service.UserServiceImpl;
import vo.TMember;


@WebServlet("/user/*")
public class Usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
    public Usercontroller() {
        super();
        userService = UserServiceImpl.sharedInstatnce();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청경로에서 프로젝트 경로를 제거
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();//프로젝트 경로 => WebContent 
		
		String command = requestURI.substring(contextPath.length()+1);
		
		//세션을 사용하는 경우가 많으므로 여기서 세션 생성
		HttpSession session = request.getSession();
		
		//command가 콘솔에 출력이 안되면 url 제대로 처리하지 못하는 것이다.
		//form에서 전송할 때 사용할 url과 servlet이 처리하는 url이 같은지 확인한다.
		System.out.println(command);
		
		switch(command) {
		case "user/login" :
			//서비스 메소드 호출
			TMember user = userService.login(request);
			
			//로그인 실패한 경우
			if(user == null) {
				session.setAttribute("user", user);
				session.setAttribute("msg", "email 이나 비밀번호가 틀렸습니다.");
			}
			//로그인 성공한 경우
			else {
				session.setAttribute("user", user);
				//System.out.println("성공");
			}
			
			//로그인 성공여부에 관계없이 메인 페이지로 리다이렉트
			//현재 요청에서 user/login 이므로 현재 위치는 user
			//메인으로 가려면 user의 상위로 이동해야 한다. 
		
			response.sendRedirect("../");
			break;
			
		case "user/logout":
			//세션을 초기화
			session.invalidate();
			//시작 페이지로 리다이렉트
			response.sendRedirect("../");
			break;
			
		case "user/register":
			//단순 페이지 이동 
			RequestDispatcher dispatcher = 
			request.getRequestDispatcher("../register.jsp"); // WebContent에 있는 jsp일 때
			//"../디렉토리이름/페이지이름" : WebContect 안에 디렉토리(파일)이 있을 때 ex) "../member/register.jsp"
			dispatcher.forward(request, response);
			
			break;

		
		
		case "user/insert":
			
			boolean r = userService.registerMember(request);
			if(r == true) {
				//회원가입에 성공했을 때 처리
				
				session.setAttribute("msg", "회원 가입에 성공하셨습니다.");
				response.sendRedirect("../"); //로그인 하러 메인으로 이동 
				
			}else {
				//회원가입에 실패했을 때 처리
				session.setAttribute("registermsg", "회원 가입에 실패하셨습니다.");
				response.sendRedirect("register");
			}
			
			break;
			
		
			
		case "user/emailcheck":
			boolean result = userService.emailCheck(request);
			
			//Json으로 출력할 때는 리턴받은 데이터를 바로 저장하지 않고, JSON 객체로 변환해서 저장
			JSONObject obj=new JSONObject();
			obj.put("result", result); //키 와 값
			
			
			//데이터 저장
			request.setAttribute("result", obj); 
			
			//결과 페이지로 포워딩 - 리다이렉트로 가능
			dispatcher = request.getRequestDispatcher("../emailcheck.jsp");
			dispatcher.forward(request, response);
			
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
