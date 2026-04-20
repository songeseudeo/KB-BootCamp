package sub.array;

/*
 * ===============================
 * Array06 - 참조 변수 비교와 null
 * ===============================
 *
 * 참조 타입이란?
 * - 배열, String 등 실제 데이터가 heap 영역에 저장되는 타입
 * - 변수에는 데이터의 주소(참조값)가 저장된다
 *
 * == 연산자의 의미
 * - 기본 타입 : 값 자체를 비교한다
 * - 참조 타입 : 주소(참조값)를 비교한다
 *              두 변수가 같은 객체를 가리키는지 확인한다
 *
 * null 이란?
 * - 아무 객체도 참조하지 않는 상태
 * - 참조 타입 변수에만 사용할 수 있다
 * - 0, false, ""(빈 문자열)과 전혀 다른 개념이다
 */
public class Array06 {
    public static void main(String[] args) {

        // ===============================
        // 1. 배열 변수의 참조 비교
        // ===============================
        int[] arr1 = new int[]{1, 2, 3}; // 배열 A 생성
        int[] arr2 = new int[]{1, 2, 3}; // 배열 B 생성 (값은 같지만 다른 객체)
        int[] arr3 = arr2;               // arr2의 주소를 arr3에 복사

        // arr1과 arr2는 값이 같아도 다른 배열이므로 false
        System.out.println("arr1 == arr2 : " + (arr1 == arr2)); // false

        // arr2와 arr3은 같은 배열을 가리키므로 true
        System.out.println("arr2 == arr3 : " + (arr2 == arr3)); // true





        // ===============================
        // 2. null - 참조하지 않는 상태
        // ===============================

        // 리터럴로 선언 - JVM 이 String Pool 에 "자동차" 를 저장한다
        // kind1 은 String Pool 의 "자동차" 주소를 가리킨다
                String kind1 = "자동차";

        // kind2 는 새 객체를 만드는 게 아니라
        // kind1 이 가리키는 주소를 그대로 복사한다
        // → kind1 과 kind2 는 같은 "자동차" 를 가리킨다
                String kind2 = kind1;

        // kind1 을 null 로 바꾼다
        // "자동차" 객체를 없앤 게 아니라 kind1 이 아무것도 가리키지 않도록 바꾼 것이다
        // String Pool 의 "자동차" 는 그대로 남아있다
                kind1 = null;

        // kind1 은 null 이지만 kind2 는 여전히 "자동차" 를 참조한다
        System.out.println("\nkind2 : " + kind2); // 자동차


        // ===============================
        // 3. NullPointerException
        // ===============================
        /*
         * null 상태의 변수로 메서드나 데이터에 접근하면
         * NullPointerException 예외가 발생한다
         *
         * 해결 방법 : 사용 전에 null 여부를 확인한다
         */
        int[] intArray = null;
        // intArray[0] = 10; // NullPointerException 발생

        String str = null;
        // System.out.println(str.length()); // NullPointerException 발생

        // null 체크 후 안전하게 사용
        if (str != null) {
            System.out.println("문자열 길이 : " + str.length());
        } else {
            System.out.println("\nstr은 null 상태입니다. 사용할 수 없습니다.");
        }
    }
}
