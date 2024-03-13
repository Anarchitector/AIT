import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        myArrayList myList = new myArrayList();

        System.out.println("Adding numbers to the list");
        for(int i = 0; i < 20; i++)
        {
            myList.add(i);
            System.out.println(myList.getCount() + " - " + myList.getByIndex(i));
        }

        System.out.println("Removing element at index 17 from the list");
        myList.removeByIndex(17);

        for(int i = 0; i < 20; i++)
        {
            System.out.println(myList.getByIndex(i));
        }
    }
}
