package sub.inherit.sealed;

public class Run {
    public static void main(String[] args) {

        Person p = new Person(); // 최상위 ,sealed -permits 로 특정 클래스만 상속 허용
        Person e = new Employee(); // final 로 더이상 상속 불가능 하게 정의
        Person m = new Manager(); // non-sealed 로 상속 가능하게 정의
        Person d = new Director(); // 매니저를 상속

        p.work();
        e.work();
        m.work();
        d.work();
    }
}
