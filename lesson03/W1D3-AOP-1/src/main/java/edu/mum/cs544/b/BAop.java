package edu.mum.cs544.b;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class BAop {

	@AfterReturning("execution(* edu.mum.cs544.IEmailSender.sendEmail(..)) && args(address,message)")
	public void log(JoinPoint jp, String address, String message) {
		System.out.println(LocalDateTime.now() + " method= " + jp.getSignature().getName() + " address=" + address
				+ " message=" + message);
	}

}
