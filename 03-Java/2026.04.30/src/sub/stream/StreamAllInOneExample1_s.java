package sub.stream;


import stream.Student;

import java.util.Arrays;
import java.util.List;

public class StreamAllInOneExample1_s {

    /*
     * ============================================
     * 스트림(Stream)
     * ============================================
     *
     * 스트림이란?
     *  - 컬렉션, 배열 등의 데이터를 하나씩 꺼내 처리하는 흐름이다.
     *  - 내부적으로 반복 처리한다. (for문을 직접 쓰지 않음)
     *
     * ============================================
     * 스트림 처리 3단계
     * ============================================
     *
     * 1. 스트림 얻기
     *    - list.stream()
     *
     * 2. 중간 처리 (0개 이상)
     *    - filter(), map(), mapToInt(), distinct() 등
     *    - 새로운 스트림을 반환
     *
     * 3. 최종 처리 (반드시 필요)
     *    - forEach(), count(), sum(), average() 등
     *    - 이때 실제 실행됨
     *
     * ============================================
     * 지연 실행 (Lazy Evaluation)
     * ============================================
     *
     * 중간 처리는 바로 실행되지 않는다.
     * 최종 처리 호출 시 실행된다.
     *
     * ============================================
     * 스트림 특징
     * ============================================
     *
     * 1. 원본 데이터 변경 없음
     * 2. 스트림은 1회용
     * 3. 내부 반복
     *
     * ============================================
     * 스트림 파이프라인
     * ============================================
     *
     * stream()
     *   .중간처리()
     *   .최종처리()
     */

    static List<String> names = Arrays.asList(
            "홍길동", "신용권", "감자바", "신용권", "신민철"
    );

    static List<Student> students = Arrays.asList(
            new Student("홍길동", 10),
            new Student("신용권", 20),
            new Student("유미선", 30)
    );

    public static void main(String[] args) {

        System.out.println("==== 기본 ====");
        names.stream()                         // 스트림 얻기
                .forEach(System.out::println); // 최종 처리 (출력)


        System.out.println("\n==== 필터링 ====");
        names.stream()
                .distinct()                   // 중복 제거 (중간 처리)
                .filter(n -> n.startsWith("신")) // 조건 필터링
                .forEach(System.out::println); // 최종 실행


        System.out.println("\n==== 매핑 ====");
        students.stream()
                .mapToInt(Student::getScore)  // 객체 -> int 변환 (IntStream)
                .forEach(score -> System.out.println(score)); // 점수 출력


        System.out.println("\n==== 집계 ====");
        int[] arr = {1, 2, 3, 4, 5};

        long count = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)     // 짝수 필터
                .count();                    // 개수 계산

        int sum = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .sum();                      // 합 계산

        double avg = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .average()                  // 평균 계산 (Optional)
                .orElse(0.0);               // 값 없으면 0.0

        System.out.println("개수: " + count);
        System.out.println("합: " + sum);
        System.out.println("평균: " + avg);


        System.out.println("\n==== 파이프라인 ====");
        double result = students.stream()          // 스트림 생성
                .mapToInt(Student::getScore)      // 점수 추출
                .average()                        // 평균 계산
                .orElse(0.0);                     // 기본값 처리

        System.out.println("평균 점수: " + result);


        System.out.println("\n==== asDoubleStream / boxed ====");
        int[] intArray = {1, 2, 3, 4, 5};

        Arrays.stream(intArray)
                .asDoubleStream()                 // int -> double 변환
                .forEach(System.out::println);

        Arrays.stream(intArray)
                .boxed()                          // int -> Integer 객체
                .forEach(System.out::println);
    }
}