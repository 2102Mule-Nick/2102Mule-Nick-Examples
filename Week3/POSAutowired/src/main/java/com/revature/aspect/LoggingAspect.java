package com.revature.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.pojo.User;

@Component
@Aspect
public class LoggingAspect {
	
	private Logger log;
	
	public Logger getLog() {
		return log;
	}

	@Autowired
	public void setLog(Logger log) {
		this.log = log;
	}

	@Pointcut("execution(public * com.revature.service.AuthServiceImpl.*(..))")
	public void pointcutForAllMethods() {
		//Hook - empty method to hold an annotation
	}
	
	/*
	 * @Before("execution(* com.revature.service.AuthServiceImpl.authenticateUser(..))"
	 * ) public void logBeforeAuthServiceMethods(JoinPoint jp) { String methodName =
	 * jp.getSignature().getName(); log.trace("Just called AuthService " +
	 * methodName + " Method"); }
	 */
	
	@Around("pointcutForAllMethods()")
	public Object loggingAllAdvice(ProceedingJoinPoint pjp) throws Throwable {
		
		log.trace("Method called: "+ pjp.getSignature().getClass() + "." + pjp.getSignature().getName());
		
		log.trace("Real class: " + pjp.getTarget().getClass());
		
		log.info("Parameters passed: " + Arrays.toString(pjp.getArgs()));
		
		Object returnObject = pjp.proceed();

		log.trace("Value returned: " + returnObject);
		
		if (returnObject instanceof User) {
			User returnUser = (User)returnObject;
			returnUser.setPassword("*********");
			log.info("User password being hidden.");
			return returnUser;
		}
		
		return returnObject;
		
	}

	
	
}
