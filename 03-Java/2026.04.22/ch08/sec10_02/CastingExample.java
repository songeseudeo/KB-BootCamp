package ch08.sec10_02;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
        //vehicle.checkFare();

        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();
    }
}
