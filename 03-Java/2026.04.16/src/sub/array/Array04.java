package sub.array;

/*
 * ===============================
 * Array04 - length와 for문 활용
 * ===============================
 *
 * length 필드
 * - 배열의 항목 수를 반환한다
 * - 메서드가 아니라 필드이므로 () 없이 사용한다
 *
 * for문과 length를 함께 사용하면
 * 배열의 크기와 상관없이 동일한 코드로 처리할 수 있다
 */
public class Array04 {
    public static void main(String[] args) {

        // ===============================
        // 1. length
        // ===============================
        int[] scores = {84, 90, 96};

        System.out.println("배열 크기 : " + scores.length); // 구현
        System.out.println("마지막 인덱스 : " + (scores.length -1 )); // 구현


        // ===============================
        // 2. for문 + length로 합계/평균 구하기
        // ===============================
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            // 구현
            sum += scores[i];
        }

        // 구현
        double avg = (double) sum/scores.length;
        System.out.println("총합 : " + sum);
      //  System.out.println("평균 : " + avg);


        // ===============================
        // 3. 병렬 배열의 한계
        // ===============================
        /*
         * 서로 다른 타입의 데이터를 배열 여러 개로 나눠서 관리하는 방식을
         * 병렬 배열이라 한다
         *
         * 문제점
         * - 같은 인덱스끼리 의미가 맞아야 하는데, 코드에서 보장이 되지 않는다
         * - 배열 중 하나의 순서가 틀리면 엉뚱한 데이터가 출력된다
         * - 실무에서는 사용하지 않는 방식이다
         *
         * 해결책
         * - 관련 데이터를 하나의 클래스로 묶어서 관리한다 (추후 학습)
         *   class Person { String name; int age; double height; }
         */
        String[] family = {"아버지", "어머니", "형", "나", "동생"};
        int[]    age    = {100, 88, 33, 24, 10};
        double[] height = {177.5, 152.2, 190.3, 167.7, 155.3};

        System.out.println("\n우리집 식구 정리");
        System.out.println("------------------");
        System.out.println("이름\t나이\t키");
        System.out.println("------------------");

        for (int i = 0; i < family.length; i++) {
            System.out.println(family[i] + "\t" + age[i] + "\t" + height[i]);
        }


        // ===============================
        // 4. 실습 - 80점 초과 개수 구하기
        // ===============================
        int[] inputData = {55, 82, 91, 76, 88, 45, 99, 61, 83, 72};


        int count = 0;
        for (int i = 0; i < inputData.length; i++) {
          // 구현
            if(inputData[1] > 80){
                count++;
            }
        }
        System.out.println("\n80점 초과 학생 수 : " + count);
    }
}
