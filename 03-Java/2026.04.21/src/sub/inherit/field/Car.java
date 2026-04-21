package sub.inherit.field;

public class Car {

    private int num;
    private String srt;

    private Tire tire; //Tire 타입의 어떤 자식 객체든 대입가능

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public void run(){
        tire.roll(); //대입된 객체에 따라 다른 roll이 호출
    }
}
