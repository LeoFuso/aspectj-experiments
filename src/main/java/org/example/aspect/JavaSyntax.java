package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class JavaSyntax {

    @After("execution(* org.example.model.Child.getName())")
    public void afterExecution(JoinPoint joinPoint) {
        System.out.println("after " + joinPoint);
    }

    @AfterReturning(value = "execution(* org.example.model.Child.getName())", returning = "result")
    public void afterReturning(JoinPoint ignored, String result) {
        System.out.println("Return value: " + result);
    }


    @Around("execution(* org.example.model.Parent.getName()) && !execution(* org.example.model.Child.getName())")
    public String aroundExecution(final ProceedingJoinPoint ignored) {
        return "Parent has no name";
    }

    @Around("execution(* org.apache.http.util.Args.notBlank(..))")
    public Object aroundExecutionExternalLibrary(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final Object[] args = proceedingJoinPoint.getArgs();
        final String subject = (String) args[0];
        if(subject != null && subject.isBlank()) {
            return "I was blank, but not anymore";
        }
        return proceedingJoinPoint.proceed(args);
    }

}
