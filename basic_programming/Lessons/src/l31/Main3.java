package l31;

@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

class Main3 {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("Сумма 5 и 3 равна " + add.operate(5, 3));
        System.out.println("Разность 5 и 3 равна " + subtract.operate(5, 3));
        System.out.println("Умножение 5 и 3 равно " + multiply.operate(5, 3));

    }
}

class Main30 {
    public static void main(String[] args) {
        Calculator add = new Calculator() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        int result = add.operate(2, 2);

        System.out.println("2 + 2 = " + result);

        Calculator sub = new Calculator() {
            @Override
            public int operate(int a, int b) {
                return a - b;
            }
        };
        int result2 = sub.operate(2, 2);

        System.out.println("2 - 2 = " + result2);
    }


}