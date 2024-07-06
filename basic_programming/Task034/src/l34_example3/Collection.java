package l34_example3;

import java.util.HashSet;
import java.util.Set;
public class Collection {
    public static void main(String[] args) {
// Создание хеш-сета для строк
        Set<String> hashSet = new HashSet<>();
// Добавление "Apple" в хеш-сет
        hashSet.add( "Apple");
        hashSet.add( "Banana" );
        hashSet.add( "Apple");
        System. out.println(hashSet);
    }
}