package demo.service;


public class Test {
    private static int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Test() {
        super();
    }

    public int test1() {
        count = count+1;
        return count;
    }
}
