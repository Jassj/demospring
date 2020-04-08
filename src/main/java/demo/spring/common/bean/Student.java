package demo.spring.common.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 学生实体类
 * @author yuanjie 2019/11/18 14:57
 */
public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

//    @Required 用于setter方法, 注解的方法一定要进行依赖注入,否则提示错误(编译时校验)
    public void setAge(int age) {
       this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
