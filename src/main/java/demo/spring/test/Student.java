package demo.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * description: 使用注解完成依赖注入
 * ①.@Require: 用于setter方法,注解的方法一定要进行依赖注入,否则抛出异常(编译时校验)
 * ②.@Autowired: 默认情况下依赖是必须的,只能针对对象进行注入,无法对基础类型使用
 *      a.用于属性 Field Injection  不推荐
 *      b.setter方法 根据byType方式进行自动装配
 *      c.构造函数
 * ③.@Qualifier: 用于在相同类型bean中注入指定ID,配合@Autowired注解可精确定位bean,消除Spring容器自动注入的混乱情况
 * ④.@PostConstruct：初始化回调函数,等价于bean.xml中init-method方法
 * ⑤.@PreDestroy：bean销毁的回调函数,等价于bean.xml中destroy-method方法
 * ⑥.@Resource: @Resource(name= "xxx") 等价于@Autowired的byName形式
 * ⑦.@Configuration: 表名此类可以作为Spring IOC容器的bean定义来源 == bean.xml文件 @Bean: 标识此方法返回一个bean实例{@link demo.spring.config.BeanConfiguration}
 * @author yuanjie 2019/11/18 14:57
 */
public class Student {
    private String name;
    private int age;
    private HelloWorld helloWorld;

    /**
     * Field injection is not recommended, Always use constructor based dependency injection in your beans
     * 不推荐使用字段注入,推荐使用基于构造函数的依赖注入 @Todo 待扩充
     */
    @Autowired
    @Qualifier(value = "helloWorld1")
    private HelloWorld helloWorld1;

    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

/*
    @Required 用于setter方法,注解的方法一定要进行依赖注入,否则提示错误(编译时校验)
    public void setAge(int age) {
        this.age = age;
    }
*/

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    @Autowired(required = false) // required false: 表明注入的依赖不是必须的
    public void setHelloWorld(HelloWorld helloWorld) {
        System.out.println("Init HelloWorld: "+helloWorld.getMessage());
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld1() {
        return helloWorld1;
    }

    @PostConstruct
    public void init(){
        System.out.println("Bean is going through init.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean will destroy now.");
    }
}
