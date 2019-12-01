package demo.spring.test;

import java.util.List;

/**
 * @author yuanjie
 * @description 依赖注入测试bean
 * @date 2019/11/17 21:10
 */
public class DependenceTestBean {
    private HelloWorld helloWorld;
    private List studentList;

    public DependenceTestBean(HelloWorld helloWorld) {
        System.out.println("DependenceTestBean Init Successfully!");
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        System.out.println("Set HelloWorld In DependenceTestBean Successfully!");
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
