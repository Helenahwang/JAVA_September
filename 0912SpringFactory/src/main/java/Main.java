import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import dao.GoodDao;
import vo.Good;

public class Main {
	
	public static void main(String[] args) {
		//GoodDao 인스턴스 생성
		//GoodDao gd = new GoodDao(); //이제는 객체 생성을 못하도록 한다=> 실수방지 => 팩토리 메소드 패턴
		
		
		//GoodDao gd = GoodDaoFactory.create(); //GoodDaoFactory 클래스의 create( )를 이용
		
		/*
		//스프링을 이용해서 객체를 생성 - 싱글톤 패턴이 자동으로 적용
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(GoodDaoFactory.class);
		
		GoodDao gd = context.getBean("create", GoodDao.class);
		*/
		
		//XML 이용시
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodDao gd = context.getBean("goodDao", GoodDao.class);
		
		
		System.out.println(gd.hashCode());
		
		//필요한 메소드 호출
		List<Good> list1 = gd.getGood();
		
		//메소드 호출 결과 출력
		for(Good gg : list1) {
			System.out.println(gg);
		}
		
		gd = context.getBean("goodDao", GoodDao.class);
		System.out.println(gd.hashCode());
		
	}

}
