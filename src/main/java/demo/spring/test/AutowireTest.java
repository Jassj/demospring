package demo.spring.test;

public class AutowireTest {
    private HelloWorld helloWorld1;

    public HelloWorld getHelloWorld1() {
        return helloWorld1;
    }

    public void setHelloWorld1(HelloWorld helloWorld1) {
        this.helloWorld1 = helloWorld1;
    }
}
