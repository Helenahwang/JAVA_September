import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.dao.GoodDao;
import com.pk.domain.Good;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context =new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		GoodDao dao = context.getBean(GoodDao.class);
		
		
		//삽입
		/* 
		Good good=new Good();
		good.setCode(7);
		good.setName("감귤");
		good.setManufacture("제주도");
		good.setPrice(10000);
		
		dao.insertGood(good);
		*/
		
		//업데이트
		/*
		Good good=new Good();
		good.setCode(7);
		good.setName("무화과");
		good.setManufacture("목포");
		good.setPrice(3000);
		
		dao.updateGood(good);
		 */
		
		//삭제
		/*
		Good good=new Good();
		good.setCode(7);

		dao.deleteGood(good);	
		*/
		
		List<Good> list = dao.list();
		for(Good good : list) {
			System.out.println(good);
		}
		
		//데이터 1개 가져오기
		System.out.println("=================");
		System.out.println("code 11 데이터 : "+ dao.get(11));
		System.out.println("code 6 데이터 : "+ dao.get(6));
		
	

		context.close();
	
		

	}

}
