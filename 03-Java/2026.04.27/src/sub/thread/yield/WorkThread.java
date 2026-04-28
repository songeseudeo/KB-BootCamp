package sub.thread.yield;

public class WorkThread extends Thread{

    public volatile boolean work = true;

    public WorkThread(String name) {setName(name);}

    @Override
    public void run() {
        //interrupt 신호가 오기 전까지 수행
        while (!Thread.currentThread().isInterrupted()){

            if (work) {
                System.out.println(getName() + "작업 처리");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    break;
                }
                }else{
                    Thread.yield(); //작업이 없을 때 스레드 양보
                }
            }
            System.out.println(getName() + " :종료");
        }
    }
