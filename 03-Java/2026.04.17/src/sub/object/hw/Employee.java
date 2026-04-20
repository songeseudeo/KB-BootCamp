package sub.object.hw;

public class Employee {
    // 인스턴스 변수 (객체마다 개별적으로 가짐)

    //id 필수
    //pw 비밀번호는 6자리 이상이어야한다
    //name 필수 값입니다
    //age  나이는 0 이상이어야합니다
    //salary 급여는 0 이상이어야한다
    //gender 성별은 'M' 또는 'F'만 가능

    //필드
    //setter getter
    //setter에서 값 체크
    //toString()

    //실행은 userlass 패키지에서 EmpRun 만들어서 진행

    //직원은 2명, 리사, 제니

    private String id;
    private String pw;
    private String name;
    private int age;
    private double salary;
    private char gender;

    // Getter
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public char getGender() { return gender; }

    // Setter
    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("id는 필수 값입니다.");
            return;
        }
        this.id = id;
    }

    public void setPw(String pw) {
        if (pw == null || pw.length() < 6) {
            System.out.println("비밀번호는 6자리 이상이어야합니다.");
            return;
        }
        this.pw = pw;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("name은 필수 값입니다.");
            return;
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("나이는 0 이상이어야합니다.");
            return;
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("급여는 0 이상이어야합니다.");
            return;
        }
        this.salary = salary;
    }

    public void setGender(char gender) {
        if (gender != 'M' && gender != 'F') {
            System.out.println("성별은 'M' 또는 'F'만 가능합니다.");
            return;
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}
