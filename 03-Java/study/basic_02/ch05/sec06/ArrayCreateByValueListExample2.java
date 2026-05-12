package basic_02.ch05.sec06;

public class ArrayCreateByValueListExample2 {
    public static void main(String[] args) {
        int[] scores = new int[] { 83, 90, 87 };
        printItem(scores);
    }

    private static void printItem(int[] scores) {
        for(int i=0; i<3; i++) {
            System.out.println("score[" + i + "]: " + scores[i]);
        }
    }
}
