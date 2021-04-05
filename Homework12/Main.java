package Homework12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void newFile(AppData appData) {
        try (PrintWriter out = new PrintWriter("newfile.csv")) {
            for (String value : appData.getHeader()) {
                out.print(value + ";");
            }
            out.println();
            int[][] listData = appData.getData();
            for (int i = 0; i < listData.length; i++) {
                for (int j = 0; j < listData[i].length; j++) {
                    out.print(listData[i][j] + ";");
                }
                out.write("\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static AppData readFile(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        List<int[]> data = new ArrayList<>();
        String[] dataHead = in.readLine().split(";");
        String header;
        while ((header = in.readLine()) != null) {
            List<Integer> list = new ArrayList<>();
            String[] string = header.split(";");
            for (int i = 0; i < string.length; i++) {
                list.add(Integer.parseInt(string[i]));
            }
            data.add(list.stream().mapToInt(i -> i).toArray());
        }
        AppData appData = new AppData(dataHead, data.toArray(new int[0][]));
        int[][] array = appData.getData();
        return appData;
    }

    public static void main(String[] args) throws IOException {
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {{100, 200, 300}, {400, 500, 600}};
        AppData appData = new AppData(header, data);
        newFile(appData);
        readFile("newfile.csv");
    }
}

//    Реализовать сохранение данных в csv файл;
//    Реализовать загрузку данных из csv файла. Файл читается целиком.
//        Структура csv файла:
//        Строка заголовок с набором столбцов
//        Набор строк с целочисленными значениями
//
//        Разделитель между столбцами - символ точка с запятой (;)
//        Пример:
//        Value 1;Value 2;Value 3
//        100;200;123
//        300,400,500
//
//        Для хранения данных использовать класс вида:
//public class AppData {
//    private String[] header;
//    private int[][] data;
//
//// ...
//}

