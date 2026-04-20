package sub.array;

import java.util.Arrays;
import java.util.Collections;

/*
 * ===============================

 * 1. 값 교환 (Swap)
 * 2. 최소값 / 최대값 탐색
 * 3. 최대값 위치(인덱스) 찾기
 * 4. 오름차순 정렬 (Arrays.sort)
 * 5. 내림차순 정렬 (직접 구현)
 */
public class Array07 {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;

        System.out.println(num1 + " " + num2);

        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println(num1 + " " + num2);

        int[] arr = {2, 1, 3};

        int temp1 = arr[0];
        arr[0] = arr[1];
        arr[1] = temp1;

        System.out.println(Arrays.toString(arr));

        // 최소값
        int[] numbers = {55, 22, 11, 99, 33};

        int min = numbers[0];

        for(int i=1; i<numbers.length; i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        System.out.println("min: " + min);

        // 최대값
        int max = numbers[0];

        for(int i=1; i < numbers.length; i++){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        System.out.println("max: " + max);

        //최대값의 인덱스 위치
        for(int i=1; i < numbers.length; i++) {
            if (numbers[i] == max) {
                System.out.println(i);
            }
        }

        //Arrays.sort() -> java.util.*; import 해서 사용
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

// ===============================
// 7. 내림차순 정렬 (직접 구현)
// ===============================
/*
 * 기본형 배열(int[])은 Arrays.sort()로 오름차순만 지원한다
 * 내림차순이 필요하면 오름차순 정렬 후 배열을 직접 뒤집는다
 *
 * 오름차순 정렬을 먼저 해야 하는 이유:
 * 뒤집기는 배열의 순서만 반대로 바꾸는 작업이다
 * 정렬되지 않은 상태에서 뒤집으면 내림차순이 되지 않는다
 *
 * 예) [4, 2, 3, 1] 을 바로 뒤집으면 → [1, 3, 2, 4]  (내림차순 아님)
 *     [4, 2, 3, 1] 을 sort 후 뒤집으면
 *     → Arrays.sort() → [1, 2, 3, 4]
 *     → 뒤집기 → [4, 3, 2, 1]  (내림차순 완성)
 *
 * 반드시 Arrays.sort() 먼저 → 뒤집기 순서로 진행해야 한다
 *
 * [뒤집기 원리 - 투 포인터 (Two Pointer)]
 * 배열의 양 끝에 포인터(인덱스)를 두고 서로 좁혀오면서 교환하는 방식이다
 * 앞 포인터(i) 와 뒤 포인터(length-1-i) 가 가운데에서 만나면 종료된다
 * 배열 전체를 순회하지 않고 절반만 순회하면 되므로 효율적이다
 *
 * 예) [1, 2, 3, 4, 5]
 *
 *  i=0 : sortTarget[0] ↔ sortTarget[4]   (1 ↔ 5)
 *  i=1 : sortTarget[1] ↔ sortTarget[3]   (2 ↔ 4)
 *  i=2 : 앞뒤 포인터가 가운데(3)에서 만남 → 종료
 *
 * length / 2 번만 반복하면 앞뒤가 모두 교환된다
 * (가운데 요소는 건드릴 필요가 없기 때문이다)
 *
 * [temp 를 사용하는 이유]
 * sortTarget[i] = sortTarget[length-1-i] 처럼 바로 덮어쓰면
 * 원래 값이 사라져버린다
 * temp 에 먼저 백업해두고 교환해야 값이 보존된다
 *
 *  temp2                  = sortTarget[i]            // 앞쪽 값 백업
 *  sortTarget[i]          = sortTarget[length-1-i]   // 뒤쪽 값을 앞으로
 *  sortTarget[length-1-i] = temp2                    // 백업한 값을 뒤로
 */
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp2 = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp2;
        }
        System.out.println(Arrays.toString(numbers));

        // ===============================
        // 7. 내림차순 정렬 (컬렉션 사용)
        // ===============================
        /*
         * Integer[] (래퍼 타입) 로 선언하면
         * Collections.sort() 에 전달해서
         * 내림차순을 한 번에 처리할 수 있다
         *
         * int[] (기본형) 는 Collections.sort() 사용 불가
         * → Integer[] 로 선언하거나 Arrays.stream() 으로 변환해야 한다
         *
         * Collections.reverseOrder() 는 Java 가 기본 제공
         */
        int[] sortTarget2 = {1, 2, 3, 4};

        // 반복문으로 int[] → Integer[] 직접 변환
        Integer[] boxed = new Integer[sortTarget2.length];
        for (int i = 0; i < sortTarget2.length; i++) {
            boxed[i] = sortTarget2[i];  // int → Integer 자동 박싱(Auto Boxing)
        }

        // Integer[] 에 reverseOrder() 적용
        Arrays.sort(boxed, Collections.reverseOrder());

        System.out.println("내림차순 정렬 : " + Arrays.toString(boxed));
        // 내림차순 정렬 : [4, 3, 2, 1]
    }
}