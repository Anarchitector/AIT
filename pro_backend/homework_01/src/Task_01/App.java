package Task_01;

public class App {

     public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter = " + Numbers.getCounter());

    }
}
