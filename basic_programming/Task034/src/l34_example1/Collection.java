package l34_example1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection {

    public static void main(String[] args)
    {
        // Создание списка ArrayList для строк
        List<String> list = new ArrayList<>();
// Добавление элемента "Apple" в список
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
// Получение итератора для списка
        Iterator<String> iterator = list.iterator();
// Пока в списке есть элементы...
        while (iterator.hasNext()) {
// Получение следующего элемента списка
            String fruit = iterator.next();
// Вывод текущего элемента (фрукта) на экран
            System.out.println(fruit);
        }
    }
}
