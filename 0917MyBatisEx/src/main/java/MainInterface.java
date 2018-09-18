import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.MyUserInterface;
import com.pk.mybatis.domain.MyUserVO;

public class MainInterface {
	public static void main(String[] args) {
		GenericXmlApplicationContext context= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
		//매퍼 인터페이스를 구현한 객체 찾아오기
		MyUserInterface myUserInterface = context.getBean(MyUserInterface.class);
		
		List<MyUserVO> list = myUserInterface.listuser();
		for(MyUserVO vo : list) {
			System.out.println(vo);
		}
		
		
		MyUserVO vo = myUserInterface.selectuser("jenny");
		System.out.println(vo);
		
		context.close();
	}

}
