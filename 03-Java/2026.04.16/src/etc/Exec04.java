package com.multi.d_etc;

public class Exec04 {
    // =========================================
    // Math 클래스
    // =========================================
    // Math 클래스는 java.lang 패키지에 포함되어 있으며
    // 수학 관련 연산을 위한 정적(static) 메서드를 제공한다.
    //
    //  객체 생성 없이 사용 가능 (static 메서드)
    //  모든 메서드는 Math.메서드명() 형태로 호출
    // Math 클래스는 계산 로직에서 매우 자주 사용되며
    // 난수(Math.random()), 제곱(Math.pow()), 절댓값(Math.abs()) 등
    // 다양한 수학 메서드를 함께 제공한다.
    // 공식 문서:
	//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Math.html
	public static void main(String[] args) {

        // -----------------------------------------
        // 1. 올림 / 내림
        // -----------------------------------------
        // ceil()  : 올림 (소수점 이하가 있으면 무조건 올림)
        // floor() : 내림 (소수점 이하 버림)
        // 반환 타입은 double

        double v1 = Math.ceil(5.3);   // 6.0
        double v2 = Math.floor(5.3);  // 5.0

        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);

        // -----------------------------------------
        // 2. 최대값 / 최소값
        // -----------------------------------------
        // max(a, b) : 두 값 중 큰 값 반환
        // min(a, b) : 두 값 중 작은 값 반환
        //
        // 정수, 실수 모두 사용 가능
        // 전달한 타입에 따라 반환 타입이 결정됨

        long v3 = Math.max(3, 7); // 7
        long v4 = Math.min(3, 7); // 3

        System.out.println("v3 = " + v3);
        System.out.println("v4 = " + v4);

        // -----------------------------------------
        // 3. 반올림 (round)
        // -----------------------------------------
        // round() : 소수점 첫째 자리에서 반올림
        //
        // 반환 타입
        // - float  → int
        // - double → long

        double value = 12.3456;

        // 소수점 둘째 자리까지 반올림하고 싶을 때의 처리 방법
        double temp1 = value * 100;      // 1234.56
        long temp2 = Math.round(temp1);  // 1235
        double v5 = temp2 / 100.0;       // 12.35

        System.out.println("v5 = " + v5);



    }

}

