package sub.thread.work;

public class Work1 {

    private boolean turnA = true;
    public synchronized void methodA(){


        while (!turnA) { //A 차례가 아니면 대기

            try {
                wait(); //현재 스레드를 wait 상태로 만듦
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + ": methodA 실행");
        turnA = false;

        notify(); //현재 wait 중인 다른 스레드를 채우려고 시도
    }

    public synchronized void methodB(){


        while (turnA) { //B처리가 아니면 대기
            try {
                wait(); //현재 스레드를 wait 상대로 만듦
            } catch (InterruptedException e) {
            }

        }

        System.out.println(Thread.currentThread().getName() + ": methodB 실행");
        turnA = true;
        notify(); //현재 wait 중인 다른 스레드를 깨우려고 시도
    }
}
