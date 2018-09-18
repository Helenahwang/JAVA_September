package com.pk.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.mybatis.domain.MyUserVO;

//자동으로 bean을 생성해주는 어노테이션
@Repository
public class MyUserDao {
	//동일한 자료형의 bean이 있으면 자동으로 주입받는 어노테이션
	//@Autowired
	private SqlSession sqlSession;
	
	
	//MyUser 테이블의 전체 데이터를 가져오는 메소드
	public List<MyUserVO> userlist(){
		return sqlSession.selectList("myuser.selectall");
	}
	
	//MyUser 테이블에서 ID를 가지고 하나의 데이터를 찾아오는 메소드
	public MyUserVO userone(String idd){
		//하나를 찾아오는 메소드 호출, 없으면 null을 리턴, 2개 이상이면 예외를 발생시킨다. 
		return sqlSession.selectOne("myuser.selectid", idd);
	}
	
	//MyUser 테이블에 데이터를 삽입하는 메소드, 메소드 타입은 항상 int 이다.
	public int userinsert(MyUserVO vo) {
		return sqlSession.insert("myuser.insertdata", vo);
		
	}
	
	//MyUser 테이블에 데이터를 삽입하는 메소드
	public int procedureinsert(MyUserVO vo) {
		return sqlSession.insert("myuser.proinsert", vo);
	}
	
}
