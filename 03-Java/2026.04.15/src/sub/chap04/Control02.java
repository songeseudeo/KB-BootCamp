package com.kb.c_chap04.s;

/*
 * ===============================
 * 제어문 - switch 문
 * ===============================
 *
 * switch 문은 하나의 변수 값을 기준으로
 * 여러 경우(case) 중 하나를 선택하여 실행하는 조건문이다.
 *
 * if-else if 와 달리 대소 비교(>, <)는 불가능하고
 * 값의 일치 여부만 비교한다.
 *
 * 사용 가능한 타입
 * - byte, short, char, int
 * - String
 * - enum
 *
 * 사용 불가능한 타입
 * - double, float (실수)
 * - boolean
 *
 * switch (변수) {
 *     case 값1:
 *         실행문;
 *         break;
 *     case 값2:
 *         실행문;
 *         break;
 *     default:
 *         실행문;
 * }
 */
public class Control02 {

    public static void main(String[] args) {

        // ===============================
        // 1. switch 문 기본 구조
        // ===============================
        /*
         * 괄호 안의 변수값과 일치하는 case로 이동해서 실행한다.
         * 일치하는 case가 없으면 default를 실행한다.
         * default는 생략할 수 있다.
         *
         * 아래 예제에서 num은 1~6 사이의 난수이다.
         * (Math.random() 자세한 내용은 Control08 참고)
         */

        int num = (int) (Math.random() * 6) + 1;

        switch (num) {
            case 1:
                System.out.println("1번이 나왔습니다.");
                break;
            case 2:
                System.out.println("2번이 나왔습니다.");
                break;
            case 3:
                System.out.println("3번이 나왔습니다.");
                break;
            case 4:
                System.out.println("4번이 나왔습니다.");
                break;
            case 5:
                System.out.println("5번이 나왔습니다.");
                break;
            default:
                System.out.println("6번이 나왔습니다.");
        }

        System.out.println("--------------------------------");

        // ===============================
        // 2. break 가 없을 때 - fall-through
        // ===============================
        /*
         * break 가 없으면 해당 case 이후의 모든 case가
         * 조건과 관계없이 연달아 실행된다.
         * 이를 fall-through(폴스루)라고 한다.
         *
         * 아래 예제에서 time 이 8이면
         * case 8 → case 9 → case 10 → default 순으로
         * 모두 출력된다.
         *
         * 의도적으로 활용하는 경우가 아니면
         * break 를 반드시 작성한다.
         */

        int time = (int) (Math.random() * 4) + 8;
        System.out.println("[현재 시간: " + time + "시]");

        switch (time) {
            case 8:
                System.out.println("출근합니다.");
            case 9:
                System.out.println("회의를 합니다.");
            case 10:
                System.out.println("업무를 봅니다.");
            default:
                System.out.println("외근을 나갑니다.");
        }

        System.out.println("--------------------------------");

        // ===============================
        // 3. 여러 case 를 같은 동작으로 묶기
        // ===============================
        /*
         * fall-through 를 의도적으로 활용하는 대표적인 경우다.
         * 대문자 A와 소문자 a를 같은 결과로 처리하고 싶을 때
         * break 없이 case 를 연달아 쓴다.
         */

        char gradeChar = 'B';

        switch (gradeChar) {
            case 'A':
            case 'a':
                System.out.println("우수 회원입니다.");
                break;
            case 'B':
            case 'b':
                System.out.println("일반 회원입니다.");
                break;
            default:
                System.out.println("손님입니다.");
        }

        System.out.println("--------------------------------");

        // ===============================
        // 4. String 타입 switch
        // ===============================
        /*
         * Java 7 부터 String 타입을 switch 에 사용할 수 있다.
         * 내부적으로 equals() 로 비교하므로
         * 대소문자를 구분한다.
         */

        String name = "자바";

        switch (name) {
            case "자바":
                System.out.println("자바입니다.");
                break;
            case "파이썬":
                System.out.println("파이썬입니다.");
                break;
            case "리눅스":
                System.out.println("리눅스입니다.");
                break;
            default:
                System.out.println("알 수 없는 언어입니다.");
                break;
        }

        System.out.println("--------------------------------");

    }

}