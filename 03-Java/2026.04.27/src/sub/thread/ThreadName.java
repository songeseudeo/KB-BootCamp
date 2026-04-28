package sub.thread;

public class ThreadName {
    public static void main(String[] args) {

        //현재 동작하고 있는 스레드 반환
        Thread mainthread = Thread.currentThread();
        System.out.println(mainthread.getName() + "실행");

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    //Thread-N
                    System.out.println(getName() + "실행");
                }
            };

            thread.start();

        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "실행");
            }
        };
        chatThread.setName("chat-Thread");
        chatThread.start();
    }
}
