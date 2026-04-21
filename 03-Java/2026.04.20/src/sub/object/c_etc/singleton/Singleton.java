package com.kb.chap06n.makeclass;

/*
 * [싱글톤 패턴 (Singleton Pattern)]
 *
 * 싱글톤이란?
 * - 프로그램 전체에서 객체를 단 하나만 생성하고,
 *   그 하나의 객체를 여러 곳에서 공유해서 사용하는 설계 방식이다.
 * - 예: 데이터베이스 연결, 설정 정보, 로그 관리 등
 *
 * 싱글톤 구현 방법:
 * 1. 생성자를 private 으로 선언한다.
 *    → 외부에서 new 로 객체를 직접 만들 수 없게 막는다.
 * 2. 클래스 내부에서 딱 하나의 객체를 static 으로 미리 생성해 둔다.
 * 3. 그 객체를 반환하는 public static 메소드(getInstance)를 제공한다.
 *    → 외부에서는 이 메소드를 통해서만 객체를 얻을 수 있다.
 *
 * 핵심: 몇 번을 getInstance() 해도 항상 같은 객체가 반환된다.
 */
public class Singleton {

    // 클래스 내부에서 딱 하나의 객체를 미리 생성해서 보관한다
    // private 이므로 외부에서 직접 접근할 수 없다
    private static Singleton singleton = new Singleton();

    // private 생성자 - 외부에서 new Singleton() 호출을 막는다
    private Singleton() {
    }

    // 유일한 객체를 반환하는 정적 메소드
    // 외부에서는 반드시 이 메소드를 통해서만 객체를 얻을 수 있다
    public static Singleton getInstance() {
        return singleton;  // 항상 같은 하나의 객체를 반환한다
    }
}
