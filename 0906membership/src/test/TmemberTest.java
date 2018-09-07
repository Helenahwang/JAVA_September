package test;

import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.TMember;

public class TmemberTest {
	@Test
	public void sampleTest() {
		UserDao userDao = UserDaoImpl.sharedInstance();
		
		/*
		TMember member = new TMember();
		member.setEmail("ggangpae1@gmail.com");
		member.setPw("123");
		member.setName("깡패1");
		member.setPhone("01012345");
		member.setAddr("서울시 양천구");
		
		boolean r = userDao.registerMember(member);
		System.out.println(r);
		*/
		
		System.out.println(userDao.emailCheck("aaa@aaaa.com"));
		
	}

}
