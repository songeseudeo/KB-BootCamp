package sub.object.userclass;

import sub.object.makeclass.c_method.Calculator;
import sub.object.makeclass.c_method.Car;

public class MethodRun {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.powerOn();

        int rs1 = calc.plus(5, 6);
        System.out.println(rs1);

        //divide
        double r2 = calc.divide(10, 4);
        System.out.println("result2: " + r2);
        calc.powerOff();

        System.out.println("======");

        Car car = new Car();
        car.setGas(3);
        if (car.isLeftGas()) {
            System.out.println("출발 합니다.");
            car.run();
        }

        System.out.println("gas를 주입하세요!");

        System.out.println("=======");

        //정사각형 가로 * 가로
        double result1 = calc.areaRectangle(10);
        System.out.println("정사각형의 넓이=" + result1);   // 100.0

        //직사각형 가로 * 세로
        double result2 = calc.areaRectangle(10, 20);
        System.out.println("직사각형의 넓이=" + result2);   // 200.0

        System.out.println("=======");

        Computer com = new Computer();
        System.out.println(com.sum(1, 2, 3, 4));
        System.out.println(com.sum(1, 2, 3, 4, 5, 6, 7, 8));

        int[] values = {1, 2, 3, 4, 5};
        System.out.println(com.sum(values));
    }
}
