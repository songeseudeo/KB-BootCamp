package sub.thread.sync;

public class Run {
    public static void main(String[] args) throws InterruptedException{

//        Count count = new Count();

        CountSync count = new CountSync();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                count.increament();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                count.increament();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
