package sub.thread.work;

public class Run {
    public static void main(String[] args) {

//        Work work = new Work();
        Work1 work = new Work1();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A 호출 횟수:" + i);
                work.methodA();
            }
        }).start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println("B 호출 횟수:" + i);
                work.methodB();
            }
        }).start();
    }
}
