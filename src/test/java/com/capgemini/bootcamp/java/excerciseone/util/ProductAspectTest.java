package com.capgemini.bootcamp.java.excerciseone.util;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.logging.Level;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductAspectTest {

    private ProductAspect productAspect;

    @Mock
    private LogManager logManager;

    @Mock
    private JoinPoint joinPoint;

    @Mock
    private Authentication authentication;

    @Mock
    private SecurityContext securityContext;

    @BeforeEach
    void configuration(){

        productAspect = new ProductAspect(logManager);
    }

    @Test
    void getControllerFunction() {
        productAspect.getControllerFunction();
    }

    @Test
    void createControllerFunctions() {
        productAspect.createControllerFunctions();
    }

    @Test
    void getServiceFunction() {
        productAspect.getServiceFunction();
    }

    @Test
    void createServiceFunctions() {
        productAspect.createServiceFunctions();
    }

    @Test
    void getFunctions() {
        productAspect.getFunctions();
    }

    @Test
    void createFunctions() {
        productAspect.createFunctions();
    }

    @Test
    void beforeGet() {
        SecurityContextHolder.setContext(securityContext);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn("testUser");

        doNothing().
                when(logManager).createLog(any(Level.class), anyString(), anyString());

        productAspect.beforeGet(joinPoint);
        verify(logManager, new Times(1)).createLog(any(Level.class), anyString(), anyString());
    }

    @Test
    void beforeCreate() {
        SecurityContextHolder.setContext(securityContext);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn("testUser");

        doNothing().
                when(logManager).createLog(any(Level.class), anyString(), anyString());

        productAspect.beforeCreate(joinPoint);
        verify(logManager, new Times(1)).createLog(any(Level.class), anyString(), anyString());
    }
}