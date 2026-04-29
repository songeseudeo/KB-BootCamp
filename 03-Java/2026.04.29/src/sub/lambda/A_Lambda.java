package sub.lambda;

public class A_Lambda {

    public void method1() {

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


        /*
         * ============================================================
         * 2. 람다식 (Lambda Expression)
         * ============================================================
         * - 함수형 인터페이스의 인스턴스를 생성하는 표현식
         * - 익명 구현 객체를 간단하게 표현한 것
         *
         * [형식]
         * (매개변수) -> {
         *     실행문;
         * }
         *
         * 실행문이 1개일 경우:
         * (매개변수) -> 실행문
         *
         * Runnable -> void run()
         * -> () -> 실행문
         */

        // 3) 람다식을 변수에 저장
        //  타겟 타입: Runnable (왼쪽 변수 타입이 결정)
        runnable = () -> System.out.println("람다식을 사용한 스레드 생성");

        thread = new Thread(runnable);
        thread.start();


        /*
         * ============================================================
         * 3. 타겟 타입 (Target Type)
         * ============================================================
         * - 람다식은 반드시 타겟 타입이 필요하다
         * - 타겟 타입 = 람다식이 대입되는 인터페이스 타입
         *
         * [타겟 타입 결정 방식]
         * 1. 변수에 대입 -> 변수 타입
         *      Runnable runnable = () -> {...}
         *
         * 2. 메소드/생성자에 전달 -> 매개변수 타입
         *      new Thread(() -> {...})
         *
         * 즉,
         * 람다식은 "들어가는 자리"에 따라 타입이 결정된다
         */

        // 4) 람다식을 생성자에 바로 전달
        //  타겟 타입: Thread 생성자의 매개변수 (Runnable)
        thread = new Thread(() -> System.out.println("람다식을 바로 전달한 스레드 생성"));

        thread.start();
    }
}