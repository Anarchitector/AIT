public class Main {
    public static void main(String[] args) {
        String name, surname, age, city;
        String myName, mySurname, myCity;
        String Result;

        name = "Имя";
        surname = "Фамилия";
        age = "Возраст";
        city = "Город";

        myName = "Игорь";
        mySurname = "Пеньков";
        short myAge = 38;
        myCity = "Бад Хоннеф";

        Result = name + ':' + myName;
        System.out.println(Result);
        Result = surname + ':' + mySurname;
        System.out.println(Result);
        Result = age + ':' + Integer.toString(myAge);
        System.out.println(Result);
        Result = city + ':' + myCity;
        System.out.println(Result);
    }

}