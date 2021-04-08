package Homework11;

import java.util.HashMap;
import java.util.HashSet;

public class Phone {
    HashMap<String, String> phoneBook = new HashMap<>();

    public Phone() {
        this.phoneBook = phoneBook;
    }

    HashMap<String, HashSet<String>> phoneBook_p = new HashMap<>();
    HashSet<String> phone_number;

    public void addPerson(String name, String phone) {

        if (phoneBook_p.containsKey(name)) {
            phone_number = phoneBook_p.get(name);
        } else {
            phone_number = new HashSet<>();
            phone_number.add(phone);
            phoneBook_p.put(name, phone_number);
        }
    }

    public HashSet<String> get(String name) {
        return phoneBook_p.get(name);

    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.addPerson("alex", "79035031415");
        phone.addPerson("alla", "79035031416");
        phone.addPerson("bella", "79035031417");
        phone.addPerson("alla", "79035031418");
        System.out.println(phone.get("alla"));

    }

}


//2.Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
//        искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
//        (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
//        Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
//        взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода
//        результатов проверки телефонного справочника.