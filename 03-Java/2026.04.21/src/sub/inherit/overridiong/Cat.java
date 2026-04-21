package sub.inherit.overridiong;

import java.io.FileNotFoundException;

public class Cat extends Animal{

    //1~3 이름, 반환타입, 매개변수 동일 -> 오버라이딩 가능
    @Override
    public void sound(int volume) {
        super.sound(volume);
    }
    //4 private 매소드 - 자식에서 접근 불가
    //@Override
    //protected void breathe() {}

    //5 final 키워드가 사용된 매소드 - final이 붙은 매소드는 재정의 불가
    //public final void sleep(){}

    //6 접근 제한자는 부모 매소드아 같거나 더 넓은 범위여야 한다
    //좁게 변경하면 컴파일 에러

    //default는 재정의 불가
    //@Override
    //protected void eat() {
    //    super.eat();
    //}

    //protected 재정의 가능 - 부모와 동일
    //@Override
    //protected void eat() {
    //    super.eat();
    //}

    @Override // 재정의 가능 - 부모도가 더 넓은 범위이기 때문
    protected void eat() {
        super.eat();
        System.out.println("츄르를 먹는다");
    }

    //7 예외처리는 같은 예외이거나 더 구체적(하위)인 예외를 처리해야 한다
    //같은 예외 -> 재정의 가능
    //@Override
    //public void soundException() throws IOException {
    //    super.soundException();
    //}

    //하위 예외 -> 재정의 가능
    @Override
    public void soundException() throws FileNotFoundException{

    }
    // 상위 예외 -> 재정의 불가능
    //@Override
    //public void soundException() throws IOException {
    //    super.soundException();
    //}

    //@Override -> static 매서드는 오버라이딩 불가
    public static void staticMethod(){
        System.out.println("Cat staticMethod");
    }

    public  void jump(){
        System.out.println("고양이가 점프");
    }
}
