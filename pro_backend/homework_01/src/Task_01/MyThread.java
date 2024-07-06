package Task_01;

public class MyThread extends Thread{

    @Override
    public synchronized void run() {

        int a ,b;
        for (int i = 0; i <= 2_000_000; i++) {
            if ((i % 21) == 0) {
                a = i;
                while (a != 0) {
                    b = a % 10;
                    if(b==3){
                        App.incCounter();
                        break;
                    }
                    a = a / 10;
                }
            }
        }
    }






}
