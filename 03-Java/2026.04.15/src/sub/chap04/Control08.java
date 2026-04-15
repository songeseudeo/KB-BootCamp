package sub.chap04;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * ===============================
 * 난수 생성
 * ===============================
 *
 * 난수(Random Number)란 규칙 없이 무작위로 만들어지는 수다.
 * Java 에서 난수를 생성하는 방법은 크게 세 가지다.
 *
 * 1. Math.random()         - 0.0 이상 1.0 미만의 실수 반환, 가장 기본적인 방법
 * 2. Random                - 정수 난수 생성, 학습용
 * 3. ThreadLocalRandom     - 실무 및 코딩 테스트 권장
 *
 * 원하는 범위의 정수 난수를 구하는 공식 (공통)
 * 최솟값 이상 최댓값 이하의 난수
 * → (int)(Math.random() * 개수) + 최솟값
 * → random.nextInt(개수) + 최솟값
 *
 * 개수 = 최댓값 - 최솟값 + 1
 */
public class Control08 {

    public static void main(String[] args) {

        // ===============================
        // 1. Math.random()
        // ===============================
        /*
         * 0.0 이상 1.0 미만의 double 난수를 반환한다.
         * 정수로 변환하려면 원하는 범위만큼 곱하고 (int) 로 형변환한다.
         *
         * 공식: (int)(Math.random() * 개수) + 최솟값
         */

        System.out.println("[Math.random()]");

        // 0~9 난수
        int a = (int) (Math.random() * 10);
        System.out.println("0~9: " + a);

        // 1~10 난수 (개수 10, 최솟값 1)
        int b = (int) (Math.random() * 10) + 1;
        System.out.println("1~10: " + b);

        // 1~6 난수 (주사위)
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("주사위(1~6): " + dice);

        // 10~15 난수 (개수 6, 최솟값 10)
        int c = (int) (Math.random() * 6) + 10;
        System.out.println("10~15: " + c);

        // -128~127 난수 (개수 256, 최솟값 -128)
        int d = (int) (Math.random() * 256) - 128;
        System.out.println("-128~127: " + d);

        System.out.println("--------------------------------");

        // ===============================
        // 2. Random 클래스
        // ===============================
        /*
         * java.util.Random 클래스를 사용한다.
         * nextInt(n) : 0 이상 n 미만의 정수 반환
         *
         * 공식: random.nextInt(개수) + 최솟값
         */

        System.out.println("[Random 클래스]");

        Random rand = new Random();

        // 0~9 난수
        int r1 = rand.nextInt(10);
        System.out.println("0~9: " + r1);

        // 1~10 난수 (개수 10, 최솟값 1)
        int r2 = rand.nextInt(10) + 1;
        System.out.println("1~10: " + r2);

        // 20~45 난수 (개수 26, 최솟값 20)
        int r3 = rand.nextInt(26) + 20;
        System.out.println("20~45: " + r3);

        // -128~127 난수 (개수 256, 최솟값 -128)
        int r4 = rand.nextInt(256) - 128;
        System.out.println("-128~127: " + r4);

        System.out.println("--------------------------------");

        // ===============================
        // 3. Random.nextInt(origin, bound) - Java 17+
        // ===============================
        /*
         * nextInt(최솟값, 최댓값 + 1) 형태로
         * 범위를 직접 지정할 수 있어 가독성이 좋다.
         * origin 이상 bound 미만의 정수를 반환한다.
         */

        System.out.println("[Random - Java 17+ 범위 지정]");

        int r5 = rand.nextInt(1, 11);      // 1 이상 11 미만 → 1~10
        int r6 = rand.nextInt(20, 46);     // 20 이상 46 미만 → 20~45
        int r7 = rand.nextInt(-128, 128);  // -128 이상 128 미만 → -128~127

        System.out.println("1~10: " + r5);
        System.out.println("20~45: " + r6);
        System.out.println("-128~127: " + r7);

        System.out.println("--------------------------------");

        // ===============================
        // 4. ThreadLocalRandom
        // ===============================
        /*
         * 객체 생성 없이 바로 사용한다.
         * nextInt(최솟값, 최댓값 + 1) 형태로 범위를 직접 지정한다.
         * 멀티스레드 환경에서도 안전하게 동작한다.
         */

        System.out.println("[ThreadLocalRandom - 권장]");

        int t1 = ThreadLocalRandom.current().nextInt(1, 11);    // 1~10
        int t2 = ThreadLocalRandom.current().nextInt(20, 46);   // 20~45
        int t3 = ThreadLocalRandom.current().nextInt(-128, 128);// -128~127

        System.out.println("1~10: " + t1);
        System.out.println("20~45: " + t2);
        System.out.println("-128~127: " + t3);

        System.out.println("--------------------------------");

        // ===============================
        // 5. 방법별 비교 요약
        // ===============================
        /*
         * Math.random()
         *   - 반환 타입: double (0.0 이상 1.0 미만)
         *   - 정수 변환 시 (int) 캐스팅과 공식 필요
         *   - 기초 학습, 개념 이해에 적합
         *
         * Random.nextInt(n)
         *   - 객체 생성 필요 (new Random())
         *   - 단일 스레드, 학습용
         *
         * Random.nextInt(min, max) (Java 17+)
         *   - 가장 직관적인 범위 지정
         *
         * ThreadLocalRandom
         *   - 객체 생성 불필요
         *   - 멀티스레드 환경에서 안전
         */


    }
}