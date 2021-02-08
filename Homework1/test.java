package Homework1;
import javax.lang.model.element.Name;
public class test {
    public static void main(String[] agrs) {
// Ввводные данные 1
// Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой, где a, b, c, d –
// целочисленные входные параметры этого метода;
        int a=1;
        int b=2;
        int c=3;
        float d=4;
        task1(a,b,c,d);
        System.out.println("Ответ 1: " + task1(a,b,c,d));

// Ввводные данные 2
// Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20
// (включительно), если да – вернуть true, в противном случае – false;
        int a1=14;
        int b1=6;
        int x=a1+b1;
        System.out.println("Сумма чисел лежит в пределах от 10 до 20: " + task2(a1,b1,x));

// Ввводные данные 3
// Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число
// передали, или отрицательное. Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
        int a2 = -1;
        System.out.println("Число положительное? " + task3(a2));

// Ввводные данные 4
// Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть
// приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
        String name = "Mr.Anderson";
        System.out.println("Привет " + task4(name));
    }

// задание 1
        private static float task1(int a, int b, int c, float d) {
            return  a * (b + (c/d));                }
// задание 2
        public static boolean task2(int a1,int b1,int x){
            return (x >= 10) && (x <= 20);                }
// задание 3
        public static boolean task3(int a2){
            return a2 >=0;
   }
// задание 4
        public static String task4(String name){
            return name;    }
}


