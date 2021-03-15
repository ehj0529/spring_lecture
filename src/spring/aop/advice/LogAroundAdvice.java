package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		long startTime = System.currentTimeMillis();
		
		Object result = invocation.proceed();
		
		long endTime = System.currentTimeMillis();
		
		String message = (endTime - startTime) +" ms 시간이 걸렸습니다. Around Cut"; 
		System.out.println(message);		
		
		
		return result;
	}

}
