package sub.object.userclass;


import sub.object.makeclass.b_gettersetter.Car;

public class Run {
    public static void main(String[] args) {

        Car car = new Car();
        car.setModel("그랜저");
        car.setColor("흰색");
        car.setStart(true);

        car.setSpeed(-100);
        System.out.println(car);

    }
}
