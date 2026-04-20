package sub.array;

/*
 * ===============================
 * Array05 - for-each
 * ===============================
 *
 * for문이란?
 * - 배열의 항목을 처음부터 끝까지 순서대로 꺼내주는 반복문
 * - 인덱스 없이 값만 필요할 때 사용한다
 *
 * 기본 for문과 비교
 * - 기본 for문  : 인덱스 직접 제어 가능, 특정 위치 접근 가능
 * - for-each문 : 코드가 간결함, 인덱스 사용 불가, 값 수정 불가
 *
 * 사용 형식
 * for (자료형 변수명 : 배열명) { ... }
 */
public class Array05 {
    public static void main(String[] args) {

        // ===============================
        // 1. for-each 문 기본 사용
        // ===============================
        int[] scores = {95, 71, 84, 93, 87};

        // 배열의 값을 처음부터 끝까지 하나씩 score 변수에 담아 반복
        int sum = 0;
        // 구현
        for (int score : scores) {
            sum += score;
        }

        double avg = (double) sum / scores.length;
        System.out.println("점수 총합 : " + sum);
        System.out.println("점수 평균 : " + avg);


        // ===============================
        // 2. String 배열에 for-each문 사용
        // ===============================
        String[] fruits = {"사과", "바나나", "딸기", "포도"};

        // 구현
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // ===============================
        // 3. 기본 for문과 for-each문 비교
        // ===============================
        int[] numbers = {10, 20, 30, 40, 50};

        // 기본 for문 - 인덱스와 값 모두 사용 가능
        System.out.println("\n기본 for문");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // for-each문 - 값만 사용, 코드가 간결함
        System.out.println("\nfor-each");
        for (int number : numbers) {
            System.out.println("값 : " + number);
        }


        // ===============================
        // 4. 주의 - for-each에서 값 수정 불가
        // ===============================
        /*
         * for-each의 변수에 값을 대입해도
         * 원본 배열에는 반영되지 않는다
         * 배열 값을 직접 수정할 때는 기본 for문을 사용한다
         */
        int[] data = {1, 2, 3};
        for (int d : data) {
            d = d * 10; // 배열의 원본 값은 변하지 않는다
        }
        System.out.println("\n수정 시도 후 data[0] : " + data[0]); // 여전히 1


    }
}
