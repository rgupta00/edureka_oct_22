package com.bankapp.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(public void transfer(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		long start= System.currentTimeMillis();
		Object value= joinPoint.proceed();
		String methodName= joinPoint.getSignature().getName();
		long end=System.currentTimeMillis();
		logger.info("time taken by "+methodName +" method is : "+ (end-start)+" ms");
		return value;
	}

}
