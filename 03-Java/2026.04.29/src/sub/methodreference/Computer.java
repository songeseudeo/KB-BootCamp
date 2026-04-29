package sub.methodreference;

public class Computer {

    // =============================== 정적 메소드
    public static double staticMethod(double x, double y) {
        return x + y;
    }

    // =============================== 인스턴스 메소드
    public double instanceMethod(double x, double y) {
        return x * y;
    }
}
