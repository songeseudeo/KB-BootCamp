package sub.thread.work;

public class Work {

    public synchronized void methodA(){
        System.out.println(Thread.currentThread().getName() + ": methodA 실행");

        notify(); //현재 wait 중인 다른 스레드를 채우려고 시도
        try {
            wait(); //현재 스레드를 wait 상대로 만듦
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void methodB(){
        System.out.println(Thread.currentThread().getName() + ": methodB 실행");

        notify(); //현재 wait 중인 다른 스레드를 채우려고 시도
        try {
            wait(); //현재 스레드를 wait 상대로 만듦
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
