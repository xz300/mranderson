package org.example;

public class FunctionTriangle {

    public static double functionTriangleCal(int a, int b, int c) throws Exception {
        double square = 0;
        if ((a <= 0 || b <= 0 || c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a))
            throw new TriangleException("Треугольника не существует");
        else {
            double p = (a + b + c) / 2.0;
            square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return square;
    }
//    public static double functionTriangle(int a, int b, int c) {
//        int p = (a + b + c) / 2;
//        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
//        return Math.sqrt(s);
//    }

//    {
//        double s = (((a + b + c) / 2) * ((a + b + c) / 2 - a) * ((a + b + c) / 2 - b) * ((a + b + c) / 2 - c));
//        return Math.sqrt(s);
//    }
//
//    public static boolean main(int args) {
//        double a;
//        a = functionTriangle(1, 2, 1);
//        System.out.println("Треугольник со сторонами 3,3,3 имеет площадь:" + a);
//        a = functionTriangle(1, 2, 3);
//        System.out.println("Треугольник со сторонами 3,4,5 имеет площадь:" + a);
//        a = functionTriangle(9, 9, 0);
//        System.out.println("Треугольник со сторонами 9,9,0 имеет площадь:" + a);
//        return false;
//    }
}
