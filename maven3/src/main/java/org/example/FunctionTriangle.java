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
}
