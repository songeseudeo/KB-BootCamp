package sub.inherit.overridiong;

import sub.inherit.overridiong.Book;

public class Run {
    public static void main(String[] args) {

        Animal animal = new Cat();
        animal.eat(); //동적 바인딩 //실행되는 시점에 실제객체의 eat() 매소드가 호출됨

        animal.staticMethod(); //예상 : cat에 있는 static 매소드가 실행되어야 함.
        // static 매소드는 정적 바인딩, 참조변수타입인 Animal의 static 매소드가 호출됨
        Cat.staticMethod();
        Animal.staticMethod();

        //static 매소드는 클래스명으로 접근해서 호출하자, 인스턴스로 static 매소드를 호출하면 예상치못한 결과가 나올 수 있다

        Book book1 = new Book("이기준", 10000, "연어");
        Book book2 = new Book("신용권", 12000, "자바");
        Book book3 = new Book("이기준", 10000, "연어");

        System.out.println(book1);
        System.out.println(book2);

        // 오버라이딩 전 : Object 클래스의 toString() 출력 : 주소값
        // 오버라이딩 후 : Book 클래스의 toString() 출력

        // == 연산자 - 두 변수가 같은 객체(주소)를 참조하는지 비교
        System.out.println(book1 == book3);         // false - 다른 객체이므로

        // equals() - 오버라이딩 전/후 동작이 다르다
        // 오버라이딩 전 : Object.equals() 실행 → == 와 동일하게 주소값 비교
        // 오버라이딩 후 : 실제 필드 값이 같으면 true 반환하도록 재정의
                System.out.println(book1.equals(book3));    // 오버라이딩 전: false / 오버라이딩 후: true

        // hashCode() - 오버라이딩 전/후 동작이 다르다
        // 오버라이딩 전 : Object.hashCode() 실행 → 객체 주소를 기반으로 계산한 정수값 반환
        // 오버라이딩 후 : 필드 값이 같으면 같은 해시코드를 반환하도록 재정의
                System.out.println(book1.hashCode());
                System.out.println(book3.hashCode());

        // 동일 객체 : == 가 true → 같은 주소를 참조하는 완전히 같은 객체
        // 동등 객체 : equals() 가 true → 주소는 달라도 내용(필드값)이 같은 객체
        //
        // Java 규칙 : equals() 가 true 이면 hashCode() 도 반드시 같아야 한다
        //             HashSet, HashMap 등 컬렉션의 중복 체크가 이 규칙을 기반으로 동작한다
        // equals() 를 오버라이딩하면 hashCode() 도 반드시 함께 오버라이딩 하자
    }
}
