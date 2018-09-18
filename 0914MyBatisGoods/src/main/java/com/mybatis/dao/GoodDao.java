package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.domain.Good;

//객체를 자동생성해주는 어노테이션
@Repository
public class GoodDao {
	
	//동일한 자료형의 bean이 있으면 자동으로 대입해주는 어노테이션
	@Autowired
	private SqlSession sqlSession;
	
	
	//테이블의 전체 데이터를 가져오는 메소드
	public List<Good> list(){
		return sqlSession.selectList("good.list1");
	}
	
	//테이블에 데이터를 삽입하는 메소드
	public int insertGood(Good good) {
		return sqlSession.insert("good.insertgood",good);
	}
	
}
