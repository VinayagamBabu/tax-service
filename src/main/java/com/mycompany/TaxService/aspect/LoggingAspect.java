package com.mycompany.TaxService.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	//@Pointcut("execution(* com.mycompany.TaxService.controller.*.*(..))")
	//@Pointcut("execution(AccessSpecifier RetrunType Package.Class.Method(args))")
	//@Pointcut("within(com.baeldung.pointcutadvice.dao.FooDao)") --  limits matching to join points of certain types
	//@Pointcut("@target(org.springframework.stereotype.Repository)") -- limits to class with Annotations (custom)
	//Pointcut expressions can be combined using &&, ||, and ! operators
	private void ControllerPointCut() {}
	
	 //@Before("ControllerPointCut()")
	 public void beforeAdvice(JoinPoint jp){
		 System.out.println("In Controller Method :"+ jp.getSignature());
	 }
	 
	 //@After("ControllerPointCut()")
	 public void afterAdvice(JoinPoint jp){
		 System.out.println("In Controller Method After Method:"+ jp.getSignature());
	 }
	 
	 //@AfterReturning(pointcut = "ControllerPointCut()", returning="retVal")
	 public void afterReturnAdvice(JoinPoint jp,Object retVal){
		 System.out.println("In Controller Method After Return:"+ jp.getSignature());
		 System.out.println("In Controller Method After Return value:"+ retVal);
	 }
	 
	 //@AfterThrowing(pointcut = "execution(* com.mycompany.TaxService.controller.*.*(..))",throwing = "error")
	 public void afterThrowingAdvice(JoinPoint jp, Throwable error){
	    System.out.println("Method Signature: "  + jp.getSignature());  
	    System.out.println("Exception: "+error);  
	 }
	 
	 //@Around(argNames = "pointcut", value = "execution(* com.mycompany.TaxService.service.*.*(..))")
	 public void aroundAdvice(ProceedingJoinPoint jp){
	    System.out.println("Around advice");
	    Object[] args = jp.getArgs();
	    if(args.length>0){
	       System.out.print("Arguments passed: " );
	       for (int i = 0; i < args.length; i++) {
	          System.out.print("arg "+(i+1)+": "+args[i]);
	       }
	    }
	    Object result = null;
		try {
			result = jp.proceed(args);
		} catch (Throwable e) {
			System.out.println("Exception " + e);
		}
		System.out.println("Returned " + result);
	 }

}
