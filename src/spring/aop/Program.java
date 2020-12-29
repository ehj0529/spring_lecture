package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {

		Exam exam = new NewlecExam(1,1,1,1);

		Exam proxy = (Exam) Proxy.newProxyInstance( NewlecExam.class.getClassLoader() , 
				new Class[] {Exam.class}, 
				new InvocationHandler() {
			
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						//AOP를 통해 사용하고자 하는 로직을 생성한다.
						long startTime = System.currentTimeMillis();
						
						Object result = method.invoke(exam, args);
						
						long endTime = System.currentTimeMillis();
						
						String message = (endTime - startTime) +" ms 시간이 걸렸습니다."; 
						System.out.println(message);
						
						return result;
					}
				}) ;
				
		System.out.printf("total is %d", proxy.total());
	}

}
