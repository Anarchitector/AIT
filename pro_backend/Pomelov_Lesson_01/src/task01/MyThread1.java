package task01;

public class MyThread1 extends Thread{

    @Override
    public void run() {

        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(200);
            }
            catch(InterruptedException e) {
                throw new RuntimeException((e));
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
