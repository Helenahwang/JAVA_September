package listener;

import javax.servlet.http.HttpSessionEvent;

public class HttpSessionListener implements javax.servlet.http.HttpSessionListener {

	static int cnt;
	//세션이 생성될 때 호출되는 메소드 - 새로운 사용자가 접속
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		cnt=cnt+1;
		System.out.println("새로운 사용자 "+cnt +"명이 접속하였습니다.");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		cnt=cnt-1;
		System.out.println("새로운 사용자가 "+cnt+ "명이 접속을 해지하였습니다.");

	}

}
