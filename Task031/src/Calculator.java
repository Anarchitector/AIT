import java.util.Scanner;

@FunctionalInterface
interface Calculator {
    double operate(double a, double b);
}

class Main3 {
    public static void main(String[] args) {
        double num1, num2;
        char operation;
        Scanner sc = new Scanner(System.in);

        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;

        System.out.print("Введите первое число: ");
        num1 = sc.nextDouble();
        System.out.print("Введите второе число: ");
        num2 = sc.nextDouble();
        System.out.print("Введите математическую операцию: ");
        operation = sc.next().charAt(0);

        switch (operation)
        {
            case '+':
            {
                System.out.println("Сумма " + num1 + " и " + num2 + " равна " + add.operate(num1, num2));
                break;
            }
            case '-':
            {
                System.out.println("Разность " + num1 + " и " + num2 + " равна " + subtract.operate(num1, num2));
                break;
            }
            case '*':
            {
                System.out.println("Умножение " + num1 + " и " + num2 + " равно " + multiply.operate(num1, num2));
                break;
            }
            case '/':
            {
                System.out.println("Деление " + num1 + " и " + num2 + " равно " + divide.operate(num1, num2));
            }
            default:
            {
                System.out.println("Вы ввели неверную математическую операцию.");
                break;
            }
        }
    }
}

class Main30 {
    public static void main(String[] args) {

        double num1, num2;
        char operation;
        Scanner sc = new Scanner(System.in);

        Calculator add = new Calculator() {
            @Override
            public double operate(double a, double b) {
                return a + b;
            }
        };

        Calculator sub = new Calculator() {
            @Override
            public double operate(double a, double b) {
                return a - b;
            }
        };

        Calculator mul = new Calculator() {
            @Override
            public double operate(double a, double b) {
                return a * b;
            }
        };

        Calculator div = new Calculator() {
            @Override
            public double operate(double a, double b) {
                return a / b;
            }
        };

        System.out.print("Введите первое число: ");
        num1 = sc.nextDouble();
        System.out.print("Введите второе число: ");
        num2 = sc.nextDouble();
        System.out.print("Введите математическую операцию: ");
        operation = sc.next().charAt(0);

        switch (operation)
        {
            case '+':
            {
                System.out.println("Сумма " + num1 + " и " + num2 + " равна " + add.operate(num1, num2));
                break;
            }
            case '-':
            {
                System.out.println("Разность " + num1 + " и " + num2 + " равна " + sub.operate(num1, num2));
                break;
            }
            case '*':
            {
                System.out.println("Умножение " + num1 + " и " + num2 + " равно " + mul.operate(num1, num2));
                break;
            }
            case '/':
            {
                System.out.println("Деление " + num1 + " и " + num2 + " равно " + div.operate(num1, num2));
            }
            default:
            {
                System.out.println("Вы ввели неверную математическую операцию.");
                break;
            }
        }
    }
}