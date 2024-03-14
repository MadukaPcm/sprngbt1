package com.maduka.sprngbt1.Aopp;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    @Before("execution(* sprngbt1.className.methodName(..)");
    public void beforeLogger(){
        System.out.println("Before Logger !!");
    }

//    @After("execution(* *.*.checkout(..)");
    public void affterLogger(){
        System.out.println("After Logger !!");
    }
}
