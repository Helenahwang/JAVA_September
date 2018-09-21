package com.pk.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	//id 중복체크하는 메소드
	public String idcheck(String id) {
		return sqlSession.selectOne("member.idcheck",id); //mybatis/mappers/member.xml 파일에서 
	}

}
