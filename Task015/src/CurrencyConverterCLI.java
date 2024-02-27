import java.util.Scanner;
import org.junit.jupiter.

class CurrencyConverter{
    double[] currencyRates;
    String[] availableCurrencies;
    final short allCurr = 4;

    CurrencyConverter(){
        this.currencyRates = new double[allCurr];
        this.currencyRates[0] = 1;
        this.currencyRates[1] = 0.92;
        this.currencyRates[2] = 0.03;
        this.currencyRates[3] = 0.056;

        this.availableCurrencies = new String[allCurr];
        this.availableCurrencies[0] = "eur";
        this.availableCurrencies[1] = "usd";
        this.availableCurrencies[2] = "tl";
        this.availableCurrencies[3] = "mdl";
    }

    CurrencyConverter(String[] currencyRates) {
        this();
        if (currencyRates.length == allCurr) for (short i = 0; i < allCurr; i++) {
            this.currencyRates[i] = Double.parseDouble(currencyRates[i]);
        }
    }

    CurrencyConverter(double[] currencyRates, String[] availableCurrencies) {
        this();
        if (currencyRates.length == allCurr) for (short i = 0; i < allCurr; i++) {
            this.currencyRates[i] = currencyRates[i];
        }

        if (availableCurrencies.length == allCurr) for (short i = 0; i < allCurr; i++) {
            this.availableCurrencies[i] = availableCurrencies[i];
        }
    }

    public boolean isCorrectCurrency(String currency) {
        for (String s: this.availableCurrencies) {
            if (s.equalsIgnoreCase(currency))
                return true;
        }
        return false;
    }

    public double getRateValue(String currency) {
        for (int i = 0; i < this.availableCurrencies.length; i = i + 1) {
            if (this.availableCurrencies[i].equalsIgnoreCase(currency))
                return this.currencyRates[i];
        }
        return -1;
    }

    public double convert(String currencyFrom, String currencyTo, double sum) {
        double x = getRateValue(currencyFrom);
        double y = getRateValue(currencyTo);

        double finalSum = sum * x / y;
        int roundedTotal = (int) (finalSum * 100);
        finalSum = (double) roundedTotal / 100;
        return finalSum;
    }
}


class CurrencyConverterCLI {
    public static void main(String[] args) {
        final short allCurr = 4;
        CurrencyConverter converter = args.length ==  allCurr ? new CurrencyConverter(args) : new CurrencyConverter();
        Scanner sc = new Scanner(System.in);
        String initCurr, finalCurr;
        String s;

        welcomeMessage();
        printAllCurrencies(converter);

        do {
            System.out.print("Введите валюту для продажи (или введите exit для выхода из программы): ");
            initCurr = sc.nextLine();

            if (initCurr.equalsIgnoreCase("exit")) {
                System.out.println("До свидания!");
                continue;
            }

            if (!converter.isCorrectCurrency(initCurr)) {
                System.out.println("Неверное значение, попробуйте еще раз!");
                continue;
            }

            System.out.print(("Введите валюту для покупки (или введите exit для выхода из программы): "));
            finalCurr = sc.nextLine();

            if (finalCurr.equalsIgnoreCase("exit")) {
                break;
            }
            if (!converter.isCorrectCurrency(finalCurr)) {
                System.out.println("Вы ввели неверное значение.");
            }

            System.out.print("Введите сумму " + initCurr + " для обмена на " + finalCurr + ": ");
            s = sc.nextLine();

            if (s.equalsIgnoreCase("exit")) {
                return;
            } else {
                System.out.println("Итого: " + converter.convert(initCurr, finalCurr, Double.parseDouble(s)) + " " + finalCurr + "\n");
            }
        } while (!initCurr.equalsIgnoreCase("exit"));
    }

    public static void welcomeMessage()
    {
        System.out.print("\033[H\033[J");
        System.out.println("\n\t\t***** Приветствуем вас в программе CurrencyConverter *****\n");
    }

    public static void printAllCurrencies(CurrencyConverter converter) {
        System.out.println("Список валют:");
        for (short i = 0; i < converter.allCurr; i++) {
            System.out.println((i + 1) + ". " + converter.availableCurrencies[i]);
        }
    }
}