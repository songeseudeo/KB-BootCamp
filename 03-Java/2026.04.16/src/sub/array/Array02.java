package sub.array;

/*
 * ===============================
 * Array02 - 값 목록으로 배열 생성
 * ===============================
 *
 * 배열을 만드는 방법 1 : {} 초기화
 * - 선언과 동시에 값을 지정한다
 * - new 없이 {} 만으로 생성 가능하다
 * - 단, 선언과 초기화를 분리할 때는 new 자료형[]{} 형식을 사용해야 한다
 */
public class Array02 {
    public static void main(String[] args) {

        // ===============================
        // 1. 선언과 동시에 초기화 (가장 일반적인 방법)
        // ===============================
        String[] season = {"Spring", "Summer", "Fall", "Winter"};

        System.out.println("season[0] : " + season[0]);
        System.out.println("season[1] : " + season[1]);
        System.out.println("season[2] : " + season[2]);
        System.out.println("season[3] : " + season[3]);

        // 특정 인덱스의 값 변경
        season[1] = "여름";
        System.out.println("변경 후 season[1] : " + season[1]);
        System.out.println();


        // ===============================
        // 2. 선언 후 나중에 배열 대입
        // ===============================
        /*
         * 변수 선언과 배열 생성을 분리할 때는
         * new 자료형[]{값, 값, ...} 형식을 사용한다
         *
         * 아래처럼 쓰면 컴파일 오류 발생
         * scores = {83, 90, 87};  // 오류
         */
        int[] scores;
        scores = new int[]{83, 90, 87};

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        System.out.println("총합 : " + sum);


        // ===============================
        // 3. 실습 - 합계와 평균 구하기
        // ===============================
        int[] jumsu = {84, 90, 96, 78, 92};

        int total = 0;
        for (int j : jumsu) {
            total += j;
        }

        double avg = (double) total / jumsu.length;
        System.out.println("총합 : " + total);
        System.out.println("평균 : " + avg);


        // ===============================
        // 4. 메서드에 배열을 직접 전달하기
        // ===============================
        /*
         * 배열 변수를 거치지 않고
         * new 자료형[]{} 형식으로 바로 전달할 수 있다
         */
        printScores(new int[]{70, 80, 90});

        Array02 arr = new Array02();
        arr.printScores(new int[]{70, 80, 90});
    }


    // ===============================
    // 배열을 매개변수로 받는 메서드
    // ===============================
    public static void printScores(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "] : " + scores[i]);
        }
    }

    public void printScores2(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "] : " + scores[i]);
        }
    }

    /*
     * ===============================
     * [static 메소드란?]
     * ===============================
     *
     * static 이란?
     * - 객체를 만들지 않아도 사용할 수 있는 메소드나 필드를 만들 때 쓴다
     * - 클래스 자체에 속하기 때문에 어디서든 클래스명.메소드명() 으로 호출 가능하다
     *
     * main 은 객체 없이 JVM 이 바로 실행하는 메소드이다
     * main 안에서 다른 메소드를 바로 호출하려면 그 메소드도 static 이어야 한다
     *
     * static 없으면 → 객체를 만들어야 호출 가능
     *   Array02 obj = new Array02();
     *   obj.printScores2(new int[]{70, 80, 90});
     *
     * static 있으면 → 객체 없이 바로 호출 가능
     *   printScores(new int[]{70, 80, 90});
     *
     * static 메소드 안에서는 인스턴스 필드와 this 를 사용할 수 없다
     * 객체가 없는 상태에서 호출되므로 어느 객체의 값인지 알 수 없기 때문이다
     */
}
