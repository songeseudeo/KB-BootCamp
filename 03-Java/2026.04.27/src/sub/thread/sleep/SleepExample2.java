package sub.thread.sleep;

import java.awt.Toolkit;
public class SleepExample2 {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // =============================== beep 작업 스레드
        Thread beepThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                toolkit.beep();

                try {
                    System.out.println(">>> beep 스레드 sleep 진입!");
                    Thread.sleep(3000);
                    System.out.println(">>> beep 스레드 sleep 정상 종료!");
                } catch (InterruptedException e) {
                    System.out.println(">>> beep 스레드 interrupt 발생!");
                    break;
                }
            }
        });

        // =============================== interrupt 발생 스레드
        Thread interruptThread = new Thread(() -> {
            try {
                System.out.println(">>> interrupt 스레드 진입!");
                Thread.sleep(5000); // 5초 후 깨움
            } catch (InterruptedException e) {
            }

            System.out.println(">>> interrupt 발생!");
            beepThread.interrupt(); // beepThread를 깨움
        });

        beepThread.start();
        interruptThread.start();
    }
}