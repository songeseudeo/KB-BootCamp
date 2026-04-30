package sub.stream;

import stream.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * ============================================================
 *  정렬 + 매칭 + 루핑
 * ============================================================

 * ============================================================
 * 정렬(sorted)
 * ============================================================
 *
 * sorted()
 *  - 스트림 요소를 정렬하는 중간 처리 메소드
 *  - 정렬된 새 스트림을 반환한다.
 *  - 원본 List 자체의 순서는 변경되지 않는다.
 *
 * 정렬 방법
 *  1. Comparator.comparingInt()
 *      - int 값을 기준으로 정렬할 때 사용
 *
 *  2. 람다식 Comparator
 *      - 직접 정렬 기준을 작성할 때 사용
 *
 * ============================================================
 * 매칭(Matching)
 * ============================================================
 *
 * 매칭이란?
 *  - 스트림 요소들이 특정 조건을 만족하는지 검사하는 최종 처리
 *  - 결과는 boolean 값이다.
 *
 * allMatch()
 *  - 모든 요소가 조건을 만족하면 true
 *
 * anyMatch()
 *  - 하나라도 조건을 만족하면 true
 *
 * noneMatch()
 *  - 조건을 만족하는 요소가 하나도 없으면 true
 *
 * ============================================================
 * 루핑(Looping)
 * ============================================================
 *
 * peek()
 *  - 중간 처리 메소드
 *  - 요소를 소비하지 않고 중간 값을 확인할 때 사용
 *  - 반드시 뒤에 최종 처리가 있어야 실행된다.
 *
 * forEach()
 *  - 최종 처리 메소드
 *  - 요소를 하나씩 소비하면서 처리한다.
 *  - forEach() 이후에는 스트림을 더 이상 이어서 사용할 수 없다.
 */

public class StreamMatchingPractice5_s {

    public static void main(String[] args) {
        sorting();
        matching();
        looping();
    }

    // ============================================================
    // 1. 정렬 sorted()
    // ============================================================
    public static void sorting() {
        System.out.println("==== 정렬 ====");

        /*
         * 같은 패키지의 Student 클래스 사용
         *
         * Student(String name, int score)
         *  - name, score만 받는 생성자
         *  - sex는 사용하지 않음
         */
        List<Student> students = new ArrayList<>();
        students.add(new Student("홍길동", 30));
        students.add(new Student("신용권", 10));
        students.add(new Student("유미선", 20));

        /*
         * 오름차순 정렬
         *
         * Comparator.comparingInt(Student::getScore)
         *  - Student 객체에서 score 값을 꺼내
         *    그 점수를 기준으로 오름차순 정렬한다.
         *
         * 결과:
         *  10 -> 20 -> 30
         */
        System.out.println("[오름차순]");
        students.stream()
                .sorted(Comparator.comparingInt(Student::getScore)) // score 기준 오름차순
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

        /*
         * 내림차순 정렬
         *
         * Integer.compare(s2.getScore(), s1.getScore())
         *  - s2와 s1의 순서를 바꾸어 비교하면 내림차순이 된다.
         *
         * 결과:
         *  30 -> 20 -> 10
         */
        System.out.println("[내림차순]");
        students.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

        /*
         * sorted()는 원본 students의 순서를 바꾸지 않는다.
         * 정렬된 결과 스트림을 새로 만들어 반환한다.
         */
        System.out.println();
    }

    // ============================================================
    // 2. 매칭 allMatch / anyMatch / noneMatch
    // ============================================================
    public static void matching() {
        System.out.println("==== 매칭 ====");

        int[] intArr = {2, 4, 6};

        /*
         * allMatch()
         *  - 모든 요소가 조건을 만족하는지 검사
         *
         * 조건:
         *  a % 2 == 0
         *
         * 의미:
         *  모든 숫자가 2의 배수인가?
         */
        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a % 2 == 0);
        System.out.println("모두 2의 배수인가? " + result);

        /*
         * anyMatch()
         *  - 하나라도 조건을 만족하는지 검사
         *
         * 조건:
         *  a % 3 == 0
         *
         * 의미:
         *  3의 배수가 하나라도 있는가?
         */
        result = Arrays.stream(intArr)
                .anyMatch(a -> a % 3 == 0);
        System.out.println("하나라도 3의 배수가 있는가? " + result);

        /*
         * noneMatch()
         *  - 조건을 만족하는 요소가 하나도 없는지 검사
         *
         * 조건:
         *  a % 3 == 0
         *
         * 의미:
         *  3의 배수가 없는가?
         */
        result = Arrays.stream(intArr)
                .noneMatch(a -> a % 3 == 0);
        System.out.println("3의 배수가 없는가? " + result);

        System.out.println();
    }

    // ============================================================
    // 3. 루핑 peek / forEach
    // ============================================================
    public static void looping() {
        System.out.println("==== 루핑 ====");

        int[] intArr = {1, 2, 3, 4, 5};

        /*
         * peek()
         *  - 중간 처리
         *  - 현재 스트림에 흐르는 값을 중간에서 확인할 때 사용
         *
         * 주의:
         *  peek()만 있으면 실행되지 않는다.
         *  sum() 같은 최종 처리가 있어야 실행된다.
         */
        System.out.println("[peek() + sum()]");
        int total = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)       // 2, 4만 통과
                .peek(System.out::println)     // 중간 값 확인
                .sum();                        // 최종 처리: 합계 계산
        System.out.println("총합: " + total);

        /*
         * forEach()
         *  - 최종 처리
         *  - 각 요소를 하나씩 꺼내서 처리
         *
         * forEach()는 스트림을 소비한다.
         * 그래서 forEach() 뒤에는 sum(), filter() 등을 이어서 사용할 수 없다.
         */
        System.out.println("[forEach()]");
        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)       // 2, 4만 통과
                .forEach(System.out::println); // 최종 처리: 출력

        System.out.println();
    }
}