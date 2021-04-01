package Homework11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Word {
    public static void main(String[] args) {

        String arr[] = {"дом", "лес", "ночь", "трава", "дом", "угл", "луг", "плуг", "лук", "лес", "поле"};
        HashSet<String> words = new HashSet<>(Arrays.asList(arr));
        System.out.println("Список уникальных слов массива: " + words);
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word : arr) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }
        System.out.println("Общее количество слов: " + allWords);
    }
    Phone pb = new Phone();


}


//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
//        из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
