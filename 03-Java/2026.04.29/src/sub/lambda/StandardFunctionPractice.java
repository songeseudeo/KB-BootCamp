package sub.lambda;

import java.util.function.*;

/*
 * ============================================================
 * [표준 함수형 인터페이스 실습]
 * ============================================================
 *
 * 람다는 결국 아래 5가지 역할로 나뉜다.
 *
 * Consumer  -> T -> void       (받아서 처리)
 * Supplier  -> void -> T       (만들어서 반환)
 * Function  -> T -> R          (변환)
 * Predicate -> T -> boolean    (조건 검사)
 * Operator  -> T -> T          (계산)
 *
 * ※ 이 인터페이스들은 나중에 Stream에서 자동으로 사용된다
 */

public class StandardFunctionPractice {

    public static void main(String[] args) {

        System.out.println("==== 1. Consumer (받아서 처리) ====");
        practiceConsumer();

        System.out.println("\n==== 2. Supplier (만들어서 반환) ====");
        practiceSupplier();

        System.out.println("\n==== 3. Function (변환) ====");
        practiceFunction();

        System.out.println("\n==== 4. Predicate (조건 검사) ====");
        practicePredicate();

        System.out.println("\n==== 5. Operator (계산) ====");
        practiceOperator();

        System.out.println("\n==== 🔥 과제 실습 ====");
        practiceHomework();
    }


    // ============================================================
    // 1. Consumer -> T -> void (받아서 처리)
    // ============================================================
    public static void practiceConsumer() {

        /*https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Consumer.html
         * Consumer<T>
         *  void accept(T t)
         *
         * -> 값을 받아서 처리만 하고 끝 (리턴 없음)
         */

        Consumer<String> consumer = s -> System.out.println("출력: " + s);

        consumer.accept("Hello");
        consumer.accept("Lambda");
    }


    // ============================================================
    // 2. Supplier -> void -> T (만들어서 반환)
    // ============================================================
    public static void practiceSupplier() {

        /*https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Supplier.html
         * Supplier<T>
         *  T get()
         *
         * -> 값을 만들어서 반환
         */

        Supplier<String> supplier = () -> "랜덤 값";

        System.out.println("결과: " + supplier.get());
    }


    // ============================================================
    // 3. Function -> T -> R (변환)
    // ============================================================
    public static void practiceFunction() {

        /*https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Function.html
         * Function<T, R>
         *  R apply(T t)
         *
         * -> 입력값을 다른 타입으로 변환
         */

        Function<String, Integer> func = s -> s.length();

        System.out.println("문자열 길이: " + func.apply("Lambda"));
    }


    // ============================================================
    // 4. Predicate -> T -> boolean (조건 검사)
    // ============================================================
    public static void practicePredicate() {

        /*https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Predicate.html
         * Predicate<T>
         *  boolean test(T t)
         *
         * -> 조건 검사 후 true / false 반환
         */

        Predicate<Integer> predicate = x -> x > 10;

        System.out.println("5 > 10 ? " + predicate.test(5));
        System.out.println("20 > 10 ? " + predicate.test(20));
    }


    // ============================================================
    // 5. Operator -> T -> T (계산)
    // ============================================================
    public static void practiceOperator() {

        /*https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/BinaryOperator.html
         * BinaryOperator<T>
         *  T apply(T t1, T t2)
         *
         * -> 같은 타입끼리 연산 후 결과 반환
         */

        BinaryOperator<Integer> op = (a, b) -> a + b;

        System.out.println("3 + 5 = " + op.apply(3, 5));
    }


    // ============================================================
    //  과제 실습
    // ============================================================
    public static void practiceHomework() {

        // ------------------------------------------------------------
        //  과제 1: Consumer -> 짝수 / 홀수 출력
        // ------------------------------------------------------------
        Consumer<Integer> evenOdd = num -> {
            if (num % 2 == 0) {
                System.out.println(num + " : 짝수");
            } else {
                System.out.println(num + " : 홀수");
            }
        };

        evenOdd.accept(5);
        evenOdd.accept(10);


        // ------------------------------------------------------------
        // 과제 2: Supplier -> 값 생성
        // ------------------------------------------------------------
        Supplier<String> defaultName = () -> "게스트";
        System.out.println(defaultName.get());


        // ------------------------------------------------------------
        //  과제 3: Function -> 문자열 대문자 변환
        // ------------------------------------------------------------
        Function<String, String> toUpper = str -> str.toUpperCase();

        System.out.println("대문자 변환: " + toUpper.apply("lambda"));


        // ------------------------------------------------------------
        //  과제 4: Predicate -> 100 이상 검사
        // ------------------------------------------------------------
        Predicate<Integer> isOver100 = num -> num >= 100;

        System.out.println("50은 100 이상? " + isOver100.test(50));
        System.out.println("150은 100 이상? " + isOver100.test(150));


        // ------------------------------------------------------------
        //  과제 5: Operator -> 큰 값 반환
        // ------------------------------------------------------------
        BinaryOperator<Integer> max = (a, b) -> (a > b) ? a : b;

        System.out.println("큰 값: " + max.apply(10, 20));
    }
}