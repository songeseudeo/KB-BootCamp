package com.kb.chap06n.makeclass.f_check.field;

public class FieldTest {


    /*
     * 클래스 == "필드(field)" + 생성자 + 메소드   의 조합
     *
     * >> 변수 구분
     *
     * - 필드(field) : 클래스에 선언된 변수 --> 클래스 내부 어디서든 사용 가능
     *   (※ 흔히 전역변수라고 부르기도 하지만 Java 공식 용어는 아님)
     *
     * - 지역변수(local variable) : 특정 블록({}) 안에 선언된 변수
     *   --> 해당 블록 내에서만 사용 가능
     *   (메소드, if, for 등)
     *
     * 1. 필드 (field)
     * - 인스턴스 변수 (instance variable)
     *   생성 시점 : new 연산자로 객체 생성 시 Heap 영역에 생성
     *   소멸 시점 : 객체 소멸 시 함께 소멸
     *
     * - 클래스 변수 (class variable, static 변수)
     *   생성 시점 : 클래스가 메모리에 로딩될 때(Method Area 영역)
     *   소멸 시점 : 프로그램 종료 시
     *   >> 모든 객체가 공유하는 변수
     *
     * 2. 지역변수 (local variable)
     *   생성 시점 : 블록({}) 실행 시 생성 (ex. 메소드 호출 시)
     *   소멸 시점 : 블록({}) 종료 시 소멸
     */


    // 인스턴스 변수 (instance variable) == 필드(field)
    // - 객체 생성 시마다 각각 따로 생성됨
    private int global; // 필드는 초기화하지 않으면 JVM이 기본값으로 자동 초기화한다.


    /*
     * static 변수 (클래스 변수)
     * - 클래스당 하나만 생성
     * - 모든 객체가 공유
     */
    public static int count;


    public void test(int num ){ // num 매개변수(parameter) == 지역변수 //메소드 내부에서 사용하는 지역변수

        int local = 10; //지역변수 , 초기화필수  //지역변수에는 접근 제한자 붙이지 않는다.

        global++; // 객체마다 따로 증가
        count++;  // 모든 객체가 공유


        System.out.println("global (인스턴스 변수) = " + global);
        // 인스턴스 변수(멤버 변수)
        // - 객체가 생성될 때 Heap 영역에 생성됨
        // - 클래스 내부 어디서든 사용 가능
        // - 초기화하지 않으면 JVM이 기본값으로 자동 초기화
        System.out.println("count  (static 변수)    = " + count);
        // static 변수(클래스 변수)
        // - 프로그램 시작 시 Method Area에 생성됨
        // - 객체 생성 여부와 상관없이 클래스 단위로 하나만 존재
        // - 모든 객체가 공유하는 변수
        System.out.println("local  (지역변수)       = " + local);
        // 지역변수
        // - 메소드 또는 블록({}) 내부에서만 사용 가능
        // - 반드시 개발자가 초기화해야 함 (초기화하지 않으면 컴파일 에러)
        System.out.println("num    (매개변수)       = " + num);
        // 매개변수
        // - 메소드 호출 시 전달받는 값
        // - 메소드 실행과 동시에 지역변수로 생성됨
        // - 호출 시 반드시 값이 전달되어야 함
        System.out.println("-------------------------");
    }// 메소드 끝날때 지역변수 다 소멸



    // 필드(instance / static)는 자동 초기화,
    // 지역변수 / 매개변수는 반드시 초기화 후 사용해야 한다.
}
