package l34_example2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
// Создание списка ArrayList
        List<String> arrayList = new ArrayList<>();
// Добавление "Apple" в ArrayList
        arrayList.add("Apple");
        arrayList.add("Banana");
// Создание списка LinkedList
        List<String> linkedList = new LinkedList<>();
// Добавление "Cherry" в LinkedList
        linkedList.add("Cherry");
        linkedList.add("Date");
        System.out.println(arrayList);
        System.out.println(linkedList);
    }
}