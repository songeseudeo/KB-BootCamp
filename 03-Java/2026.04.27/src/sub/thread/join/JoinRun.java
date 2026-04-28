package sub.thread.join;

public class JoinRun {
    public static void main(String[] args) {

        SumThread sumThread = new SumThread();
        sumThread.start();
        System.out.println("합: " + sumThread.getSum());

        try {
            sumThread.join();
        } catch (InterruptedException e) {
        }
        System.out.println("합: " + sumThread.getSum());
    }
}
