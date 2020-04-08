package demo.spring.test;

import demo.spring.common.bean.Student;
import demo.spring.common.config.BeanConfiguration;
import demo.spring.common.bean.Employee;
import demo.spring.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 *
 * description: IOC(控制反转)容器：创建对象,并管理对象的创建与销毁,使用DI(依赖注入)完成
 * ①.BeanFactory：bean工厂容器{@link org.springframework.beans.factory.BeanFactory }
 * ②.ApplicationContext：Spring上下文容器,是BeanFactory的子接口{@link org.springframework.context.ApplicationContext}
 * ③.三种容器读取xml文件创建bean的方式{@link org.springframework.context.support}
 * FileSystemXmlApplicationContext：通过系统文件全路径
 * ClassPathXmlApplicationContext：通过CLASSPATH的相对路径
 * WebXmlApplicationContext
 * 注：也可以通过注解(常用)和Java配置来提供bean配置信息给IOC容器
 * @author yuanjie 2019/11/15 18:03
 */
public class MainApp {
//    private final static ApplicationContext applicationContext = new FileSystemXmlApplicationContext("F:\\IdeaWorkspace\\springdemo\\src\\main\\webapp\\WEB-INF\\config\\Beans.xml");
    private final static ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\IdeaWorkspace\\demospring\\src\\main\\webapp\\WEB-INF\\config\\Beans.xml");

    /**
     * prototype: 作用域
     * a.singleton(默认): 单例模式,每次返回的bean实例相同,相同与全局对象(容器创建时,bean就被创建并加入容器中)
     * 多线程访问单例对象的安全性：Spring框架并没有对单例bean进行任何多线程的封装处理
     * 无状态bean：每个用户访问时bean的状态都一致，类似Controller、Service、Dao，仅关注Bean的方法，而不存在对实例变量修改，导致bean状态的变化。
     * 有状态bean：可以理解为有实例变量的bean，相关操作有导致数据的变化，不同用户访问时会存在资源竞争问题，因此是不安全的。
     * b.prototype: 每次返回一个新的bean实例,相当于每次new一个对象(从容器中获取bean时才会创建这个bean的实例)
     */
    public static void prototypeTest() {
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.getMessage();
        helloWorld.setMessage("singleton");
        HelloWorld helloWorld_singleton = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld_singleton.getMessage();

        HelloWorld helloWorld1 = (HelloWorld) applicationContext.getBean("helloWorld1");
        helloWorld1.getMessage();
        helloWorld1.setMessage("prototype");
        HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloWorld1");
        helloWorld2.getMessage();
    }

    /**
     * life cycle: 生命周期
     * a.init-method: bean初始化时被调用(singleton单例：容器创建时初始化bean,方法仅被调用一次;prototype默认getBean时初始化bean,每次都调用初始化方法)
     * b.destroy-method: bean销毁时被调用,调用bean.destroy()方法销毁bean
     */
    public static void lifeCycle() {
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.destroy();

        HelloWorld helloWorld1 = (HelloWorld) applicationContext.getBean("helloWorld1");
        helloWorld1.destroy();
    }

    // 虚拟bean，用作模板
    public static void abstractBean() {
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.getMessage();
        helloWorld.getMessage1();
        helloWorld.getMessage2();
        helloWorld.getMessage3();
    }

    // 依赖注入
    public static void dependenceInjectionTest() {
        DependenceTest dependenceTest = (DependenceTest) applicationContext.getBean("dependenceTest");
        dependenceTest.getStudentList();
    }

    // 自动装配
    public static void autowireTest() {
        AutowireTest autowireTest = (AutowireTest) applicationContext.getBean("autowireTest");
    }

    // spring注解
    public static void annotationTest() {
        Student student = (Student) applicationContext.getBean("student");
    }

    // 基于Java的bean容器配置
    public static void configurationAnnotation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Employee employee = applicationContext.getBean(Employee.class);
        employee.getEmployeeName();
        employee.destroy();
    }

    // 切面
    public static void aopTest() {
        try {
            AopTest aopTest = (AopTest) applicationContext.getBean("aopTest");
            System.out.println("Number:"+aopTest.getNumber());
            aopTest.setNumber(12345);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    // Spring Jdbc
    public static void springJdbcTest() {
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        int count = studentService.queryStudentCount();
        String name = (String) studentService.queryColumnById("name", 1);
        int age = (int) studentService.queryColumnById("age", 1);
        System.out.println("当前学生的数量是：" + count);
        System.out.println("ID为1学生的姓名是：" + name + ", 年龄是：" + age);

        // 查询并返回一个对象
        Student student = studentService.queryStudentById(2);
        System.out.println("当前学生的ID为" + student.getId() + ", 姓名是：" + student.getName() + ", 年龄是：" + student.getAge());

        // 查询并返回多个对象
        List<Student> studentList = studentService.queryStudentByAge(23);
        for(Student student1 : studentList) {
            System.out.println("年龄23的学生ID为" + student1.getId() + ", 姓名是：" + student1.getName());
        }

        // 新增对象
        studentService.createStudent(new Student("lisa", 21));
    }

    public static void main(String[] args) {
//        prototypeTest();
//        lifeCycle();
//        abstractBean();
//        dependenceInjectionTest();
//        autowireTest();
//        annotationTest();
//        configurationAnnotation();
//        aopTest();
        springJdbcTest();
    }

}