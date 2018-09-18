import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.MyUserDao;
import com.pk.mybatis.domain.MyUserVO;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		MyUserDao dao = context.getBean(MyUserDao.class);
		
		List<MyUserVO> vo = dao.userlist();
		
		for(MyUserVO tmp : vo) {
			System.out.println(tmp);
		}
		
		
		MyUserVO vo1=dao.userone("irin");
		System.out.println(vo1);
		
		
		Scanner sc=new Scanner(System.in);
		//primary key를 입력받는 경우에는 반드시 중복체크를 해야 한다. 
		
		String id = null;
		
		while(true) {
			System.out.println("사용할 id를 입력하세요 : ");
			id = sc.nextLine();
			MyUserVO voo = dao.userone(id);
			if(voo == null) {
				break;
			}
			System.out.println(id+ "는 사용불가한 id입니다.");
		}
		
		
		System.out.println("비밀번호 입력 : ");
		String pw = sc.nextLine();
		
		System.out.println("이름 입력: ");
		String name = sc.nextLine();
		
		System.out.println("전화번호 입력: ");
		String phone = sc.nextLine();
		
		
		MyUserVO newVO = new MyUserVO();
		newVO.setId(id);
		newVO.setPw(pw);
		newVO.setName(name);
		newVO.setPhone(phone);
		
		//select 이외의 구문은 영향받은 행의 개수를 리턴
		//int result = dao.userinsert(newVO);
		
		
		//프로시저 사용한 insert 
		int result = dao.procedureinsert(newVO);
		
		
		System.out.println("삽입개수 : "+result);
		
		if(result>0) {
			System.out.println(id + "의 데이터가 삽입되었습니다.");
		}
		
		sc.close();
		
		
		
		context.close();

	}

}
