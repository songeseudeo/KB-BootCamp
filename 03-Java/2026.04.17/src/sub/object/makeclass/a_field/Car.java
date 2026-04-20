package sub.object.makeclass.a_field;

/*
 * [필드 선언과 기본값]
 *
 * 필드(Field)란?
 * - 클래스 안에 선언된 변수이다.
 * - 객체가 가져야 할 데이터를 저장하는 역할을 한다.
 * - 메소드 안에 선언하는 지역변수와 달리,
 *   필드는 객체가 살아있는 동안 계속 유지된다.
 *
 * 필드의 기본값 (초기값을 주지 않았을 때 자동으로 설정되는 값):
 * +-----------+----------+
 * | 타입      | 기본값   |
 * +-----------+----------+
 * | int       | 0        |
 * | double    | 0.0      |
 * | boolean   | false    |
 * | String    | null     |
 * | 참조타입  | null     |
 * +-----------+----------+
 */
public class Car {
    //필드부
    String model; //null
    boolean start; //false
    int speed; //0

    String company = "현대자동차";
    String color = "검정";
    int maxSpeed = 350;

    //생성자부
}
