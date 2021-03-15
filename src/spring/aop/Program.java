package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;
import spring.di.NewlecDIConfig;

public class Program {

	public static void main(String[] args) {

		ApplicationContext context = 
//				new AnnotationConfigApplicationContext(NewlecDIConfig.class);  // annotation ��� ȣ��
				new ClassPathXmlApplicationContext("spring/aop/setting.xml"); // xml��� ȣ��

		Exam exam = (Exam) context.getBean("exam");

		System.out.printf("total is %d", exam.total());
		System.out.printf("avg is %f", exam.avg());
		/*
		Exam exam = new NewlecExam(1,1,1,1);
		Exam proxy = (Exam) Proxy.newProxyInstance( NewlecExam.class.getClassLoader() , 
				new Class[] {Exam.class}, 
				new InvocationHandler() {
			
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						//AOP�� ���� ����ϰ��� �ϴ� ������ �����Ѵ�.
						long startTime = System.currentTimeMillis();
						
						Object result = method.invoke(exam, args);
						
						long endTime = System.currentTimeMillis();
						
						String message = (endTime - startTime) +" ms �ð��� �ɷȽ��ϴ�."; 
						System.out.println(message);
						
						return result;
					}
				}) ;
			*/	
		
	}

}
