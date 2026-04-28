package thread;

//1. 스레드 클래스 만들기 1)이름 클래스 2)익명 클래스
public class Thread2 extends Thread{
    @Override
    public void run(){
        //동시에 처리되는 코드
        for (int i = 100; i > 0; i--) {
            System.out.println("-- 감소: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("에러정보" +e);
            }
        }
    }
}
