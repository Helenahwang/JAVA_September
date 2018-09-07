package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.TMember;

public class UserDaoImpl implements UserDao {
	//데이터베이스 연결을 위한 변수
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	private UserDaoImpl() {
		
		/*
		//MySQL인 경우는 여기를 다르게 작성해야 한다. 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		*/
		
	}
	
	private static UserDao userDao;
	
	public static UserDao sharedInstance() {
		if(userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}

	//로그인 시에 오라클 데이터베이스에서 값을 불러오는 것 
	@Override
	public TMember login(TMember tmember) {
		
		//넘어온 파라미터를 출력
		System.out.println("넘어온 데이터:"+tmember);
		
		
		TMember user = null;
		
		try {
			
			//context.xml 파일의 내용을 읽어오기
			Context init = new InitialContext();
			
			//읽은  내용 중에서 DBConn 이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 생성한다. 
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			
			con = ds.getConnection();
			
			//데이터베이스 접속
			//con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user24", "user24");
			
			//Statement 인스턴스를 생성하고 SQL 실행
			pstmt = con.prepareStatement("select email, name from tmember" 
					+" where trim(email)=? and trim(pw)=?");
		
			//?에 값 채우기
			pstmt.setString(1, tmember.getEmail().trim());
			pstmt.setString(2, tmember.getPw().trim());
			
			//SQL 실행
			rs=pstmt.executeQuery();
			
			//결과를 읽기
			if(rs.next()) {
				//인스턴스를 생성하고 결과를 저장
				user = new TMember();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
		}
		
		
		//email 과 pw가 일치하는 데이터가 없으면 null이 리턴되고 
		//일치하는 데이터가 있으면 인스턴스를 생성해서 리턴 
		System.out.println("리턴하는 데이터: " +user);
		return user;
	}

	//회원가입 시에 오라클 데이터베이스에 값 저장 
	@Override
	public boolean registerMember(TMember tmember) {
		boolean result = false;
		try {
			
			
			//context.xml 파일의 내용을 읽어오기
			Context init = new InitialContext();
			
			//읽은  내용 중에서 DBConn 이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 생성한다. 
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			
			con = ds.getConnection();
			
			
			
			
			//con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user24", "user24");
			pstmt=con.prepareStatement("insert into tmember(email, pw, name, phone, addr) "
					+ "values(?,?,?,?,?)");
			
			pstmt.setString(1, tmember.getEmail().trim());
			pstmt.setString(2, tmember.getPw().trim());
			pstmt.setString(3, tmember.getName().trim());
			pstmt.setString(4, tmember.getPhone().trim());
			pstmt.setString(5, tmember.getAddr().trim());
			
			//sql 실행
			int r=pstmt.executeUpdate();
			
			if(r>0) {
				result=true;
			}
			
		
		}catch(Exception e) {
			//예외메시지 확인
			System.out.println(e.getMessage());
			//예외를 역추적
			e.printStackTrace();
			
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
			
		}
		
		
		return result;
	}

	@Override
	public boolean emailCheck(String email) {
		
		boolean result = false;
		
		try {
			
			//context.xml 파일의 내용을 읽어오기
			Context init = new InitialContext();
			
			//읽은  내용 중에서 DBConn 이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 생성한다. 
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			
			con = ds.getConnection();
			
			
			
			
			//데이터베이스 접속
			//con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user24", "user24");
			
			//Statement 인스턴스를 생성하고 SQL 실행
			pstmt = con.prepareStatement("select email from tmember where email=?");
		
			//?에 값 채우기
			pstmt.setString(1, email);

			
			//SQL 실행
			rs=pstmt.executeQuery();
			
			//결과를 읽기
			if(rs.next()) {
				//email 이 있으면 true 
				result = true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
		}
		
	
		return result;
	}

}
