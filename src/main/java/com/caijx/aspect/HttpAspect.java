package com.caijx.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/27/027.
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.caijx.controller.GirlController.*(..))")
    public  void log(){

    }

    @Before("log()")
    public void doBefor(JoinPoint joinpoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        LOGGER.info("url={}",request.getRequestURL());

        //method
        LOGGER.info("method={}",request.getMethod());

        //ip
        LOGGER.info("ip={}",request.getRemoteAddr());

        //类方法
        LOGGER.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName() + "." +
        joinpoint.getSignature().getName());

        //参数
        LOGGER.info("args={}",joinpoint.getArgs());

    }

    @After("log()")
    public  void doAfter(){
        LOGGER.info("2222222222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        LOGGER.info("response={}",object.toString());
    }
}
