package sub.conreference;

public class Member {
    private String id;
    private String name;

    // =============================== 생성자 1 - id만 받음
    public Member(String id) {
        this.id = id;
        System.out.println("Member(String id)");
    }

    // =============================== 생성자 2 - id, name 둘 다 받음
    public Member(String id, String name) {
        this.id   = id;
        this.name = name;
        System.out.println("Member(String id, String name)");
    }

    @Override
    public String toString() {
        return "{ id: " + id + ", name: " + name + " }";
    }
}
