package com.kb.chap06n.useclass;

import com.kb.chap06n.makeclass.Singleton;

/*
 * [싱글톤 패턴 실습]
 *
 * getInstance() 를 여러 번 호출해도 항상 같은 객체를 가리킨다.
 * == 연산자로 두 참조변수가 같은 객체를 가리키는지 확인할 수 있다.
 *
 * [메모리 구조]
 *   obj1 ------+
 *              +--> Singleton 객체 (단 하나)
 *   obj2 ------+
 */
public class SingletonExample {
    public static void main(String[] args) {

        // new Singleton() 은 private 생성자이므로 호출 불가 → 컴파일 에러
        // Singleton obj1 = new Singleton();   // 컴파일 에러
        // Singleton obj2 = new Singleton();   // 컴파일 에러

        // getInstance() 를 통해서만 객체를 얻을 수 있다
        Singleton obj1 = Singleton.getInstance();  // 내부에 보관된 유일한 객체 반환
        Singleton obj2 = Singleton.getInstance();  // 동일한 객체를 또 반환

        // obj1 과 obj2 가 같은 객체를 가리키는지 확인
        // == 연산자는 참조변수의 경우 같은 객체인지(주소가 같은지)를 비교한다
        if (obj1 == obj2) {
            System.out.println("같은 Singleton 객체입니다.");  // 이 줄이 출력된다
        } else {
            System.out.println("다른 Singleton 객체입니다.");
        }
    }
}
