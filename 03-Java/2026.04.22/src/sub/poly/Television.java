package sub.poly;

public class Television implements RemoteControl {
    //구현이 된 문제가 없는 완벽한 클래스가 만들어짐.
    //new로 객체 생성 가능
    private int volume;
    private int memoryVolume;
    @Override
    public void turnOn() {
        System.out.println("Television ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Television OFF");
    }


    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void setMute(boolean mute) {

        if(mute){
            this.memoryVolume = this.volume;
            System.out.println("Television 무음처리합니다 ");

        }else{
            System.out.println("무음해제합니다 ");
            setVolume(this.memoryVolume);
        }

    }
}