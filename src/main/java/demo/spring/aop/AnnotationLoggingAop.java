package demo.spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AnnotationLoggingAop {

    /**
     * ①.切入点表达式表示了哪些方法会执行相关建议
     * ②.切入点标签包含名称,方法体内容应该为空
     * before a selected method execution.
     */
    @Pointcut("execution(* demo.spring.test.AopTest.*(..))")
    public void tempPointCut() {

    }

    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("tempPointCut()")
    public void beforeAdvice(){
        System.out.println("AnnotationLoggingAop--> Method will be called.");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    @After("tempPointCut()")
    public void afterAdvice(){
        System.out.println("AnnotationLoggingAop--> Method has been called.");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    @AfterReturning(pointcut = "execution(* demo.spring.test.AopTest.getValue(..))", returning = "retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("AnnotationLoggingAop--> Returning:" + retVal.toString() );
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised.
     */
    @AfterThrowing(pointcut = "tempPointCut()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("AnnotationLoggingAop--> There has been an exception: " + ex.toString());
    }
}
