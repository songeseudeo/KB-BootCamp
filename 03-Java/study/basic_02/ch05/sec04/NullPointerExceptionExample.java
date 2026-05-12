package basic_02.ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
        intArray[0] = 10;

        String str = null;
        System.out.println("총 문자 수: " + str.length() );
    }
}
