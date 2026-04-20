package sub.object.makeclass.a_field;

public class Run {
    public static void main(String[] args) {

        Car car1 = new Car();
        System.out.println(car1.model);
        System.out.println(car1.start);
        System.out.println(car1.speed);
        System.out.println(car1.company);
        System.out.println(car1.color);
        System.out.println(car1.maxSpeed);

        Car car2 = new Car();
        car2.speed = -60;
        System.out.println(car2.model);
        System.out.println(car2.start);
        System.out.println(car2.speed);
    }
}