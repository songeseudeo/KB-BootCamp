package sub.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

/*

 *  집계(Aggregate)란?
 *  - 여러 데이터를 하나의 결과로 계산하는 최종 처리

 * ============================================================
 *
 * count()     -> 개수 (long)
 * sum()       -> 합계 (int, long 등)
 * average()   -> 평균 (OptionalDouble)
 * max()       -> 최대값 (Optional)
 * min()       -> 최소값 (Optional)
 * findFirst() -> 첫 번째 요소 (Optional)
 */
/*
 * ============================================================
 * Optional 처리 방법
 * ============================================================
 * Optional은 "값이 있을 수도 있고, 없을 수도 있는 결과"를 안전하게 다루기 위한 객체다.
 * ------------------------------------------------------------
 *  - 값이 있는지 직접 나눠 처리하고 싶다 -> isPresent()
 *  - 값이 없을 때 기본값을 주고 싶다 -> orElse()
 *  - 값이 있을 때만 실행하고 싶다 -> ifPresent()
 */

public class StreamAggregatePractice6_s {

    public static void main(String[] args) {
        aggregate();
        optional();
    }

    // ============================================================
    // 1. 집계 (최종 처리)
    // ============================================================
    public static void aggregate() {
        System.out.println("==== 집계 ====");

        int[] arr = {1, 2, 3, 4, 5};

        /*
         * count()
         *  - 조건에 맞는 요소 개수 반환
         *  - 반환 타입: long
         */
        long count = Arrays.stream(arr)
                .filter(n -> n % 2 == 0) // 2의 배수만
                .count();                // 개수 계산
        System.out.println("2의 배수 개수: " + count);

        /*
         * sum()
         *  - 합계 계산
         */
        int sum = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("2의 배수 합: " + sum);

        /*
         * average()
         *  - 평균 계산
         *  - 반환 타입: OptionalDouble
         *
         * orElse(0.0)
         *  - 값이 없으면 0.0 반환
         */
        double avg = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .average()
                .orElse(0.0);
        System.out.println("2의 배수 평균: " + avg);

        /*
         * max()
         *  - 최대값
         *  - 반환: OptionalInt
         */
        int max = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .max()
                .orElse(0); // 없으면 0
        System.out.println("최대값: " + max);

        /*
         * min()
         *  - 최소값
         */
        int min = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .min()
                .orElse(0);
        System.out.println("최소값: " + min);

        /*
         * findFirst()
         *  - 조건에 맞는 첫 번째 요소
         *  - 반환: Optional
         */
        int first = Arrays.stream(arr)
                .filter(n -> n % 3 == 0) // 3의 배수
                .findFirst()
                .orElse(0);
        System.out.println("첫 번째 3의 배수: " + first);

        /*
         * 집계 = 여러 값을 하나로 만드는 최종 처리
         */
        System.out.println();
    }

    // ============================================================
    // 2. Optional 처리
    // ============================================================
    public static void optional() {
        System.out.println("==== Optional 처리 ====");

        List<Integer> list = new ArrayList<>(); // 비어있는 리스트

        /*
         * average() 결과는 OptionalDouble
         * 이유: 값이 없을 수도 있기 때문
         */
        OptionalDouble optional = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        // ------------------------------------------------------------
        // 방법 1: isPresent() + get()
        // ------------------------------------------------------------
        if (optional.isPresent()) {// 값이 있으면
            System.out.println("방법1_평균: " + optional.getAsDouble());
        } else {
            System.out.println("방법1_평균: 0.0");
        }

        // ------------------------------------------------------------
        // 방법 2: orElse()
        // ------------------------------------------------------------
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0); // 값 없으면 기본값
        System.out.println("방법2_평균: " + avg);


        // ------------------------------------------------------------
        // 방법 3: ifPresent()
        // ------------------------------------------------------------
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("방법3_평균: " + a));

        /*
         * 값이 있을 때만 실행
         * 없으면 아무것도 안 함 그래서 출력안됨
         */

        System.out.println();

        // ------------------------------------------------------------
        // 방법 4: map() + orElseThrow() list.add(10) 해서있을때 없을때 실행확인
        // ------------------------------------------------------------
        list.add(10);
        list.add(20);
        try {
            int value = list.stream()
                    .findFirst()   // Optional<Integer>
                    .map(v -> v * 10)  // 값이 있으면 변환
                    .orElseThrow(() -> new IllegalArgumentException("값이 없습니다."));

            System.out.println("방법4_값: " + value);
        } catch (Exception e) {
            System.out.println("방법4_예외: " + e.getMessage());
        }
        /*
         * map() + orElseThrow()

         * 1. findFirst()
         *    -> Optional<Integer>

         * 2. map()
         *    -> 값이 있으면 변환
         *    -> 없으면 아무 것도 안 함 (Optional 유지)
         * 3. orElseThrow()
         *    -> 값이 없으면 예외 발생

         */
    }
}