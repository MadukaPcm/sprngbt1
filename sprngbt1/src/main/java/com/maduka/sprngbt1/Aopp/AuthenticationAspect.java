package com.maduka.sprngbt1.Aopp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

//    @Pointcut("within(sprngbt1..*)");
    public void authenticationPointCut(){

    }

//    @Pointcut("within(sprngbt1.className.*)");
    public void authorizationPointCut(){

    }

//    @Before("authenticationPointCut() && authorizationPointCut()");
    public void authenticate(){
        System.out.println("Authenticating the request...");
    }

}
