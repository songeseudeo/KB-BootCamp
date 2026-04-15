package com.kb.c_chap04.s;

/*
 * ===============================
 * 제어문 - switch 표현식 (Java 12+)
 * ===============================
 *
 * Java 12 부터 switch 문이 표현식(expression)으로 사용 가능해졌다.
 * 기존 switch 문과의 주요 차이점
 *
 * - case -> 화살표 문법 사용 (break 불필요)
 * - 값을 반환할 수 있어 변수에 바로 대입 가능
 * - 여러 case 를 쉼표(,)로 한 번에 묶을 수 있음
 * - 블록({}) 사용 시 yield 키워드로 값을 반환 (Java 13+)
 * - 값을 반환하는 경우 default 가 반드시 있어야 함
 */
public class Control03 {

    public static void main(String[] args) {

        String grade = "B";

        // ===============================
        // 1. 기존 switch 문 (Java 12 이전)
        // ===============================
        /*
         * 값을 변수에 저장하려면 각 case 안에서
         * 직접 변수에 대입하고 break 를 써야 한다.
         */

        int score1 = 0;

        switch (grade) {
            case "A":
                score1 = 100;
                break;
            case "B":
                int result = 100 - 20;
                score1 = result;
                break;
            default:
                score1 = 60;
        }

        System.out.println("score1: " + score1);

        System.out.println("--------------------------------");

        // ===============================
        // 2. switch 표현식 - 화살표 문법 (Java 12+)
        // ===============================
        /*
         * case -> 형태로 작성하면
         * break 없이도 fall-through 가 발생하지 않는다.
         * 오른쪽의 값이 곧 해당 case 의 결과값이 된다.
         * switch 전체 결과를 변수에 바로 대입할 수 있다.
         */

        int score2 = switch (grade) {
            case "A" -> 100;
            case "B" -> 80;
            default -> 60;
        };

        System.out.println("score2: " + score2);

        System.out.println("--------------------------------");

        // ===============================
        // 3. yield - 블록 안에서 값 반환 (Java 13+)
        // ===============================
        /*
         * case 안에서 여러 줄의 코드가 필요할 때
         * 중괄호({})로 블록을 만들고
         * yield 키워드로 반환할 값을 지정한다.
         * yield 는 switch 표현식 전용 키워드다.
         */

        int score3 = switch (grade) {
            case "A" -> 100;
            case "B" -> {
                int calc = 100 - 20;
                yield calc;     // 블록에서 값을 반환할 때는 yield 사용
            }
            default -> 60;
        };

        System.out.println("score3: " + score3);

        System.out.println("--------------------------------");

        // ===============================
        // 4. 여러 case 를 쉼표로 묶기
        // ===============================
        /*
         * 기존 switch 문에서 fall-through 로 처리하던 방식 대신
         * 쉼표(,)로 case 를 묶을 수 있다.
         * 대소문자를 같은 결과로 처리할 때 유용하다.
         */

        switch (grade) {
            case "A", "a" -> System.out.println("우수 회원입니다.");
            case "B", "b" -> System.out.println("일반 회원입니다.");
            default -> System.out.println("손님입니다.");
        }

        System.out.println("--------------------------------");

        // ===============================
        // 5. switch 표현식으로 문자열 반환
        // ===============================
        /*
         * 반환값의 타입은 String, int 등 어떤 타입이든 가능하다.
         * 변수에 바로 대입하거나 출력문 안에 바로 넣을 수 있다.
         */

        String animal = "Dog";

        String sound = switch (animal) {
            case "Dog" -> "Bark";
            case "Cat" -> "Meow";
            case "Cow" -> "Moo";
            case "Duck" -> "Quack";
            default -> "Unknown sound";
        };

        System.out.println("The " + animal + " makes a sound: " + sound);

        // 변수 없이 출력문 안에 바로 사용
        System.out.println(
            switch (animal) {
                case "Dog" -> "Bark";
                case "Cat" -> "Meow";
                case "Cow" -> "Moo";
                case "Duck" -> "Quack";
                default -> "Unknown sound";
            }
        );

        System.out.println("--------------------------------");


    }
}