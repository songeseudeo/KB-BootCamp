package 과제;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1~100 합 : " + sum);

        // while문
        int sum2 = 0;
        int i = 1;
        while (i <= 100) {
            sum2 += i;
            i++;
        }
        System.out.println("1~100 합 : " + sum2);
    }
}