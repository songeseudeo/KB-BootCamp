package sub.object;

import sub.object.b_member.Calculator;
import sub.object.b_member.Car;
import sub.object.b_member.Earth;
import sub.object.b_member.Korean;

public class Run {
    public static void main(String[] args) {

        // public → 다른 패키지에서도 접근 가능
        System.out.println("public 상수: " + Earth.PUBLIC_TEST);

        // default → 다른 패키지에서는 접근 불가
        // System.out.println("default 상수: " + Earth.DEFAULT_TEST); // 컴파일 에러

        // protected → 다른 패키지 + 상속 아님 → 접근 불가
        // System.out.println("protected 상수: " + Earth.PROTECTED_TEST); // 컴파일 에러

        // private → 다른 패키지에서 직접 접근 불가
        // System.out.println("private 상수: " + Earth.PRIVATE_TEST); // 컴파일 에러

        // private 상수는 public 메서드로 간접 접근 가능
        System.out.println("private 상수(간접 접근): " + Earth.getPrivateTest());
    }
}