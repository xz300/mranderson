public class FunctionTriangle {
    public static double functionTriangle(int a, int b, int c) {
        int p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return Math.sqrt(s);
    }
    public static boolean triangle(int args) {
        double a;
        a = functionTriangle(1, 2, 1);
        System.out.println("Треугольник со сторонами 3,3,3 имеет площадь:" + a);
        a = functionTriangle(1, 2, 3);
        System.out.println("Треугольник со сторонами 3,4,5 имеет площадь:" + a);
        a = functionTriangle(9, 9, 0);
        System.out.println("Треугольник со сторонами 9,9,0 имеет площадь:" + a);
        return false;
    }
}
