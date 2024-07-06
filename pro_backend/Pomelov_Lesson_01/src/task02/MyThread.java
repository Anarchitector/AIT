package task02;

public class MyThread extends Thread {

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1_000_000; i++) {
            Main.increment();
        }
    }
}