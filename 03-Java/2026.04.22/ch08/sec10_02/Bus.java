package ch08.sec10_02;

public class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("버스가달립니다.");
    }
    public void checkFare() {
        System.out.println("승차요금을체크합니다.");
    }
}
