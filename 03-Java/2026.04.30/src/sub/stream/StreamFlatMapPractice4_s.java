package sub.stream;

import java.util.Arrays;
import java.util.List;


public class StreamFlatMapPractice4_s {

    public static void main(String[] args) {
        mapExample();
        flatMapExample();
        flatMapToIntExample();
    }

    // ============================================================
    // map() : 데이터를 다른 형태로 변환할 때 사용한다.
    // ============================================================
    public static void mapExample() {
        System.out.println("==== map() ====");

        List<String> sentences = Arrays.asList(
                "this is java",
                "i am developer"
        );

        /*
         * map()
         * sentence -> sentence.split(" ")
         *
         * 결과:
         *  "this is java" -> ["this", "is", "java"]
         *  "i am developer" -> ["i", "am", "developer"]
         *
         * 즉, 결과 타입:
         *  Stream<String[]>
         *  배열이 그대로 유지됨 (중첩 구조)
         */
        sentences.stream()
                .map(sentence -> sentence.split(" "))  // String -> String[]
                .forEach(arr -> System.out.println(Arrays.toString(arr)));


        System.out.println();
    }

    // ============================================================
    // flatMap() 중첩된 데이터를 하나의 스트림으로 펼칠 때 사용한다.
    // ============================================================
    public static void flatMapExample() {
        System.out.println("==== flatMap() ====");

        List<String> sentences = Arrays.asList(
                "this is java",
                "i am developer"
        );
        /*
         * flatMap()
         *
         * 1. sentence.split(" ") -> String[]
         * 2. Arrays.stream(...) -> Stream<String>
         * 3. flatMap이 모든 스트림을 하나로 합침
         *
         * 결과:
         *  ["this", "is", "java"]
         *  ["i", "am", "developer"]
         *
         * -> 하나로 펼쳐짐
         *  Stream<String>
         */
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .forEach(System.out::print);

        System.out.println();
    }

    // ============================================================
    // /flatMapToInt() : 여러 값을 하나의 숫자 스트림으로 만들어 집계(sum, average 등)를 가능하게 한다.
    // ============================================================
    public static void flatMapToIntExample() {
        System.out.println("==== flatMapToInt() ====");

        List<String> numbers = Arrays.asList(
                "10,20,30",
                "40,50"
        );

        /*
         * flatMapToInt()
         * 흐름:
         *
         * 1. "10,20,30" -> split(",")
         *      -> ["10","20","30"]
         * 2. mapToInt -> int 변환
         *      -> [10, 20, 30]
         * 3. 여러 배열을 하나로 합침
         * 결과:
         *  IntStream -> 10, 20, 30, 40, 50
         */
        numbers.stream()
                .flatMapToInt(data ->
                        Arrays.stream(data.split(","))
                                .mapToInt(num -> Integer.parseInt(num.trim()))
                )
                .forEach(System.out::print);


    }
}