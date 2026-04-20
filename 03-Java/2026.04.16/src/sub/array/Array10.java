package com.kb.d_chap05.s;

import java.util.Arrays;
import java.util.List;

/*
 * ===============================
 * Array10 - Arrays 유틸 메서드
 * ===============================
 *
 * java.util.Arrays 클래스
 * - 배열을 다루는 다양한 기능을 제공하는 유틸리티 클래스
 * - import java.util.Arrays; 를 선언해야 사용할 수 있다
 *
 * 주요 메서드
 * - toString()     : 1차원 배열을 문자열로 변환
 * - deepToString() : 다차원 배열을 문자열로 변환
 * - sort()         : 오름차순 정렬
 * - equals()       : 두 배열의 값이 같은지 비교
 * - fill()         : 모든 요소를 지정한 값으로 채우기
 * - copyOf()       : 지정한 길이만큼 배열 복사
 * - copyOfRange()  : 특정 범위만 복사
 * - asList()       : 배열을 List로 변환
 */
public class Array10 {
    public static void main(String[] args) {

        // ===============================
        // 1. Arrays.toString()
        // ===============================
        /*
         * 배열의 내용을 [값, 값, ...] 형태의 문자열로 변환한다
         * 배열을 바로 출력하면 주소값이 나오므로 이 메서드를 사용한다
         */
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("toString() : " + Arrays.toString(numbers));


        // ===============================
        // 2. Arrays.sort()
        // ===============================
        /*
         * 배열을 오름차순으로 정렬한다
         * 원본 배열이 직접 변경된다
         */
        int[] unsortedNumbers = {5, 3, 1, 4, 2};
        Arrays.sort(unsortedNumbers);
        System.out.println("sort() : " + Arrays.toString(unsortedNumbers));


        // ===============================
        // 3. Arrays.equals()
        // ===============================
        /*
         * 두 배열의 요소가 동일한지 비교한다
         * 배열 변수끼리 == 비교는 주소 비교이므로
         * 내용 비교는 equals() 를 사용한다
         */
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {4, 5, 6};

        System.out.println("equals(arr1, arr2) : " + Arrays.equals(arr1, arr2)); // true
        System.out.println("equals(arr1, arr3) : " + Arrays.equals(arr1, arr3)); // false


        // ===============================
        // 4. Arrays.fill()
        // ===============================
        /*
         * 배열의 모든 요소를 지정한 값으로 채운다
         * 초기화나 리셋할 때 유용하다
         */
        int[] filledNumbers = new int[5];
        Arrays.fill(filledNumbers, 9);
        System.out.println("fill() : " + Arrays.toString(filledNumbers));


        // ===============================
        // 5. Arrays.copyOf()
        // ===============================
        /*
         * 배열을 복사하여 새 배열을 생성한다
         * 지정한 길이가 원본보다 크면 나머지는 기본값으로 채워진다
         * 원본과 독립된 새 배열이다 (깊은 복사)
         */
        int[] original = {1, 2, 3};
        int[] copy = Arrays.copyOf(original, 5); // 길이 5로 복사
        System.out.println("copyOf() : " + Arrays.toString(copy)); // [1, 2, 3, 0, 0]


        // ===============================
        // 6. Arrays.copyOfRange()
        // ===============================
        /*
         * 배열의 특정 범위만 복사하여 새 배열을 생성한다
         * 끝 인덱스는 포함하지 않는다 (시작 포함, 끝 미포함)
         */
        int[] rangeCopy = Arrays.copyOfRange(numbers, 1, 4); // 인덱스 1~3 복사
        System.out.println("copyOfRange() : " + Arrays.toString(rangeCopy));


        // ===============================
        // 7. Arrays.asList()
        // ===============================
        /*
         * 배열을 List로 변환한다
         * 반환된 List의 크기는 변경할 수 없다 (add, remove 불가)
         * 요소의 값 변경은 가능하다
         */
        String[] fruits = {"apple", "banana", "cherry"};
        List<String> fruitList = Arrays.asList(fruits);
        System.out.println("asList() : " + fruitList);


        // ===============================
        // 8. Arrays.deepToString()
        // ===============================
        /*
         * 다차원 배열을 문자열로 변환한다
         * 2차원 이상의 배열에는 toString() 대신 이 메서드를 사용한다
         */
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println("deepToString() : " + Arrays.deepToString(matrix));
    }
}
