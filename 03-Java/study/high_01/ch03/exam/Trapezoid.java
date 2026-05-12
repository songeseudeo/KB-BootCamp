package high_01.ch03.exam;

public class Trapezoid {
    public static void main(String[] args) {
        int top = 5;
        int bottom = 10;
        int height = 7;

        double area = (top + bottom) * height / 2.0;

        System.out.println("사다리꼴의 넓이: " + area);
    }
}
