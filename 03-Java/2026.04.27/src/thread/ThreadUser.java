package thread;

public class ThreadUser {
    public static void main(String[] args) {
        //1. thread클래스 만들기
        //2. 객체를 만들기
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        //3. cpu대기줄에 넣기
        thread1.start();
        thread2.start();
    }
}
