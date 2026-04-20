package sub.object.userclass;

import sub.object.hw.Employee;

public class EmpRun {
    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.setId("lisa01");
        e1.setPw("lisa1234");
        e1.setName("리사");
        e1.setAge(25);
        e1.setSalary(5000000);
        e1.setGender('F');
        System.out.println(e1);

        Employee e2 = new Employee();
        e2.setId("jenny01");
        e2.setPw("jenny1234");
        e2.setName("제니");
        e2.setAge(26);
        e2.setSalary(5500000);
        e2.setGender('F');
        System.out.println(e2);
    }
}