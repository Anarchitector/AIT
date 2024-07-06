package Task_01;

public class Calculation {

    public void calculate(int initNum, int lastNum) {

        int a, b;

        for (int i = initNum; i <= lastNum; i++) {
            if ((i % 21) == 0) {
                a = i;
                while (a != 0) {
                    b = a % 10;
                    if(b==3){
                        Numbers.incCounter();
                        break;
                    }
                    a = a / 10;
                }
            }
        }
    }
}
