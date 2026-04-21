package sub.inherit.check;

public class Run {
    public static void personInfo(Person person){
        System.out.println(person.getName());

        person.walk();

        if (person instanceof Student student){
            System.out.println(student.getStudentNo());
            student.study();
        }
    }
    public static void main(String[] args) {

        Person p1 = new Person("제니");
        Person p2 = new Student("리사", 10);
        Person p3 = new Employee("로제");

        personInfo(p1);
        personInfo(p2);
        personInfo(p3);

        Employee p4 = new Employee("정국");

//        if (p4 instanceof Student student){ //상속관계가 없는 타입 비교는 컴파일 에러가 발생
//            student.study();
//        }
    }
}
