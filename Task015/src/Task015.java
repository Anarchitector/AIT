import java.util.Arrays;
import java.util.Currency;
import java.util.Scanner;

public class Task015 {
    public static void main(String[] args) {

        class CurrencyConverter{
            double[] currencyRates;
            String[] availableCurrencies;
            final short allCurr = 3;

            CurrencyConverter(){

                this.availableCurrencies = new String[allCurr];
                this.availableCurrencies[0] = "eur";
                this.availableCurrencies[1] = "usd";
                this.availableCurrencies[2] = "mdl";
            }

            CurrencyConverter(double[] currencyRates) {
                this();
                if (currencyRates.length == allCurr) {
                    this.currencyRates[0] = currencyRates[0];
                    this.currencyRates[1] = currencyRates[1];
                    this.currencyRates[2] = currencyRates[2];
                }
            }

            CurrencyConverter(double[] currencyRates, String[] availableCurrencies) {
                this();
                if (currencyRates.length == allCurr) {
                    this.currencyRates[0] = currencyRates[0];
                    this.currencyRates[1] = currencyRates[1];
                    this.currencyRates[2] = currencyRates[2];
                }

                if (availableCurrencies.length == allCurr) {
                    this.availableCurrencies[0] = availableCurrencies[0];
                    this.availableCurrencies[1] = availableCurrencies[1];
                    this.availableCurrencies[2] = availableCurrencies[2];
                }
            }
        }

        CurrencyConverter converter = new CurrencyConverter();
        String initCurr, finalCurr;

        Scanner sc = new Scanner(System.in);
        String s;

        boolean correctCurr = false;

        welcomeMessage();
        printAllCurrencies(converter.availableCurrencies , allCurr);

        do {
            do {
                System.out.print("Введите валюту для продажи (или введите exit для выхода из программы): ");
                initCurr = sc.nextLine();

                if (initCurr.equals("exit")) {
                    break;
                }
                correctCurr = verifyCurrency(initCurr, converter.availableCurrencies, converter.allCurr);
                if (!correctCurr) {
                    System.out.println("Вы ввели неверное значение.");
                }
            } while (!correctCurr);

            if (initCurr.equals("exit")) {
                return;
            }

            correctCurr = false;
            do {
                System.out.print(("Введите валюту для покупки (или введите exit для выхода из программы): "));
                finalCurr = sc.nextLine();

                if (finalCurr.equals("exit")) {
                    break;
                }
                correctCurr = verifyCurrency(finalCurr, currName, allCurr);
                if (!correctCurr) {
                    System.out.println("Вы ввели неверное значение.");
                }
            } while (!correctCurr);

            if (finalCurr.equals("exit")) {
                return;
            }

            System.out.print("Введите сумму " + initCurr + " для обмена на " + finalCurr + ": ");
            s = sc.nextLine();

            if (s.equals("exit")) {
                return;
            } else {
                System.out.println("Итого: " + calculateSum(s, initCurr, finalCurr) + " " + finalCurr + "\n");
            }
        } while (true);
    }


    public static void welcomeMessage()
    {
        System.out.print("\033[H\033[J");
        System.out.println("\n\t\t***** Приветствуем вас в программе CurrencyConverter *****\n");
    }
    public static void printAllCurrencies(String[] currName, short allCurr) {
        System.out.println("Список валют:");
        for (short i = 0; i < allCurr; i++) {
            System.out.println((i + 1) + ". " + currName[i]);
        }
    }

    public static double getRateValue(String currency, double[] rates)
    {
        double rate;

        switch(currency)
        {
            case "eur" :

        }

    }

    public static boolean verifyCurrency(String s, String[] currName, short allCurr) {
        boolean correctCurr = false;

        for (int i = 0; i < allCurr; i++) {
            if (s.equals(currName[i])) {
                correctCurr = true;
                break;
            }
        }
        return correctCurr;
    }

    public static double calculateSum(String s, String initCurr, String finalCurr) {

        double sum = 0;
        double eur_usd_rate = 1.07;
        double usd_eur_rate = 0.9;
        double eur_mdl_rate = 19.17;
        double mdl_eur_rate = 0.05;
        double usd_mdl_rate = 17.6;
        double mdl_usd_rate = 0.06;

        sum = Double.parseDouble(s);

        switch (initCurr + "-" + finalCurr) {
            case "eur-usd": {
                sum *= eur_usd_rate;
                break;
            }
            case "eur-mdl": {
                sum *= eur_mdl_rate;
                break;
            }
            case "usd-eur": {
                sum *= usd_eur_rate;
                break;
            }
            case "usd-mdl": {
                sum *= usd_mdl_rate;
                break;
            }
            case "mdl-eur": {
                sum *= mdl_eur_rate;
                break;
            }
            case "mdl-usd": {
                sum *= mdl_usd_rate;
                break;
            }
            default: {
                break;
            }
        }
        return sum;
    }
}