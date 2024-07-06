package Task_02;

public class Numbers {

    private static int counter;

    public static synchronized void incCounter(){
        counter++;
    }

    public static int getCounter(){
        return counter;
    }
}
