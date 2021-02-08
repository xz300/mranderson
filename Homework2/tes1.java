package Homework2;

import java.util.Arrays;

public class tes1 {
    public static void main(String[] agrs) {
//1 Задать целочисленный массив, состоящий из элементов 0 и 1.  Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в     принятом массиве 0 на 1, 1 на 0;

        int[] test01 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        number1(test01);

//2 Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;

        int[] test02 = new int[8];
        number(test02);
        System.out.println("Ответ 2  -  "+ Arrays.toString(test02));

//3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,принимающий на вход массив и умножающий числа меньше 6 на 2;

        int[] test03 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        number2(test03);
        System.out.println("Ответ 3  -  "+Arrays.toString(test03));

//4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
       int[] test04 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        number3(test04);
        number4(test04);
        System.out.println("max  -  "+ number3(test04));
        System.out.println("min  -  "+ number4(test04));

//5* Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);

    }
    public static void number1(int[] test01){
        for (int i = 0; i < test01.length; i++){
            if (test01[i] == 1) {
                test01[i] = 1;
                System.out.println(test01[i]=0);
            }
            else {
                test01[i] = 0;
                System.out.println(test01[i]=1);
            }
        }
    }

    public static void number(int[] test02){
        for (int i = 0; i <test02.length; i++)
            test02[i]=i*3+1;
    }
    public static void number2(int[] test03){
        for (int i = 0; i <test03.length; i++)
        if (test03[i] < 6)
            test03[i] *=2;
    }
    public static int number3(int[] test04){
        Arrays.sort(test04);
        return test04[test04.length-1];

    }
    public static int number4(int[] test04){
        int min = test04[0];
        for (int i = 0; i < test04.length; i++){
        if (test04[i]<min)
            min = test04[i];
    }
        return min;
    }

}



