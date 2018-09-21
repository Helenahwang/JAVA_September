package com.pk.aop.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*//XML기반의 AOP
@Component
public class LoginAdvice {
	
	//aop 동작할 메소드 - 예외가 발생하면 호출한 곳에서 처리하도록 설계 
	public Object invoke (ProceedingJoinPoint joinPoint)throws Throwable{
		
		
		System.out.println("메소드가 호출되기 전 수행한다.");
		
		
		//원본 메소드 호출
		Object obj = joinPoint.proceed();
	
		
		System.out.println("메소드가 작업을 후 수행한다.");
		
		return obj;
	}
	
	
}
*/

//bean을 자동으로 만들어주는 어노테이션
@Component
@Aspect
public class LoginAdvice {
	
	//aop 동작할 메소드 - 예외가 발생하면 호출한 곳에서 처리하도록 설계 
	@Around("execution(* com.pk.aop.HomeController*.*(..))")
	public Object invoke (ProceedingJoinPoint joinPoint)throws Throwable{
		
		
		System.out.println("메소드가 호출되기 전 수행한다.");
		
		
		//원본 메소드 호출
		Object obj = joinPoint.proceed();
	
		
		System.out.println("메소드가 작업을 후 수행한다.");
		
		return obj;
	}
	
	
}