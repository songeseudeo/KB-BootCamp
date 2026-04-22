package sub.poly;

public class SmartTelevision2 implements MultiControl{
    @Override
    public void turnOn() {
        System.out.println("TV 를 켭니다 ");
    }

    @Override
    public void turnOff() {
        System.out.println("TV 를 끕니다 ");

    }

    @Override
    public void search(String url) {
        System.out.println(url + " 를 검색합니다 ");

    }

    @Override
    public void ott() {
        System.out.println("ott 를 봅니다 ~");
    }
}
