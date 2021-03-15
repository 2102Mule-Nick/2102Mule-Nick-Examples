package com.revature.aspect;

import org.springframework.stereotype.Component;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Component
@Aspect
public class LoggingAspect {
	
	@Before("execution(* com.revature.service.AuthServiceImpl.authenticateUser(..))")
	public void logBeforeAuthServiceMethods(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Logger log = Logger.getRootLogger();
		log.trace("Just called AuthService " + methodName + " Method");
	}
	
	@AfterReturning(value = "execution(* com.revature.service.AuthServiceImpl.*(..))", returning = "returnValue")
	public void logBeforeAuthServiceMethods(JoinPoint jp, Object returnValue) {
		String methodName = jp.getSignature().getName();
		Object[] methodParameter = jp.getArgs();
		String methodReturn = returnValue.toString();
		Logger log = Logger.getRootLogger();
		log.trace("Just called AuthService " + methodName + " Method");
		for (Object obj : methodParameter) {
			log.trace("Method Parameter " + obj);
		}
		
		log.trace("Method Return Value: " + methodReturn);
	}

}
