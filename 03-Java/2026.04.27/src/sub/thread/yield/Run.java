package sub.thread.yield;

public class Run {
    public static void main(String[] args) {

        WorkThread workThreadA = new WorkThread("WorkThreadA");
        WorkThread workThreadB = new WorkThread("WorkThreadB");

        workThreadB.start();
        workThreadA.start();

        //1초 동안 A, B 둘 다 수행
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //A 작업 중지, B 더 많이 실행될 가능성이 높아짐
        workThreadA.work = false;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        //A, B 둘다 cpu에 양보
        workThreadA.work = false;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        workThreadA.work = true;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        workThreadB.interrupt();
        workThreadA.interrupt();
    }
}
