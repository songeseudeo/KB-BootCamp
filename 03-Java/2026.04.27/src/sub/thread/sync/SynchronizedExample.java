package sub.thread.sync;

public class SynchronizedExample {
    public static void main(String[] args) {

        // 두 스레드가 같은 Calculator 객체를 공유한다
        Calculator calculator = new Calculator();

        User1Thread user1Thread = new User1Thread();
        user1Thread.setCalculator(calculator);
        user1Thread.start();

        User2Thread user2Thread = new User2Thread();
        user2Thread.setCalculator(calculator);
        user2Thread.start();

    }
}
