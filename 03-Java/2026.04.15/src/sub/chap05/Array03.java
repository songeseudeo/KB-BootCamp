package sub.chap05;

/*
 * ===============================
 * Array03 - new 연산자로 배열 생성
 * ===============================
 *
 * 배열을 만드는 방법 2 : new 연산자
 * - 크기만 지정하고, 값은 나중에 넣는다
 * - 생성 직후에는 타입별 기본값으로 자동 초기화된다
 *
 * 사용 형식
 * 자료형[] 변수명 = new 자료형[크기];
 */
public class Array03 {
    public static void main(String[] args) {

        // ===============================
        // 1. int 배열 생성 및 값 변경
        // ===============================
        int[] arr1 = new int[3];

        // 초기값 출력 (모두 0)
        System.out.print("int 초기값 : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("arr1[" + i + "]=" + arr1[i] + "  ");
        }
        System.out.println();

        // 값 변경
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;

        System.out.print("int 변경 후 : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("arr1[" + i + "]=" + arr1[i] + "  ");
        }
        System.out.println("\n");


        // ===============================
        // 2. double 배열 생성 및 값 변경
        // ===============================
        double[] arr2 = new double[3];

        // 초기값 출력 (모두 0.0)
        System.out.print("double 초기값 : ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("arr2[" + i + "]=" + arr2[i] + "  ");
        }
        System.out.println();

        // 값 변경
        arr2[0] = 0.1;
        arr2[1] = 0.2;
        arr2[2] = 0.3;

        System.out.print("double 변경 후 : ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("arr2[" + i + "]=" + arr2[i] + "  ");
        }
        System.out.println("\n");


        // ===============================
        // 3. String 배열 생성 및 값 변경
        // ===============================
        String[] arr3 = new String[3];

        // 초기값 출력 (모두 null)
        System.out.print("String 초기값 : ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print("arr3[" + i + "]=" + arr3[i] + "  ");
        }
        System.out.println();

        // 값 변경
        arr3[0] = "1월";
        arr3[1] = "2월";
        arr3[2] = "3월";

        System.out.print("String 변경 후 : ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print("arr3[" + i + "]=" + arr3[i] + "  ");
        }
        System.out.println();


        // ===============================
        // 4. 주의 - 인덱스 범위 초과
        // ===============================
        /*
         * 배열의 마지막 인덱스는 (length - 1) 이다
         * 범위를 벗어난 인덱스에 접근하면 예외가 발생한다
         *
         * java.lang.ArrayIndexOutOfBoundsException
         */
        // arr1[3] = 100; // 오류 발생 - 인덱스 3은 존재하지 않음
    }
}
