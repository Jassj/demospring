package demo.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // bean执行顺序的优先级, 值越小优先级越高
public class CommonAspect {

    @Before("demo.spring.common.aop.PointCut.log()")
    public void doLogBefore(JoinPoint joinPoint){
        System.out.println("开始执行"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()
        + "方法 接收参数↓↓↓\n" +  joinPoint.getArgs());
    }

    @AfterReturning(value = "demo.spring.common.aop.PointCut.log()", returning = "result")
    public void doLogAfter(JoinPoint joinPoint, Object result) {
        System.out.println("方法"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()
                + "执行完毕 返回值↓↓↓\n" +  result);
    }

    @AfterThrowing(value = "demo.spring.common.aop.PointCut.log()", throwing = "e")
    public void afterThrowing(Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e.getMessage(), e);
    }
}
