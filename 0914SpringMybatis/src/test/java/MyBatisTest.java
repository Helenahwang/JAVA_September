import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//JUit4를 이용해서 테스트를 수행한다는 설정
@RunWith(SpringJUnit4ClassRunner.class)

//설정 파일을 실행해서 사용한다는 설정
@ContextConfiguration(
	locations ={"classpath:applicationContext.xml"})


public class MyBatisTest {
	
	//동일한 자료형의 bean이 있으면 자동으로 주입하라는 어노테이션
	//Inject 대신에 Autowired 사용 가능
	//@Inject
	//private DataSource ds;
	
	@Autowired
	private DataSource ds;
	
	
	//테스트를 위한 어노테이션
	@Test
	public void testConnection() {
		try(Connection con=ds.getConnection()) {
			System.out.println(con);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Autowired
	private SqlSessionFactoryBean factoryBean;
	
	@Test
	public void print() {
		System.out.println("factoryBean:"+factoryBean);
	}
	
	
	
	
	
	
	
	
	

}
