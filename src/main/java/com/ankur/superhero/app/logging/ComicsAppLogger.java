package com.ankur.superhero.app.logging;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.ankur.superhero.businesslogic.exception.RequestNotFoundException;

@Aspect
@Component
public class ComicsAppLogger {

    private final Logger logger = Logger.getLogger(ComicsAppLogger.class.getName());

    @Pointcut("execution (* com.ankur.superhero.businesslogic.service.*.*(..))")
    public void servicePackage() {
    }

    @Pointcut("execution (* com.ankur.superhero.dataaccess.repository.*.*(..))")
    public void repositoryPackage() {
    }

    @Before("servicePackage() || repositoryPackage()")
    public void beforeMethod(JoinPoint joinPoint) {

	MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	String args = "";
	for (Object arg : joinPoint.getArgs()) {
	    args = ", " + arg.toString();
	}
	logger.info("LOG: Entering Method [" + signature + args + "]");
    }

    @AfterReturning(pointcut = "servicePackage() || repositoryPackage()", returning = "returnValue")
    public void afterReturningMethod(JoinPoint joinPoint, Object returnValue) {

	MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	if (returnValue instanceof List<?>) {
	    logger.info("LOG: Exiting Method [" + signature + "]");
	} else {
	    logger.info("LOG: Exiting Method [" + signature + ", " + returnValue + "]");
	}
    }

    @AfterThrowing(pointcut = "servicePackage() || repositoryPackage()", throwing = "thrownException")
    public void afterException(JoinPoint joinPoint, Throwable thrownException) throws Throwable {

	MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	if (thrownException instanceof RequestNotFoundException) {
	    logger.info("LOG: Exception on Method [" + signature + ", RequestNotFoundException: Character not found]");
	} else {
	    logger.info("LOG: Exception on Method [" + signature + ", " + thrownException + "]");
	    throw thrownException;
	}
    }
}
