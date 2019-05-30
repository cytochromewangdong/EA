package edu.mum.cs544.a;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class AAop {

	@AfterReturning("execution(* edu.mum.cs544.IEmailSender.sendEmail(..))")
	public void log(JoinPoint jp) {
		System.out.println(LocalDateTime.now() + " method= " + jp.getSignature().getName());
	}
	
}
