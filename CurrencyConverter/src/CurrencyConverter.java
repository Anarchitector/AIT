import java.util.Arrays;
import java.util.Currency;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        String initCurr, finalCurr;
        double sum = 0;
        int allCurr = 3;
        Scanner sc = new Scanner(System.in);
        String s;
        String[] currName = new String[allCurr];
        currName[0] = "eur";
        currName[1] = "usd";
        currName[2] = "mdl";
        boolean correctCurr = false;

        double eur_usd_rate = 1.07;
        double usd_eur_rate = 0.9;
        double eur_mdl_rate = 19.17;
        double mdl_eur_rate = 0.05;
        double usd_mdl_rate = 17.6;
        double mdl_usd_rate = 0.06;

        System.out.print("\033[H\033[J");
        System.out.println("\n\t\t***** Приветствуем вас в программе CurrencyConverter *****\n");

        do {
            System.out.println("Список валют:");
            for (short i = 0; i < allCurr; i++) {
                System.out.println((i + 1) + ". " + currName[i]);
            }

            do {
                System.out.print("Выберите валюту для продажи (Введите номер валюты): ");
                initCurr = sc.nextLine();

                if (initCurr.equals("exit")) {
                    break;
                }
                for (int i = 0; i < allCurr; i++) {
                    if (initCurr.equals(currName[i])) {
                        correctCurr = true;
                        break;
                    }
                }
                if (!correctCurr) {
                    System.out.println("Вы ввели неверное значение.");
                }
            } while (!correctCurr);

            if (initCurr.equals("exit")) {
                return;
            }

            correctCurr = false;
            do {
                System.out.print(("Выберите валюту для покупки (Введите номер валюты): "));
                finalCurr = sc.nextLine();

                if (finalCurr.equals("exit")) {
                    break;
                }
                for (int i = 0; i < allCurr; i++) {
                    if (finalCurr.equals((currName[i]))) {
                        correctCurr = true;
                        break;
                    }
                }
                if (!correctCurr) {
                    System.out.println("Вы ввели неверное значение.");
                }
            } while (!correctCurr);

            if (finalCurr.equals("exit")) {
                return;
            }

            System.out.print("Введите сумму " + initCurr + " для обмена на " + finalCurr + ": ");
//            sum = sc.nextDouble();
            s = sc.nextLine();

            if (s.equals("exit")) {
                return;
            }
            else {
                sum = Double.parseDouble(s);

                switch (initCurr) {
                    case "eur": {
                        switch (finalCurr) {
                            case "usd": {
                                sum *= eur_usd_rate;
                                break;
                            }
                            case "mdl": {
                                sum *= eur_mdl_rate;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                        break;
                    }
                    case "usd": {
                        switch (finalCurr) {
                            case "eur": {
                                sum *= usd_eur_rate;
                                break;
                            }
                            case "mdl": {
                                sum *= usd_mdl_rate;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                        break;
                    }
                    case "mdl": {
                        switch (finalCurr) {
                            case "eur": {
                                sum *= mdl_eur_rate;
                                break;
                            }
                            case "usd": {
                                sum *= mdl_usd_rate;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }


            System.out.println("Итого: " + sum + " " + finalCurr);
        } while ();

    }

}