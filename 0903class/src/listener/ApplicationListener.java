package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

	
	
	//웹 어플리케이션이 종료될 때 호출되는 메소드
	//사용한 외부 자원에 대한 연결 해제 작업을 주로 작성한다.
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션을 종료합니다.");
	}

	
	//웹 어플리케이션이 시작될 때 호출되는 메소
	//서버에서 필요한 자원을 생성하는 작업을 주로 한다.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션을 시작합니다."); //console 창에 나타난다. 
	}

}
