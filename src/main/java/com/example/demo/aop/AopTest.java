package com.example.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
//切面类
public class AopTest {

    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public void point(){

    }

    /**
     * 方法之前执行
     * @param joinPoint
     * @throws Throwable
     */
    @Before("point()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("方法前置执行 1");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

    /**
     * 方法执行：当某连接点退出时执行的通知（不论是正常返回还是异常退出）。
     * @param joinPoint
     */
    @After(value ="point()")
    public void doAfterAdvice(JoinPoint joinPoint){
        System.out.println("最终执行完成");
    }


    @AfterReturning(returning = "ret",pointcut = "point()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        //ret为方法返回值
        System.out.println("执行完结束返回值为"+ret);
    }



}
