package edu.mum.cs544.bank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import edu.mum.cs544.bank.logging.ILogger;

@Aspect
@Component
public class AopMonitor {
	// final static Logger logger = LogManager.getLogger();
	@Autowired
	private ILogger logger;

	@Around("execution(* edu.mum.cs544.bank.dao.*.*(..))")
	public Object logBankDao(ProceedingJoinPoint jp) throws Throwable {
		logger.log("Enter " + jp.getSignature().getName());
		try {
			Object obj = jp.proceed();
			return obj;
		} finally {
			logger.log("Leave " + jp.getSignature().getName());
		}
	}

	@Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
	public Object watchService(ProceedingJoinPoint jp) throws Throwable {
		StopWatch sw = new StopWatch();
		String name = jp.getSignature().getName();
		Object target = jp.getTarget();
		sw.start();
		try {
			return jp.proceed();
		} finally {
			sw.stop();
			long totaltime = sw.getLastTaskTimeMillis();
			logger.log("Time to execute " + target.getClass().getName() + "." + name + " = " + totaltime + " ms");
		}
	}

	@AfterReturning("execution(* edu.mum.cs544.bank.jms.IJMSSender.sendJMSMessage(..))")
	public void logEveryJMS() {
		logger.log("Finished JMS sending.");
	}
	// d) Remove all the other logger calls from AccountService (doing so will make
	// it easier to
	// see whether your advice is running or not.
	// e) Be sure to inject the logger into the advice class as shown below

}
