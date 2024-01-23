import java.util.Arrays;
import java.util.Currency;
import java.util.Scanner;
public class CurrencyConverter {
    public static void main(String[] args) {
        int numCurr1, numCurr2, choice = 0;
        double sum = 0;
        int allCurr = 3;
        Scanner sc = new Scanner(System.in);
        String[] currName = new String[allCurr];
        currName[0] = "EUR";
        currName[1] = "USD";
        currName[2] = "MDL";
        double[][] rates = new double[allCurr][allCurr];
        rates[0][0] = 1;
        rates[0][1] = 0.932400932;
        rates[0][2] = 0.05200208;
        rates[1][0] = 1.108893324;
        rates[1][1] = 1;
        rates[1][2] = 0.056721497;
        rates[2][0] = 19.53125;
        rates[2][1] = 17.921146953;
        rates[2][2] = 1;
        System.out.print("\033[H\033[J");
        System.out.println("\n\t\t***** Приветствуем вас в программе CurrencyConverter *****\n");
        System.out.println("Список валют:");
        for (short i = 0; i < allCurr; i++) {
            System.out.println((i + 1) + ". " + currName[i]);
        }
        do {
            System.out.print("Выберите валюту для продажи (Введите номер валюты): ");
            numCurr1 = sc.nextInt();
            if ((numCurr1 < 0) || (numCurr1 > allCurr)) {
                System.out.println("Вы ввели неверное значение.");
            }
        } while ((numCurr1 < 0) || (numCurr1 > allCurr));
        do {
            System.out.print(("Выберите валюту для покупки (Введите номер валюты): "));
            numCurr2 = sc.nextInt();
            if ((numCurr2 < 0) || (numCurr2 > allCurr)) {
                System.out.println("Вы ввели неверное значение.");
            }
        } while ((numCurr2 < 0) || (numCurr2 > allCurr));
        System.out.print("Введите сумму " + currName[numCurr1 - 1] + " для обмена на " + currName[numCurr2 - 1] + ": ");
        sum = sc.nextDouble();
        System.out.print("Результат: ");
        System.out.println(sum / rates[numCurr1 - 1][numCurr2 - 1]);
    }
}