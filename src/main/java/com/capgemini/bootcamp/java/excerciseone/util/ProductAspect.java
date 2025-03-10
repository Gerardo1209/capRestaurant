package com.capgemini.bootcamp.java.excerciseone.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Aspect
@Component
public class ProductAspect {

    LogManager logManager;

    @Autowired
    public ProductAspect(LogManager logManager){
        this.logManager = logManager;
    }

    @Pointcut("execution(* com.capgemini.bootcamp.java.excerciseone.controller.*.get*(..))")
    public void getControllerFunction(){}

    @Pointcut("execution(* com.capgemini.bootcamp.java.excerciseone.controller.*.create(..))")
    public void createControllerFunctions() {}

    @Pointcut("execution(* com.capgemini.bootcamp.java.excerciseone.service.*.get*(..))")
    public void getServiceFunction(){}

    @Pointcut("execution(* com.capgemini.bootcamp.java.excerciseone.service.*.create(..))")
    public void createServiceFunctions() {}

    @Pointcut("getControllerFunction() || getServiceFunction()")
    public void getFunctions() {}

    @Pointcut("createControllerFunctions() || createServiceFunctions()")
    public void createFunctions() {}

    @Before("getFunctions()")
    public void beforeGet(JoinPoint joinPoint){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logManager.createLog(Level.INFO, "Execution -> " + joinPoint.getSignature(), authentication.getName());
    }

    @Before("createFunctions()")
    public void beforeCreate(JoinPoint joinPoint){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logManager.createLog(Level.INFO, "Execution -> " + joinPoint.getSignature(), authentication.getName());
    }

}