package sub.conreference;

public class Person {

    public Member getMember1(Creatable1 creatable) {
        String id = "winter";

        return creatable.create(id);   // 실제로 new Member(id) 실행됨
    }


    public Member getMember2(Creatable2 creatable) {
        String id   = "winter";
        String name = "한겨울";

        return creatable.create(id, name);  // 실제로 new Member(id, name) 실행됨
    }
}
