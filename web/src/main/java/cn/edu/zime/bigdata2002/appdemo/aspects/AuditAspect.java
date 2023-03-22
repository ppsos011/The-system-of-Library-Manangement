package cn.edu.zime.bigdata2002.appdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
    @Pointcut("execution(* cn.edu.zime.bigdata2002.appdemo.service.*.*(..))")
    public void example(){}

    @Before("example()")
    public void beforeAspect(JoinPoint joinPoint){
        System.out.println("--------start --------"+joinPoint);
    }

    @AfterReturning(value="example()", returning="result")
    public void returning(JoinPoint joinPoint, Object result){
        System.out.println(joinPoint+" return------"+result);
    }


















/*



    @Pointcut("execution(* cn.edu.zime.bigdata2002.appdemo.service.*.*(..))")
    public void check(){}
    @Before("check()")
    public void before(JoinPoint joinpoint){
        System.out.println("------starting:："+joinpoint);
    }
    @After("check()")
    public void after(JoinPoint joinPoint){
        System.out.println(joinPoint+" completed");
    }
    @AfterReturning(value = "check()", returning = "result")
    public void afterReturning(JoinPoint joinpoint, Object result){
        System.out.println(joinpoint+"'s return result is:"+result);
    }
    @AfterThrowing(value = "check()", throwing = "e")
    public void afterThrowing(JoinPoint joinpoint, Exception e){
        System.out.println(joinpoint+"'s exception is :"+e.getMessage());
    }
    *
 */
}
