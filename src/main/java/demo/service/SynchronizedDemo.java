package demo.service;

public class SynchronizedDemo implements Runnable {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
//            System.out.println(thread.getName());
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        Test test = new Test();
//        synchronized (SynchronizedDemo.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+test.test1());
            }
//        }
    }
}
