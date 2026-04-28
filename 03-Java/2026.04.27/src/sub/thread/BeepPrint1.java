package sub.thread;

import java.awt.*;

public class BeepPrint1 {
    public static void main(String[] args) {
        Thread thread;
        Runnable runnable;

        /*
         * ============================================================
         * 1. 익명 구현 객체 (Anonymous Class)
         * ============================================================
         * - 이름이 없는 구현 객체 (일회성)
         * - 인터페이스의 추상 메소드를 직접 구현
         *
         * [형식]
         * 인터페이스변수 = new 인터페이스() {
         *     @Override
         *     public void 추상메소드() {
         *         실행문;
         *     }
         * };
         *
         * Runnable 인터페이스:
         *      void run();
         */

        // 1) 익명 구현 객체를 변수에 저장
        runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 구현 객체를 사용한 스레드 생성");
            }
        };

        thread = new Thread(runnable);
        thread.start();


        // 2) 익명 구현 객체를 생성자에 바로 전달
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 구현 객체를 사용한 스레드 생성2");
            }
        });

        thread.start();
        //Runnable 인터페이스를 구현
        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i <= 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        //Thread 상속 받아서 사용
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i <= 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("땡");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
