package sub.thread.sync;


public class Calculator {

    private int memory;

    public int getMemory() { return memory; }

    // =============================== 방법 1 - 메소드에 synchronized 선언
    // 이 메소드 전체가 하나의 스레드만 실행 가능
    public synchronized void setMemory1(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + ": " + getMemory());

    }

    // =============================== 방법 2 - 블록에 synchronized 선언
    // synchronized(this) 블록만 하나의 스레드만 실행 가능
    public void setMemory2(int memory) {

        synchronized (this) {
            this.memory = memory;
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + ": " +  getMemory());
        }
    }
}
