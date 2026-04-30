package sub.stream;

import java.util.Arrays;
import java.util.List;


 /* ============================================================
 *  순차 스트림 vs 병렬 스트림
 * ============================================================
 *
 * 순차 스트림 (stream)
 *  - 한 개의 스레드에서 순서대로 처리
 *
 * 병렬 스트림 (parallelStream)
 *  - 여러 스레드에서 동시에 처리
 */

public class ParallelStreamPractice_s {

    public static void main(String[] args) {

        sequentialStream();
        parallelStream();
        performanceTest();
    }

    // ============================================================
    // 1. 순차 스트림
    // ============================================================
    public static void sequentialStream() {
        System.out.println("==== 순차 스트림 ====");

        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        list.stream()
                .forEach(data -> {
                    System.out.println(
                            data + " : " + Thread.currentThread().getName()
                    );
                });

        /*
         * 결과:
         *  main 스레드 하나에서 순차적으로 실행됨
         */

        System.out.println();
    }

    // ============================================================
    // 2. 병렬 스트림
    // ============================================================
    public static void parallelStream() {
        System.out.println("==== 병렬 스트림 ====");

        List<String> list = Arrays.asList("A", "B", "C", "D", "E");
//        forEach() 는 순차 스트림에서는 순서대로 처리되지만, parallelStream() 으로
//        만든 병렬 스트림에서는 처리 순서가 보장되지 않는다. 순서가 꼭 필요하다면
//        forEachOrdered() 를 사용한다.
        list.parallelStream()
                .forEach(data -> {

//                .forEachOrdered(data -> {
                    System.out.println(
                            data + " : " + Thread.currentThread().getName()
                    );
                });

        /*
         * 결과:
         *  여러 스레드에서 동시에 실행됨
         */

        System.out.println();
    }

    // ============================================================
    // 3. 성능 비교
    // ============================================================
    public static void performanceTest() {
        System.out.println("==== 성능 비교 ====");

        int[] arr = new int[1_000_000_000];// 병렬이빠름 10억개
        //int[] arr = new int[1_000_000];// 순차가빠름 100만개

        // 배열 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // ---------------- 순차 처리 ----------------
        long start = System.currentTimeMillis();
        long nanoStart = System.nanoTime();

        int sum1 = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .sum();

        long end = System.currentTimeMillis();
        long nanoEnd = System.nanoTime();

        System.out.println("순차 처리 시간: " + (end - start));
        System.out.println("병렬 처리 시간(ns): " + (nanoEnd - nanoStart));
        System.out.println("병렬 처리 시간(ms): " + (nanoEnd - nanoStart) / 1_000_000.0);

        System.out.println("병렬 처리 시간(초): " + (nanoEnd - nanoStart) / 1_000_000_000.0);//10억으로
        // ---------------- 병렬 처리 ----------------
        start = System.currentTimeMillis();
        // ---------------- nanoTime 성능 측정 ----------------
        long nanoStart2 = System.nanoTime();
        int sum2 = Arrays.stream(arr)
                .parallel()   // 병렬 처리
                .filter(n -> n % 2 == 0)
                .sum();

        end = System.currentTimeMillis();

        long nanoEnd2 = System.nanoTime();
        System.out.println("병렬 처리 시간: " + (end - start));

        System.out.println("병렬 처리 시간(ns): " + (nanoEnd2 - nanoStart2));
//        ns -> ms : 100만으로 나눈다
//        ns -> 초 : 10억으로 나눈다
        System.out.println("병렬 처리 시간(ms): " + (nanoEnd2 - nanoStart2) / 1_000_000.0);

        System.out.println("병렬 처리 시간(초): " + (nanoEnd2 - nanoStart2) / 1_000_000_000.0);
        /*
         *  - 데이터가 많을수록 병렬이 유리
         *  - 작은 데이터에서는 오히려 느릴 수 있음
         */

//        시간 찍을 때 -> currentTimeMillis
//        속도 측정할 때 -> nanoTime

    }
}