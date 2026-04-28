package sub.check;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OrderService {

    // 스레드 3개를 가진 스레드풀 생성
    // 작업이 들어오면 3개의 스레드가 나눠서 처리
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    /*
    [processOrder - execute 방식]

    - execute()는 작업만 실행하고 결과를 반환하지 않음
    - 비동기 방식 (메서드 호출 후 바로 리턴)
    - 예외는 밖으로 전달되지 않기 때문에 반드시 내부에서 try-catch 처리 필요
    */
    public void processOrder() {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    saveOrder();
                } catch (Exception e) {
                    System.out.println("saveOrder 실패: " + e.getMessage());
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sendMessage();
                } catch (Exception e) {
                    System.out.println("sendMessage 실패: " + e.getMessage());
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    writeLog();
                } catch (Exception e) {
                    System.out.println("writeLog 실패: " + e.getMessage());
                }
            }
        });
    }

    /* 퓨처 Future
    [processOrder2 - submit 방식]

    - submit()은 Future를 반환
    - Future.get()을 호출하면 작업이 끝날 때까지 기다림 (blocking)
    - 따라서 내부는 비동기지만 결과적으로는 "대기형 실행"
    - 예외는 get()에서 확인 가능
    */
    public void processOrder2() {

        Future<?> f1 = executor.submit(new Runnable() {
            @Override
            public void run() {
                saveOrder();
            }
        });

        Future<?> f2 = executor.submit(new Runnable() {
            @Override
            public void run() {
                sendMessage();
            }
        });

        Future<?> f3 = executor.submit(new Runnable() {
            @Override
            public void run() {
                writeLog();
            }
        });

        try {
            // 작업이 끝날 때까지 기다림
            f1.get();
            f2.get();
            f3.get();
        } catch (Exception e) {
            System.out.println("작업 중 오류: " + e.getMessage());
        }
    }

    /*
    [saveOrder]

    - 주문 저장 작업
    - 현재 실행 중인 스레드 이름 출력
    */
    private void saveOrder() {
        sleep(); // 실행 순서 확인용

        System.out.println("saveOrder 실행 스레드: "
                + Thread.currentThread().getName());

        System.out.println("주문 저장");
    }

    /*
    [sendMessage]

    - 메시지 전송 작업
    */
    private void sendMessage() {
        sleep();

        System.out.println("sendMessage 실행 스레드: "
                + Thread.currentThread().getName());

        System.out.println("메시지 전송");
    }

    /*
    [writeLog]

    - 로그 기록 작업
    */
    private void writeLog() {
        sleep();

        System.out.println("writeLog 실행 스레드: "
                + Thread.currentThread().getName());

        System.out.println("로그 기록");
    }

    /*
    [shutdown]

    - 스레드풀 종료
    - 호출하지 않으면 프로그램이 종료되지 않을 수 있음
    */
    public void shutdown() {
        executor.shutdown();
    }

    /*
    [sleep]

    - 실행 속도를 늦춰서 멀티스레드 동작을 눈으로 확인하기 위한 메서드
    */
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("sleep 중 인터럽트 발생");
        }
    }
}