import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import vo.CollectionBean;
import vo.Sample;

public class Main {

	public static void main(String[] args) {
		//스프링 컨테이너 실행하기 - 컨테이너 안에 있는 bean의 객체가 전부 생성된다. 
		GenericXmlApplicationContext context=
				new GenericXmlApplicationContext("classpath:context.xml");
		
		//생성된 객체 가져오기
		//아이디만 대입한 경우는 Object로 리턴되므로 강제 형 변환해서 사용해야한다.
		//동일한 클래스로 만들어진 Bean이 1개이면 아이디를 생략하고 클래스이름만 대입해도 된다.
		Sample sample = context.getBean("sample1", Sample.class);//("sample", Sample.class);
		
		System.out.println(sample);
		
		
		
		//vo.CollectionBean
		//List
		CollectionBean collectionBean = context.getBean(CollectionBean.class);
		for(String tmp : collectionBean.getList()) {
			System.out.println(tmp);
		}
	
		//Set
		for(String tmp : collectionBean.getSet()) {
			System.out.println(tmp);
		}
		
		//Map
		Set<String> keySet = collectionBean.getMap().keySet();
		
		for(String tmp : keySet) {
			System.out.println(tmp + " : " + collectionBean.getMap().get(tmp)); //순서대로 출력되지 않는다.
			
		}
		
		
		
		context.close();
	}
}
