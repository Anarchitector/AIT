package Task_02;

public class MyThread2 extends Thread{

    @Override
    public synchronized void run() {

        Calculation calculation = new Calculation();
        calculation.calculate(1_000_001, 2_000_000);
    }
}
