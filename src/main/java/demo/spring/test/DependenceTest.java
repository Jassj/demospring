package demo.spring.test;

import java.util.List;

/**
 * description: 依赖注入测试bean
 * @author yuanjie 2019/11/17 21:10
 */
public class DependenceTest {
    private HelloWorld helloWorld;
    private List studentList;

    public DependenceTest(HelloWorld helloWorld) {
        System.out.println("DependenceTest Init Successfully!");
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        System.out.println("Set HelloWorld In DependenceTest Successfully!");
        this.helloWorld = helloWorld;
    }

    public List getStudentList() {
        System.out.println("StudentList:"+ studentList);
        return studentList;
    }

    public void setStudentList(List studentList) {
        this.studentList = studentList;
    }
}
