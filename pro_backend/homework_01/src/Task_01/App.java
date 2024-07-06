package Task_01;

public class App {

    private static int counter;

    public static synchronized void incCounter(){
        counter++;
    };

    public static int getCounter(){
        return counter;
    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter = " + getCounter());

    }
}
