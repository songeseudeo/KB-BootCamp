package sub.inherit.check;

public class Student extends Person {

    private int studentNo;

    public Student(String name, int studentNo) {
        super(name);
        this.studentNo = studentNo;
    }

    public int  getStudentNo() { return studentNo; }

    public void study() { System.out.println("공부를 합니다."); }
}
