package sub.object.b_member;

public class Car {

    private String model;
    private int speed;

    public Car(int speed, String model) {
        this.speed = speed;
    }

public String getModel() {
    return model;
}

public void setModel(String model) {
    this.model = model;
}

public int getSpeed() {
    return speed;
}

public void setSpeed(int speed) {
    this.speed = speed;
}

    // 일반 인스턴스 메소드
    public void run() {
        this.setSpeed(100);
        System.out.println(this.model + "가 달립니다 시속 : " + this.speed);
    }

// 정적 메소드 - 정적메소드 안에서 인스턴스 멤버를 사용하고자 할때는 반드시 객체를 생성하고 사용

    public static void simulate() {
        // System.out.println(speed); // 컴파일 에러, 어느객체의 speed 인지 알 수가 없다
        Car myCar = new Car(100, "test 카");
        myCar.run();
    }
}

