package sub.chap04;

import java.util.Scanner;

/*
 * ===============================
 * 제어문 - do-while 반복문
 * ===============================
 *
 * do-while 문은 조건을 검사하기 전에
 * 블록을 반드시 한 번 먼저 실행하는 반복문이다.
 *
 * do {
 *     반복 실행할 코드;
 * } while (조건식);
 *
 * while 문과의 차이
 * - while  : 조건 먼저 검사 → 처음부터 false 면 한 번도 실행 안 됨
 * - do-while : 블록 먼저 실행 → 조건이 false 여도 최소 1번은 실행됨
 *
 * 세미콜론(;) 주의
 * while (조건식); 뒤에 반드시 세미콜론을 붙여야 한다.
 */
public class Control06 {

    public static void main(String[] args) {

        // ===============================
        // 1. do-while 기본 - 조건이 false 여도 1번은 실행
        // ===============================
        /*
         * while (false) 라면 블록이 실행되지 않지만
         * do-while (false) 는 블록을 한 번 실행한 뒤 종료한다.
         */

        do {
            System.out.println("최초로 한 번은 무조건 실행됩니다.");
        } while (false);

        System.out.println("반복문 종료 확인");

        System.out.println("--------------------------------");

        // ===============================
        // 2. do-while vs while 비교
        // ===============================
        /*
         * 아래 두 코드는 조건이 처음부터 false 일 때 결과가 다르다.
         *
         * while 문
         *   - 조건 검사 먼저 → 바로 종료, 출력 없음
         *
         * do-while 문
         *   - 블록 먼저 실행 → "실행됨" 출력 후 종료
         */

        System.out.println("[while 문 - 조건이 처음부터 false]");
        int a = 10;
        while (a < 5) {
            System.out.println("while 실행됨");
            a++;
        }
        System.out.println("while 종료 (출력 없음)");

        System.out.println();

        System.out.println("[do-while 문 - 조건이 처음부터 false]");
        int b = 10;
        do {
            System.out.println("do-while 실행됨");
            b++;
        } while (b < 5);
        System.out.println("do-while 종료 (1번 출력됨)");

        System.out.println("--------------------------------");

        // ===============================
        // 3. 메시지 입력 반복 - "q" 입력 시 종료
        // ===============================
        /*
         * 사용자가 메시지를 입력하면 출력하고
         * "q" 를 입력하면 종료한다.
         * 입력을 먼저 받아야 하므로 do-while 이 자연스럽다.
         */

        System.out.println("메시지를 입력하세요.");
        System.out.println("프로그램을 종료하려면 q를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        String inputString;

        do {
            System.out.print("> ");
            inputString = sc.nextLine();
            System.out.println(inputString);
        } while (!inputString.equals("q"));

        System.out.println();
        System.out.println("프로그램 종료");

        System.out.println("--------------------------------");

        sc.close();


    }
}