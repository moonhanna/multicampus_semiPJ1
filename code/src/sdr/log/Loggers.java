package sdr.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
@Service
@Aspect
public class Loggers {
	private Logger work_log = 
			Logger.getLogger("work"); 
	private Logger user_log = 
			Logger.getLogger("user"); 
	private Logger data_log = 
			Logger.getLogger("data"); 

	// before
	@Before("execution(* com.controller..*Controller.*(..))")
	public void logging(JoinPoint jp) {
		work_log.debug(jp.getSignature().getName());
		user_log.debug(jp.getSignature().getName());
		data_log.debug(jp.getSignature().getName());
	}
}





