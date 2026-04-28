package sub.thread.sleep;

import java.awt.*;

public class SleepRun {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("스레드 진입");
                try {
                    Thread.sleep(5000); //5초간 일시정지
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("interrupt 발생");
                //sleep인 메인 스레드를 실행대기 상태로 만듦
                mainThread.interrupt();
            }
        }).start();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 10; i++){
            toolkit.beep();
            System.out.println("beep main 스레드 진입");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("beep main 스레드:" + e.getMessage());

                break;
            }
        }
    }
}
