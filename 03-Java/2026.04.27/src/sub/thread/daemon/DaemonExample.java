package sub.thread.daemon;

public class DaemonExample {
    public static void main(String[] args) {

        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);     // 데몬 스레드로 설정 - start() 전에 호출해야 한다
        autoSaveThread.start();

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        System.out.println("메인 스레드 종료");
        // 메인 스레드 종료 → AutoSaveThread 도 자동 종료
    }
}
