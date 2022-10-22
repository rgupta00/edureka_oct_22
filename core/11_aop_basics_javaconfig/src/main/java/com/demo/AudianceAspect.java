package com.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudianceAspect {
	
	@Around("execution(public void doMagic())")
	public void timeTaken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start= System.currentTimeMillis();
		
		proceedingJoinPoint.proceed();
		
		
		long end=System.currentTimeMillis();
		
		System.out.println("time taken : "+": method name: "+ proceedingJoinPoint.getSignature().getName()  +" : " +(end-start )+" ms");
	}
	

	//@After("execution(public void doMagic())")
	@AfterReturning("execution(public void doMagic())")
	//@Before("execution(public void doMagic())")
	public void clappingAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("wow maza aa gaya...");
	}
	
	@AfterThrowing(pointcut = "execution(public void doMagic())", throwing = "exception")
	public void callTheDr(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
