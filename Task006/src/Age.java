import java.util.Scanner;
public class Age {
    public static void main(String[] args) {

        short age;
        final short minAge = 0, maxAge = 150;
        final short babyMaxAge = 14;
        final short adolMaxAge = 18;
        final short adultMaxAge = 60;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите возраст человека");
        age = sc.nextShort();

        while  ((age < 0) || (age > 150))
        {
            System.out.println("Вы ввели неверное значение, повторите ввод снова:");
            age = sc.nextShort();
        }

        if (age <= babyMaxAge)
        {
            System.out.println("Ребенок");
        }
        else if (/*(age > babyMaxAge) &&*/ (age <= adolMaxAge) )
        {
            System.out.println("Подросток");
        }
        else {
            System.out.println((/*(age > adolMaxAge) && */(age <= adultMaxAge)) ? ("Взрослый") : ("Пожилой"));
        }

    }
}
