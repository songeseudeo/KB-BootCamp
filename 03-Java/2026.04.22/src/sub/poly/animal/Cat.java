package sub.poly.animal;

public class Cat extends Animal implements Action{


    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(getName() + "가 야옹 하고 웁니다 ");
    }

    @Override
    public void eat() {
        System.out.println(getName()+ "츄르를 먹습니다 ");
    }

    @Override
    public void sleep() {
        System.out.println(getName() +  "20 시간 잡니다~");
    }

    @Override
    public void play() {
        System.out.println(getName() + " 장난감을 가지고 놉니다 ");
    }
}
