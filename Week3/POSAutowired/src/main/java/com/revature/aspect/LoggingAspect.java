package com.revature.aspect;

import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
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

}
