package Task_02;

public class MyThread extends Thread{

    @Override
    public synchronized void run() {

        Calculation calculation = new Calculation();
        calculation.calculate(0, 1_000_000);
    }






}
