package Task_01;

public class MyThread extends Thread{

    @Override
    public synchronized void run() {

        Calculation calculation = new Calculation();
        calculation.calculate(0, 2_000_000);
    }






}
