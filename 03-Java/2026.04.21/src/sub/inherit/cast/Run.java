package sub.inherit.cast;

import sub.inherit.field.Car;
import sub.inherit.field.HankookTire;
import sub.inherit.field.KumhoTire;
import sub.inherit.field.Tire;
import sub.inherit.parameter.Driver;
import sub.inherit.parameter.Bus;
import sub.inherit.parameter.Taxi;

public class Run {
    public static void main(String[] args) {
        // 부모 타입으로 변환해도 오버라이딩된 메소드는 자식 것이 호출된다.
        // 정적 바인딩 (Static Binding)
        // - 컴파일 시점에 호출할 메소드가 결정되는 것
        // - static 메소드, private 메소드, final 메소드

        // 동적 바인딩
        // - 실행(런타임) 시점에 실제 객체 타입(Child)에 맞는 메소드가 호출된다.
        // - 부모 타입으로 참조하더라도 오버라이딩된 메소드는 자식 것이 실행된다.

        Parent parent = new Child();

        parent.method1();
        parent.method2();
        //parent.method3();

        //자식 멤버에 접근하려면 강제 타입변환 필요
        Child child = (Child) parent;

        child.method3();

        System.out.println("===============");
        Car car = new Car();
        car.setTire(new HankookTire());
        car.run();

        car.setTire(new KumhoTire());
        car.run();

        car.setTire(new Tire());
        car.run();


        System.out.println("=============");

        Driver driver = new Driver();
        driver.driver(new Bus());
        driver.driver(new Taxi());

    }
}
