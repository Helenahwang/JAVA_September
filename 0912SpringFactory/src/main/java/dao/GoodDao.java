package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Good;

public class GoodDao {
	
	public GoodDao(){}
	
	//전체 데이터를 읽어오는 메소드
	//파라미터를 만들 때는 insert 나 update는 VO
	//delete는 primary key
	//select는 where 절에 대입되어야 하는 데이터가 파라미터
	//전체데이터를 불러오는 것은 (select * from goods)은 where 절이므로 매개변수가 없다.
	public List<Good> getGood(){
		//List를 리턴할 때는 객체를 생성하고 리턴하도록 작성
		List<Good> lst = new ArrayList<Good>();
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		
		try {
			//오라클 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//오라클 서버 주소
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user24", "user24");
			
			//sql 
			pstmt = con.prepareStatement("select * from goods");
			
			//실행
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Good gd = new Good();
				gd.setCode(rs.getInt("code"));
				gd.setName(rs.getString("name"));
				gd.setPrice(rs.getInt("price"));
				gd.setDescription(rs.getString("description"));
				lst.add(gd);
			}
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
			}catch(Exception e){}
			
		}
		
		return lst;
	}

}
