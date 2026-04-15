package sub.chap04;

import java.util.Scanner;

/*
 * ===============================
 * 제어문 - while 반복문
 * ===============================
 *
 * while 문은 반복 횟수가 명확하지 않고
 * 조건에 따라 반복을 계속할지 결정할 때 사용한다.
 *
 * while (조건식) {
 *     반복 실행할 코드;
 * }
 *
 * 실행 순서
 * 1) 조건식 검사
 * 2) true → 블록 실행
 * 3) 다시 1번으로 돌아가서 반복
 * 4) 조건식이 false → 반복문 종료
 *
 * for 문 vs while 문
 * - for 문  : 반복 횟수가 정해진 경우
 * - while 문: 조건에 따라 반복 횟수가 달라지는 경우
 */
public class Control05 {

    public static void main(String[] args) {

        // ===============================
        // 1. 기본 while 문 - 1부터 10까지 출력
        // ===============================
        /*
         * 초기값, 조건식, 증감식을 직접 관리해야 한다.
         * 증감식을 빠뜨리면 무한 반복(무한 루프)이 발생한다.
         */
        int i = 1;
        while(i <=10) {
            System.out.print(i + " ");
            i++;
        }

        System.out.println();
        System.out.println("--------------------------------");

        // ===============================
        // 2. 1부터 100까지 합계
        // ===============================
        int j = 1;
        int sum=0;
        while(j <=100){
            sum += j;
            j++;
        }
        System.out.println("합산: " +sum);
        System.out.println("--------------------------------");

        // ===============================
        // 3. 무한 루프 + boolean 플래그로 종료
        // ===============================
        /*
         * while (true) 는 조건이 항상 true 이므로
         * 무한 반복된다.
         * boolean 변수를 플래그(flag)로 사용해서
         * 특정 조건이 되면 false 로 바꿔 반복을 종료한다.
         */

        boolean run = true;
        int speed = 0;
        Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.println("-------------------------");
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.println("-------------------------");
            System.out.print("선택: ");

            String input = sc.nextLine();

            if (input.equals("1")) {
                speed++;
                System.out.println("현재 속도: " + speed);
            } else if (input.equals("2")) {
                speed--;
                System.out.println("현재 속도: " + speed);
            } else if (input.equals("3")) {
                run = false;    // 조건을 false 로 바꿔 반복 종료
            }
        }

        System.out.println("프로그램 종료");

        System.out.println("--------------------------------");

        // ===============================
        // 4. 반복 횟수 카운트 + 조건 분기
        // ===============================
        /*
         * 5번 입력을 받아 긍정/부정/기타 횟수를 센다.
         */

        int ok = 0, no = 0, etc = 0;
        int count = 0;

        while (count < 5) {
            System.out.print("ok(긍정) / no(부정) / 그 외(기타) 입력: ");
            String data = sc.nextLine();

            if (data.equals("ok")) {
                ok++;
            } else if (data.equals("no")) {
                no++;
            } else {
                etc++;
            }
            count++;

        }

        System.out.println("긍정 횟수: " + ok);
        System.out.println("부정 횟수: " + no);
        System.out.println("기타 횟수: " + etc);

        System.out.println("--------------------------------");

        sc.close();


    }
}