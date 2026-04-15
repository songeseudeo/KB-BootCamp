package sub.chap04;

/*
 * ===============================
 * 제어문 - break / continue / return / System.exit()
 * ===============================
 *
 * 반복문 실행 중 흐름을 제어하는 키워드들이다.
 *
 * break          : 가장 가까운 반복문(또는 switch) 을 즉시 종료
 * continue       : 현재 반복만 건너뛰고 다음 반복으로 이동
 * return         : 현재 메서드를 즉시 종료
 * System.exit(0) : JVM 자체를 강제 종료 (프로그램 완전 종료)
 */
public class Control07 {

    public static void main(String[] args) {

        // ===============================
        // 1. break - 반복문 즉시 종료
        // ===============================
        /*
         * 주사위를 계속 굴려서 6이 나오면 반복을 멈춘다.
         * break 는 가장 가까운 반복문 하나만 종료한다.
         */

        System.out.println("[break 예제 - 주사위 6이 나올 때까지]");

        while (true) {
            int num = (int) (Math.random() * 6) + 1; // Control08 참고
            System.out.println(num);
            if (num == 6) {
                break;
            }

            System.out.println("6이 나와서 종료됩니다.");

            System.out.println("--------------------------------");

            // ===============================
            // 2. continue - 현재 반복만 건너뛰기
            // ===============================
            /*
             * 1부터 10까지 출력하되 짝수만 출력한다.
             * 홀수일 때 continue 를 만나면
             * 아래 코드를 실행하지 않고 바로 다음 반복으로 넘어간다.
             */

            System.out.println("[continue 예제 - 짝수만 출력]");

            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    continue; // 홀수면 건너뜀
                }
                System.out.print(i + " ");
            }

            System.out.println();
            System.out.println("--------------------------------");

            // ===============================
            // 3. break + continue 조합
            // ===============================
            /*
             * 1부터 1000까지 더하되
             * 5의 배수는 건너뛰고(continue)
             * 합계가 100 이상이 되면 중단한다(break).
             */

            System.out.println("[break + continue 조합]");

            int sum = 0;

            for (int i = 1; i <= 1000; i++) {
                if (i % 5 == 0) {
                    continue; // 5의 배수 건너뜀
                }
                sum += i;

                if (sum >= 100) {
                    System.out.println(i + " " + sum);
                    break;
                }
            }

            System.out.println("최종 합계: " + sum);

            System.out.println("--------------------------------");

            // ===============================
            // 4. 라벨(label) break - 중첩 반복문 탈출
            // ===============================
            /*
             * 중첩 반복문에서 break 는 가장 가까운 반복문만 종료한다.
             * 바깥 반복문까지 한 번에 종료하려면 라벨을 사용한다.
             * 라벨은 반복문 앞에 "이름:" 형태로 붙인다.
             *
             * 아래 예제는 대문자 A~Z, 소문자 a~z 를 조합 출력하다가
             * lower 가 'g' 가 되는 순간 바깥 for 문까지 종료한다.
             */

            System.out.println("[라벨 break - 중첩 반복문 탈출]");

            Outter:
            for (char upper = 'A'; upper <= 'Z'; upper++) {
                for (char lower = 'a'; lower <= 'z'; lower++) {
                    System.out.print(upper + "-" + lower + "  ");
                    if (lower == 'g') {
                        break Outter;   // Outter 라벨이 붙은 for 문까지 종료
                    }
                }
            }

            System.out.println();
            System.out.println("Outter 반복문까지 종료됨");

            System.out.println("--------------------------------");

            // ===============================
            // 5. break vs return vs System.exit() 비교
            // ===============================
            /*
             * break
             *   - 가장 가까운 반복문(또는 switch)만 종료
             *   - break 이후의 코드가 계속 실행됨
             *
             * return
             *   - 현재 메서드를 즉시 종료
             *   - main 메서드에서 return 하면 프로그램 종료
             *   - 메서드 안에서 return 하면 해당 메서드만 종료
             *
             * System.exit(0)
             *   - JVM 자체를 강제 종료
             *   - 어떤 위치에서 호출해도 즉시 프로그램 전체 종료
             *   - 0은 정상 종료, 그 외 숫자는 비정상 종료
             */

            System.out.println("[break vs return vs System.exit() 비교]");
            System.out.println("break   : 반복문 하나만 종료");
            System.out.println("return  : 현재 메서드 종료");
            System.out.println("exit(0) : JVM 전체 종료");

            while (true) {
                System.out.println("반복중");
                 break;
            }
            if(true) {
                return;
            }
            // return;
            // System.exit(0);
            System.out.println("코드 실행되나");
            System.out.println("--------------------------------");

        }

    }
}