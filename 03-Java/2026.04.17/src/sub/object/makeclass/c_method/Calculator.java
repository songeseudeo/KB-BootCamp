package sub.object.makeclass.c_method;
/*
 * [메소드 선언과 호출]
 *
 * 메소드(Method)란?
 * - 클래스 안에 선언된 동작(기능) 단위이다.
 * - 특정 작업을 수행하고, 필요하면 결과값을 돌려줄 수 있다.
 *
 * 메소드 선언 구조:
 *   리턴타입 메소드명(매개변수) {
 *       실행할 코드;
 *       return 리턴값;  // 리턴타입이 void 이면 생략 가능
 *   }
 *
 * 리턴타입:
 * - void    : 호출한 곳으로 돌려줄 값이 없다.
 * - int, double 등: 해당 타입의 값을 호출한 곳으로 돌려준다.
 *
 * 메소드 호출:
 *   참조변수.메소드명(전달값);
 */

public class Calculator {
    public void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    public void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    public int plus(int x, int y) {
        return x + y;
    }

    public double divide(int x, int y) {
        return (double) x / y;
    }

    public double areaRectangle(int i) {
        return 0;
    }
}
