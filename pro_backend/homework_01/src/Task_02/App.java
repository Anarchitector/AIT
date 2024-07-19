package Task_02;

public class App {

     public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter = " + Numbers.getCounter());

    }
}
