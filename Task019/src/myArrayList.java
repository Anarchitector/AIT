import java.util.ArrayList;
import java.util.Arrays;

public class myArrayList {

    private static int INITIAL_SIZE = 10;
    private static int CURRENT_SIZE = 10;
    // массив для хранения элементов
    private int[] myArray;
    // количество элементов списка
    private int count = 0;

    public myArrayList()
    {
        this.myArray = new int[INITIAL_SIZE];
    }

    public void add(int element) {
        if (count >= myArray.length) {
            expandArray();
        }
        myArray[count] = element;
        count++;
    }

    public int getInitialSize()
    {
        return INITIAL_SIZE;
    }
    public int getCurrentSize()
    {
        return CURRENT_SIZE;
    }
    public int getCount() { return count; }
    public void setInitialSize(int newSize)
    {
        INITIAL_SIZE = newSize;
    }
    public void setCurrentSize(int newSize)
    {
        CURRENT_SIZE = newSize;
    }

    public void expandArray()
    {
        myArray = Arrays.copyOf(myArray, (int) (myArray.length * 1.5));
        setCurrentSize(myArray.length);
    }

    public void expandArrayToValue(int maxIndex)
    {
        myArray = Arrays.copyOf(myArray, (int) (myArray.length + (maxIndex - myArray.length)));
        setCurrentSize(myArray.length);
    }

    public void expandArrayByValue(int value)
    {
        myArray = Arrays.copyOf(myArray, (int) (myArray.length + value));
        setCurrentSize(myArray.length);
    }

    public void removeByIndex(int index)
    {
        for( ; (index + 1) < myArray.length; index++) {
            myArray[index] = myArray[index + 1];
        }
        count--;
    }

    public int getByIndex(int index)
    {
        return myArray[index];
    }
}
