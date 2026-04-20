package sub.array;

import java.util.Random;

/*
 * ===============================
 * Array01 - 배열 기본 개념
 * ===============================
 *
 * 배열이란?
 * - 동일한 자료형의 데이터를 연속된 메모리 공간에 저장하는 구조
 * - heap 영역에 new 연산자를 이용하여 할당한다
 * - 인덱스는 0부터 시작한다
 * - length 필드로 크기를 확인한다
 * - 생성 시 자동으로 기본값으로 초기화된다
 * - 크기는 생성 후 변경할 수 없다
 */
public class Array01 {
    public static void main(String[] args) {

        // ===============================
        // 1. 배열을 사용하지 않을 때의 문제점
        // ===============================
        /*
         * 변수를 하나씩 선언하면
         * 1. 변수 이름을 모두 직접 관리해야 한다
         * 2. 반복문으로 연속 처리가 불가능하다
         */
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        int num5 = 50;

        int sum = num1 + num2 + num3 + num4 + num5;
        System.out.println("변수 5개의 합 : " + sum);


        // ===============================
        // 2. 배열 선언과 생성
        // ===============================
        /*
         * 자료형[] 변수명 = new 자료형[크기];
         *
         * 배열 변수는 stack 영역에 저장되고
         * 실제 데이터는 heap 영역에 저장된다
         * 배열 변수에는 heap 영역의 주소값이 담긴다
         */
        int[] scores = new int[1000];

        // 배열을 출력하면 주소 형태의 식별 문자열이 나온다 (실제 메모리 주소는 아님)
        System.out.println(scores); // 예: [I@1b6d3586


        // ===============================
        // 3. 인덱스로 값 저장 및 읽기
        // ===============================
        scores[0] = 100;    // 첫 번째 위치
        scores[10] = 999;   // 열한 번째 위치
        scores[999] = 1000; // 마지막 위치

        System.out.println("첫 번째 값 : " + scores[0]);
        System.out.println("열한 번째 값 : " + scores[10]);
        System.out.println("마지막 값 : " + scores[999]);

        // 값을 저장하지 않은 인덱스는 기본값(0)으로 자동 초기화
        System.out.println("초기화된 값 : " + scores[1]);


        // ===============================
        // 4. 배열의 크기 - length 필드
        // ===============================
        System.out.println("배열 크기 : " + scores.length);
        System.out.println("마지막 인덱스 : " + (scores.length - 1));


        // ===============================
        // 5. 타입별 기본값
        // ===============================
        /*
         * 배열 생성 시 자동으로 채워지는 초기값
         *
         * 정수형(int, long 등) : 0
         * 실수형(double, float) : 0.0
         * 논리형(boolean)       : false
         * 문자형(char)          : '\u0000' (빈 문자)
         * 참조형(String 등)     : null
         */
        int[]     intArr    = new int[3];
        double[]  doubleArr = new double[3];
        boolean[] boolArr   = new boolean[3];
        String[]  strArr    = new String[3];

        System.out.println("int 기본값    : " + intArr[0]);
        System.out.println("double 기본값 : " + doubleArr[0]);
        System.out.println("boolean 기본값: " + boolArr[0]);
        System.out.println("String 기본값 : " + strArr[0]);


        // ===============================
        // 6. 실습 - 로또 번호 생성
        // ===============================
        /*
         * 6개의 공간을 만들고
         * 1~45 사이의 랜덤 숫자를 각 위치에 저장한다
         * (현재는 중복 번호가 발생할 수 있다)
         */


    }
}
