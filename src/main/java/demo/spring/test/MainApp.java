package demo.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @description IOC(控制反转)容器：创建对象，并管理对象的创建与销毁，使用DI(依赖注入)完成
 * ①.BeanFactory：bean工厂容器{@link org.springframework.beans.factory.BeanFactory }
 * ②.ApplicationContext：Spring上下文容器,是BeanFactory的子接口{@link org.springframework.context.ApplicationContext}
 * ③.三种容器读取xml文件创建bean的方式{@link org.springframework.context.support}
 * FileSystemXmlApplicationContext：通过系统文件全路径
 * ClassPathXmlApplicationContext：通过CLASSPATH的相对路径
 * WebXmlApplicationContext
 * 注：也可以通过注解(常用)和Java配置来提供bean配置信息给IOC容器
 * @author yuanjie
 * @date   2019/11/15 18:03
 */
public class MainApp {

    /**
     * prototype: 作用域
     * a.singleton(默认): 单例模式,每次返回的bean实例相同,相同与全局对象(容器创建时bean已存在)
     * b.prototype: 每次返回一个新的bean实例,相当于每次new一个对象(获取bean时才会创建这个实例)
     */
    public static void prototypeTest() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\IdeaWorkspace\\demospring\\src\\main\\webapp\\WEB-INF\\config\\Beans.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.printMessage();
        helloWorld.setMessage("singleton");
        HelloWorld helloWorld_singleton = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld_singleton.printMessage();

        HelloWorld helloWorld1 = (HelloWorld) applicationContext.getBean("helloWorld1");
        helloWorld1.printMessage();
        helloWorld1.setMessage("prototype");
        HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloWorld1");
        helloWorld2.printMessage();
    }

    /**
     * life cycle: 生命周期
     * a.init(默认):
     * b.destroy: 每次返回一个新的bean实例,相当于每次new一个对象(获取bean时才会创建这个实例)
     */
    public static void lifeCycle() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\IdeaWorkspace\\demospring\\src\\main\\webapp\\WEB-INF\\config\\Beans.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.destroy();

        HelloWorld helloWorld1 = (HelloWorld) applicationContext.getBean("helloWorld1");
        helloWorld1.destroy();
    }


    public static void main(String[] args) {
//        prototypeTest();
        lifeCycle();
    }
}
