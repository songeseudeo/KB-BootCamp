package sub.object.b_member;

public class Run {
    public static void main(String[] args) {

        //인스턴스 매소드 호출
        Car c1 = new Car(10, "rest1 카");
        c1.run();

        //정적매소드에서 인스턴드 멤버 호출
        Car.simulate();

        System.out.println("==============");
        //정적 멤버 public static 직접 접근
        double result1 = 10*10*Calculator.pie;

        int result2 = Calculator.plus(10, 5);
        int result3 = Calculator.plus(10, 5);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        Calculator cal1 = new Calculator();
        Calculator cal2 = new Calculator();
        Calculator cal3 = new Calculator();

        System.out.println(Calculator.getCount());

        //-------------final

        Korean k1 = new Korean("홍길동", "123456-1234567");

        System.out.println(k1);
        k1.setName("제니");
        //k1.setSsn("11111-2222222"); final이라 변경 불가능

        // public → 다른 패키지에서도 접근 가능
        System.out.println("public 상수: " + Earth.PUBLIC_TEST);

        // default → 다른 패키지에서는 접근 불가
                System.out.println("default 상수: " + Earth.DEFAULT_TEST); // 다른 패키지면 컴파일 에러

        // protected → 다른 패키지 + 상속 아님 → 접근 불가
                System.out.println("protected 상수: " + Earth.PROTECTED_TEST); // 다른 패키지면 컴파일 에러

        // private → 다른 패키지에서 직접 접근 불가
        // System.out.println("private 상수: " + Earth.PRIVATE_TEST); // 컴파일 에러

        // private 상수는 public 메서드로 간접 접근 가능
        System.out.println("private 상수(간접 접근): " + Earth.getPrivateTest());
    }
}
