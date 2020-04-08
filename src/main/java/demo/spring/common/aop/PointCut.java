package demo.spring.common.aop;

import org.aspectj.lang.annotation.Pointcut;

// 1.切入点表达式表示了哪些方法会执行相关建议
// 2.切入点标签包含名称,方法体内容应该为空
public class PointCut {

    // 日志切入点
    @Pointcut("execution(public * demo.spring.controller.*.*(..))")
    public void log() {

    }

    // 参数校验切入点
    @Pointcut("execution(public * demo.spring.controller..*.*(..))")
    public void valid() {

    }
}
