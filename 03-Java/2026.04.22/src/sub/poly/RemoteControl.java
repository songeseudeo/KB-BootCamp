package sub.poly;

public interface RemoteControl {
    //기능만 명세 --> 일반적으로 메서드만 넣음.
    //단, 클래스들 간의 공유할 목적의 변수(일반 변수X, 상수)는 추가 가능.
    public static final String COMPANY = "kb";

    void turnOn(); //추상메서드
    public abstract void turnOff();

    //컴파일러가 인터페이스안에 넣는 메서드는 자동으로
    //public abstract을 무조건 메서드 앞에 붙여줌.

    // 디폴트 메소드 - 재정의도 선택적으로 할수있다
    default void setMute(boolean mute){
        if(mute) {
            System.out.println("RemoteControl 무음으로 처리합니다 ");
        }else{
            System.out.println("RemoteControl 무음을 해제합니다 ");
        }

        defaultCommon();
    }
    // 정적메소드 - 인터페이스 명으로 직접호출
    static void changeBattery(){
        System.out.println("건전지를 교환합니다 ");
        staticCommon();
    }

    private void defaultCommon(){
        System.out.println("디폴트 메소드 공통 코드 ");
    }

    private static void staticCommon(){
        System.out.println("정적 메소드 공통 코드 ");
    }
}