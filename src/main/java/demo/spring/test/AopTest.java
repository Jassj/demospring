package demo.spring.test;

public class AopTest {
    private int number;
    private String value;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        throw new IllegalArgumentException();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
