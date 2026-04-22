package sub.poly;

public class RemoteControlUse {
    public static void main(String[] args) {
//      RemoteControl rc = new Television();
        RemoteControl rc = new Video();
        rc.turnOn();
        rc.turnOff();
        System.out.println(RemoteControl.COMPANY);
        rc.setMute(true);


        rc = new Television();
        rc.setMute(true);

        RemoteControl.changeBattery();


        RemoteControl rc2 = new SmartTelevision();
        rc2.turnOff();
        rc2.turnOn();
        //rc2.search(); RemoteControl 에는 해당 메소드가 없어서 호출 불가능

        Searchable rc3 = new SmartTelevision();
        rc3.search("https://www.naver.com");
     //   rc3.turnOn();


        if(rc2 instanceof Searchable s){
            s.search("https://www.naver.com");
            System.out.println("Searchable 타입 입니다 ");
        }


        if(rc2 instanceof SmartTelevision ){
            SmartTelevision st =  (SmartTelevision) rc2;
            st.search("https://www.naver.com");
        }


        SmartTelevision2 st = new SmartTelevision2();
        RemoteControl rc4 = st;
        rc4.turnOn();
        rc4.turnOff();


        Searchable se = st;
        se.search("naver");


        MultiControl multi = st;
        multi.turnOn();
        multi.turnOff();
        multi.search("naver");
        multi.ott();

    }
}