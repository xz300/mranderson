public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        try {
            array(new String[][]{{"1", "2", "3", "4"}, {"1", "5", "4", "2"}, {"4", "3", "4", "1"}, {"5", "3", "1", "2"}});
        } catch (MyArraySizeException e) {
            System.out.println("Только массив 4*4");

        } catch (MyArrayDataException e) {
            System.out.println("Преобразование не удалось в строке: " + e.getI() + ", столбеце: " + e.getJ());
        }

    }

    public static int array(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int a = arr.length;
        int b = arr[0].length;
        if (a != 4 || b != 4) {
            throw new MyArraySizeException("Только массив 4*4");
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
//                    System.out.println("Сумма всех элементов массива: " + sum);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i + 1, j + 1);
                }
            }
        }
        return sum;
//        System.out.println("Сумма всех элементов массива: " + sum);
    }
}
// 1.Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера
// необходимо бросить исключение MyArraySizeException.
// 2.Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
// массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
// исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
// 3.В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
// и вывести результат расчета.
