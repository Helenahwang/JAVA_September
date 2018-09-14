import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mybatis.dao.GoodDao;
import com.mybatis.domain.Good;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		GoodDao dao = context.getBean(GoodDao.class);
		
		
		List<Good> list2=dao.list();
		
		for(Good tmp: list2)
		System.out.println(tmp);
		
		
		context.close();

		

	}

}
