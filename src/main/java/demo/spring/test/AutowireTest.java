package demo.spring.test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *  ①.@Autowired 注解实现注入,声明在属性上
 */
public class AutowireTest {
    private HelloWorld helloWorld1;

    public HelloWorld getHelloWorld1() {
        return helloWorld1;
    }

    public void setHelloWorld1(HelloWorld helloWorld1) {
        this.helloWorld1 = helloWorld1;
    }
}
