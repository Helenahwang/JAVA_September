package com.pk.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pk.domain.Good;

@Repository
public class GoodDao {
	//동일한 자료형의 bean이 있는 경우 자동으로 주입받는 설정
	
	@Autowired
	//hibernate를 사용하기 위한 인스턴스 변수
	private SessionFactory sessionFactory;
	
	
	//메소드에서 예외가 발생하면 rollback 되고 예외가 발생하지 않으면 commit 되도록 해주는 어노테이션
	@Transactional
	//데이터를 삽입하는 메소드
	public void insertGood(Good good) {
		sessionFactory.getCurrentSession().save(good);
	}

	
	@Transactional
	//데이터를 수정하는 메소드
	public void updateGood(Good good) {
		sessionFactory.getCurrentSession().update(good);
	}
	
	
	@Transactional
	//데이터를 삭제하는 메소드
	public void deleteGood(Good good) {
		sessionFactory.getCurrentSession().delete(good);
	}
	
	@Transactional
	//전체 데이터를 조회하는 메소드
	public List<Good> list(){
		return (List<Good>)sessionFactory.getCurrentSession().
				createCriteria(Good.class).list();
	}
	
	
	@Transactional
	//code를 가지고 데이터를 조회하는 메소드
	public Good get(int code) {
		return (Good)sessionFactory.getCurrentSession()
				.get(Good.class, code);
	}
	
	
}
