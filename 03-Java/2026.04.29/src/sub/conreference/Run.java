package sub.conreference;

import sub.conreference.Person;

public class Run {
    public static void main(String[] args) {

        Creatable1 c1 = (id) -> new Member(id);

        Creatable1 c2 = Member::new;

        Member test1 = c1.create("A");

        System.out.println(test1);

        Member test2 = c1.create("A");

        System.out.println(test2);

        Creatable2 c3 = Member::new;
        Creatable2 c4 = (id, name) -> new Member(id, name);

        Member test3 = c3.create("A", "제니");
        System.out.println(test3);

        Person person = new Person();
        Member m1 = person.getMember1((String id) -> new Member(id));
        System.out.println(m1);

        Member m2 = person.getMember1(Member::new);
        System.out.println(m2);

        Member m3 = person.getMember2((String id, String name) -> new Member(id, name));
        System.out.println(m3);

        Member m4 = person.getMember2(Member::new);
        System.out.println(m4);


//        Member 클래스에 생성자가 여러 개 있어도
//        함수형 인터페이스의 추상 메소드 형태와 맞는 생성자가 선택된다.
//
//        같은 Member::new라도
//        들어가는 자리의 타입이 다르면 다른 생성자가 선택될 수 있다.
    }
}
