//package l31;

interface Greeting {
    void sayHello();
    void sayGoodbye();
}

class Main1 {
    public static void main(String[] args) {
        Greeting greeting1 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Привет из анонимного класса!");
            }

            @Override
            public void sayGoodbye() {
                System.out.println("Прощание из анонимного класса!");
            }
        };

        Greeting greeting2 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello!");
            }

            @Override
            public void sayGoodbye() {
                System.out.println("Good-bye!");
            }
        };

        Greeting greeting3 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Слышь? Сюда иди!");
            }

            @Override
            public void sayGoodbye() {
                System.out.println("Вали отсюда!");
            }
        };

        greeting3.sayHello();
        greeting2.sayHello();
        greeting3.sayGoodbye();
        greeting2.sayGoodbye();
    }
}