package sub.inherit.overridiong;

/*
 * 오버라이딩(Overriding)이란?
 * 부모 클래스에서 상속받은 메소드를 자식 클래스에서 재정의하여 사용하는 것이다.
 *
 * 오버라이딩 성립 요건
 * 1. 메소드의 이름이 동일해야 한다.
 * 2. 반환 타입은 같거나, 부모 반환 타입의 하위 참조 타입이어야 한다.
 * 3. 매개변수의 타입, 개수, 순서가 동일해야 한다.
 * 4. private 메소드는 자식 클래스에서 접근 자체가 불가능하기 때문에
 *    오버라이딩이 불가능하다.
 * 5. final 키워드가 사용된 메소드는 오버라이딩이 불가능하다.
 * 6. 접근 제한자는 부모 메소드와 같거나 더 넓은 범위여야 한다.
 *    (좁게 변경하면 컴파일 에러)
 * 7. 예외처리는 같은 예외이거나 더 구체적(하위)인 예외를 처리해야 한다.
 *
 * 참고: static 메소드는 오버라이딩이 아니라 hiding(숨김) 이다.
 *       자식 클래스에서 같은 이름의 static 메소드를 선언하면
 *       부모 메소드가 가려질 뿐, 다형성이 적용되지 않는다.
 */

import java.io.IOException;

public class Animal {

    public void sound(int volume){}

    private void breathe(){}

    public final void sleep(){}

    protected void eat(){}

    public void  soundException() throws IOException {}

    public static void staticMethod(){
        System.out.println("Animal staticMethod");
    }
}
