package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Buy;


@WebServlet("*.db")
public class DBConnector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DBConnector() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 주소에서 공통된 부분 제외한 부분을 추출
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		switch(command) {
		case "insert.db" :
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				//데이터베이스 연결

				con=DriverManager.getConnection("jdbc:mysql://localhost:3306"
							+ "/mysql?characterEncoding=UTF-8&serverTimezone=UTC","root","root1234");
				pstmt = con.prepareStatement("insert into usertbl(userid, name, birthyear, addr, mobile, mdate) "
						+ "values(?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, "jenny");
				pstmt.setString(2, "제니");
				pstmt.setInt(3, 1995);
				pstmt.setString(4, "제주");
				pstmt.setString(5, "01012345678");
				pstmt.setDate(6, new Date(5, 11, 3));
				int result = pstmt.executeUpdate();
				if(result > 0) {
					System.out.println("삽입성공");
				}
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(con != null) con.close();
					if(pstmt != null) pstmt.close();
					
				}catch(Exception e){
					
				}
				
			}
		
			break;
			
		case "delete.db" :
			con = null;
			pstmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				//데이터베이스 연결

				con=DriverManager.getConnection("jdbc:mysql://localhost:3306"
							+ "/mysql?characterEncoding=UTF-8&serverTimezone=UTC","root","root1234");
				pstmt = con.prepareStatement("delete from usertbl"
						+ " where userid=?");
				pstmt.setString(1, "jenny");

				int result = pstmt.executeUpdate();
				if(result > 0) {
					System.out.println("삭제성공");
				}else {
					System.out.println("에러는 없지만 삭제는 하지 않음");
				}
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(con != null) con.close();
					if(pstmt != null) pstmt.close();
					
				}catch(Exception e){
					
				}
				
			}
		
			break;
			
			
			
		case "selectlist.db" :
			con = null;
			pstmt = null;
			
			//select 구문은 결과를 저장할 변수가 필요 
			ResultSet rs=null;
			
			
			List<Buy> list = new ArrayList<Buy>();
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				//데이터베이스 연결

				con=DriverManager.getConnection("jdbc:mysql://localhost:3306"
							+ "/mysql?characterEncoding=UTF-8&serverTimezone=UTC","root","root1234");
				pstmt = con.prepareStatement("select * from buytbl");
				
				//sql을 실행하고 결과 저장하기 
				rs=pstmt.executeQuery();
				
				//리턴된 데이터를 읽어서 list에 저장
				while(rs.next()) {
					Buy buy = new Buy();
					buy.setNum(rs.getInt("num"));
					buy.setUserid(rs.getString("userid"));
					buy.setProductname(rs.getString("productname"));
					buy.setGroupname(rs.getString("groupname"));
					buy.setPrice(rs.getInt("price"));
					buy.setAmount(rs.getInt("amount"));
					
					list.add(buy);
				}

			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
					
				}catch(Exception e){
					
				}
				
			}
		
			
			for(Buy buy:list) {
				System.out.println(buy);
			}
			
			break;
			
			
		case "selectone.db" :
			con = null;
			pstmt = null;
			
			//select 구문은 결과를 저장할 변수가 필요 
			rs=null;

			//데이터 1개를 리턴하는 경우는 변수만 생성
			Buy buy=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				//데이터베이스 연결

				con=DriverManager.getConnection("jdbc:mysql://localhost:3306"
							+ "/mysql?characterEncoding=UTF-8&serverTimezone=UTC","root","root1234");
				pstmt = con.prepareStatement("select * from buytbl where num=?");
				
				String num=request.getParameter("num"); //"selectone.db?num=3" 에서 num=3 불러오기 
				//문자열을 정수로 변환해서 ?에 바인딩 한 것 
				pstmt.setInt(1, Integer.parseInt(num)); //String을 Int로 형변환 
				
				//sql을 실행하고 결과 저장하기 
				rs=pstmt.executeQuery();
				
				//리턴된 데이터를 읽어서 buy에 저장
				
				if(rs.next()) {
					buy = new Buy();
					buy.setNum(rs.getInt("num"));
					buy.setUserid(rs.getString("userid"));
					buy.setProductname(rs.getString("productname"));
					buy.setGroupname(rs.getString("groupname"));
					buy.setPrice(rs.getInt("price"));
					buy.setAmount(rs.getInt("amount"));

				}
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
					
				}catch(Exception e){
					
				}
				
			}
		
			//출력
			System.out.println(buy);

			
			break;
			
			
			
			
		case "mysql.db" : //드라이버 클래스 로드
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				//데이터베이스 연결

				con=DriverManager.getConnection("jdbc:mysql://localhost:3306"
							+ "/mysql?characterEncoding=UTF-8&serverTimezone=UTC","root","root1234");
					
				System.out.println(con);
				con.close();
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case "oracle.db" : 
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", 
						"user24", "user24");
				System.out.println(con);
				con.close();
			}catch(Exception e) {
				
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
