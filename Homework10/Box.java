package Homework10;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    private ArrayList<T> fruitsList;

    public Box(ArrayList<T> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public ArrayList<T> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(ArrayList<T> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public boolean compareTo(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }
//    public boolean connect(Box <T> box){
//        fruitsList.addAll();
//        fruitsList.clear();
//    }

    public float getWeight() {
        return fruitsList.size() * fruitsList.get(0).getWeight();
    }

    public void addFruit(T fruit, int amount){
        for(int i=0;i<amount;i++){
            fruitsList.add(fruit);
        }
    }
        public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new ArrayList<>(Arrays.asList(new Apple(), new Apple(), new Apple())));
        Box<Orange> orangeBox = new Box<>(new ArrayList<>(Arrays.asList(new Orange(), new Orange(), new Orange())));
        System.out.println("Вес короюки яблок: "+ appleBox.getWeight());
        System.out.println("Вес короюки апельсинов: "+orangeBox.getWeight());
        System.out.println("Вес коробки после добавления фруктов: ");
        appleBox.addFruit(new Apple(),5);
        System.out.println(appleBox.getWeight());
        System.out.println("Сравниваем вес двух коробок: "+appleBox.compareTo(orangeBox));
    }
}
