import java.util.Arrays;
import java.util.Currency;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {

        int num;
        int result = 0;
        int operation;
        Scanner sc = new Scanner(System.in);
        int[] numbers = {3,2,5,8,4};

        do{
            System.out.println("1.Линейный поиск");
            System.out.println("2.Бинарный поиск");
            System.out.println("3.Сортировка по возрастанию");
            System.out.println("4.Выход");
            System.out.print("\nВыберите операцию: ");
            operation = sc.nextInt();

            switch (operation) {
                case 1 : {
                    System.out.println("Введите число: ");
                    num = sc.nextInt();

                    result = linearSearch(num, numbers);
                    if (result != -1) {
                        System.out.println("Число " + num + " находится в элементе массива номер " + result);
                    }
                    else {
                        System.out.println("Введенное число отсутствует в массиве");
                    }
                    break;
                }
                case 2 : {
                    System.out.println("Введите число: ");
                    num = sc.nextInt();

                    result = binarySearch(num, numbers);
                    if (result != -1) {
                        System.out.println("Число " + num + " находится в элементе массива номер " + result);
                    }
                    else {
                        System.out.println("Введенное число отсутствует в массиве");
                    }
                    break;
                }
                case 3 : {
                    sort(numbers);
                    System.out.println("Сортировка массива по возрастанию выполнена");
                    System.out.println(Arrays.toString(numbers));
                    break;
                }
                case 4 : return;
                default : break;
            }
        } while(true);


    }

    public static int linearSearch(int num, int[] array)
    {
        for(int index = 0; index < array.length; index++)
        {
            if(array[index] == num) return index;
        }
        return -1;
    }
    public static int binarySearch(int num, int[] array)
    {
        int L,R,M;

        L = 0;
        R = array.length - 1;

        for(int index = 0; index < array.length; index++)
        {
            M = L + (R - L) / 2;

            if (num > array[M])
            {
                L = M + 1;
            }
            else if (num < array[M])
            {
                R = M - 1;
            }
            else return M;
        }

        return -1;
    }

    public static void sort(int[] array)
    {
        int M;
        for(int i = 0; i < array.length; i++)
        {
            for(int j = i; j < array.length; j++)
            {
                if (array[i] > array[j])
                {
                    M = array[j];
                    array[j] = array[i];
                    array[i] = M;
                }
            }
        }
    }




}
