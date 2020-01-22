package demo.spring.test;

public class HelloWorld {
    private String message;
    private String message1;
    private String message2;
    private String message3;

    public String getMessage() {
        System.out.println(this.message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage1() {
        System.out.println(this.message1);
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        System.out.println(this.message2);
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage3() {
        System.out.println(this.message3);
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    public void init() {
        System.out.println("=====init====="+message);
    }

    public void destroy() {
        System.out.println("=====destroy====="+message);
    }

    public HelloWorld() {
        System.out.println("HelloWorld Init Successfully!");
    }
}
