package sub.object.makeclass.c_method;
/*
 * [가변길이 매개변수]
 *
 * 가변길이 매개변수란?
 * - 메소드를 호출할 때 전달하는 값의 개수가 정해져 있지 않을 때 사용한다.
 * - "타입... 변수명" 형태로 선언한다.
 * - 메소드 내부에서는 배열처럼 사용할 수 있다.
 *
 * 가변길이 매개변수로 받을 수 있는 형태:
 * 1. 값을 직접 나열:    sum(1, 2, 3)
 * 2. 배열 변수 전달:    sum(values)
 * 3. 배열 직접 생성:    sum(new int[]{1, 2, 3})
 */
public class Computer {
    // 가변길이 매개변수를 갖는 메소드 선언
    // int... values : 개수에 상관없이 int 값을 여러 개 받을 수 있다
    public int sum(int... values) {

        int sum = 0;  // 합산 결과를 저장할 변수

        // values 는 배열처럼 사용한다 - 전달받은 값을 순서대로 꺼내 더한다
        for (int value : values) {
            sum += value;   // 누적 합산
        }

        return sum;  // 합산 결과를 리턴
    }
}
