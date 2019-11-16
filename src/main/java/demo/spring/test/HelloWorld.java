package demo.spring.test;

public class HelloWorld {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }

    public void init() {
        System.out.println("=====init====="+message);
    }

    public void destroy() {
        System.out.println("=====destroy====="+message);
    }
}
