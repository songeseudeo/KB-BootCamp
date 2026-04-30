package sub.stream;

import stream.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * ============================================================
 * reduce + collect
 * ============================================================
 *
 *  reduce()
 *  - 스트림 요소를 하나씩 줄여가며 하나의 결과를 만든다.
 *  - "사용자 정의 집계"에 사용
 *
 * 예)
 *  합계, 곱셈, 문자열 연결 등
 *
 *  collect()
 *  - 스트림 요소를 모아서 컬렉션(List, Map 등)으로 만든다.
 *
 * ============================================================
 *  collect 주요 메소드
 * ============================================================
 *
 * toList()        -> List로 수집
 * toMap()         -> Map으로 수집
 * groupingBy()    -> 그룹화
 * averagingDouble() -> 평균 계산
 */

public class StreamReductCollectPractice7_s {

    public static void main(String[] args) {
        reduction();
        collectToListAndMap();
        grouping();
        groupingWithAverage();
    }

    // ============================================================
    // 1. reduce()
    // ============================================================
    public static void reduction() {
        System.out.println("==== reduce() ====");

        List<Student> students = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 95),
                new Student("감자바", 88)
        );

        /*
         * 방법 1: mapToInt + sum()
         *  - 가장 간단하고 많이 사용
         *  - 내부적으로 최적화됨
         */
        int sum1 = students.stream()
                .mapToInt(Student::getScore) // 객체 -> int
                .sum();                     // 합계

        /*
         * 방법 2: reduce()
         *
         * reduce(초기값, 누적함수)
         * 0 -> 초기값
         * Integer::sum -> 누적 방식
         * (((0 + 92) + 95) + 88)
         */
        int sum2 = students.stream()
                .map(Student::getScore)     // Stream<Integer>
                .reduce(0, Integer::sum);   // 누적

        System.out.println("mapToInt().sum(): " + sum1);
        System.out.println("reduce(): " + sum2);

        /*
         * reduce = 직접 집계 정의
         * sum() = 이미 만들어진 집계
         */
        System.out.println();
    }

    // ============================================================
    // 2. collect -> List / Map
    // ============================================================
    public static void collectToListAndMap() {
        System.out.println("==== collect: toList / toMap ====");

        List<Student> totalList = createStudentList();

        /*
         * filter + toList()
         *  - 조건에 맞는 요소를 List로 수집
         */
        List<Student> maleList = totalList.stream()
                .filter(s -> s.getSex().equals("남")) // 남자만
                .toList();                           // List로 변환

        maleList.forEach(s -> System.out.println(s.getName()));
        System.out.println();

        /*
         * toMap()
         * key: Student::getName
         * value: Student::getScore
         *
         * 결과:
         * {이름=점수}
         */
        Map<String, Integer> map = totalList.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Student::getScore
                ));

        System.out.println(map);

        /*
         * collect = 데이터를 "모아서 구조화"
         */
        System.out.println();
    }

    // ============================================================
    // 3. groupingBy()
    // ============================================================
    public static void grouping() {
        System.out.println("==== groupingBy() ====");

        List<Student> totalList = createStudentList();

        /*
         * groupingBy(기준)
         *
         * 성별 기준으로 그룹 나누기
         *
         * 결과:
         * Map<성별, List<Student>>
         */
        Map<String, List<Student>> map = totalList.stream()
                .collect(Collectors.groupingBy(Student::getSex));

        System.out.println("[남]");
        map.get("남").forEach(s -> System.out.println(s.getName()));

        System.out.println("[여]");
        map.get("여").forEach(s -> System.out.println(s.getName()));

        /*

         * groupingBy = 데이터를 "분류"
         */
        System.out.println();
    }

    // ============================================================
    // 4. grouping + 평균
    // ============================================================
    public static void groupingWithAverage() {
        System.out.println("==== groupingBy() + averagingDouble() ====");

        List<Student> totalList = createStudentList();

        /*
         * groupingBy + averagingDouble
         *
         * 성별별 평균 점수 계산
         *
         * 결과:
         * Map<성별, 평균점수>
         */
        Map<String, Double> map = totalList.stream()
                .collect(Collectors.groupingBy(
                        Student::getSex,                         // 그룹 기준
                        Collectors.averagingDouble(Student::getScore) // 평균 계산
                ));

        System.out.println(map);

        /*
         * grouping + 집계
         */
        System.out.println();
    }

    // ============================================================
    // 데이터 생성
    // ============================================================
    private static List<Student> createStudentList() {
        List<Student> totalList = new ArrayList<>();

        totalList.add(new Student("홍길동", 92, "남"));
        totalList.add(new Student("김수영", 87, "여"));
        totalList.add(new Student("감자바", 95, "남"));
        totalList.add(new Student("오해영", 93, "여"));

        return totalList;
    }
}