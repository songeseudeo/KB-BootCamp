package sub.collection.list;

public class Employee {
    // 인스턴스 변수 (객체마다 개별적으로 가짐)

    //id 필수       String
    //pw 비밀번호는 6자리 이상이어야한다   String
    //name 필수 값입니다  String
    //age  나이는 0 이상이어야합니다  int
    //salary 급여는 0 이상이어야한다  double
    //gender 성별은 'M' 또는 'F'만 가능  char


    // 필드
    // setter getter
    // setter에서 값 체크
    // toString()

    // 실행은 useclass 패키지에서 EmpRun 만들어서 진행
    // 직원은 2명  리사 ,제니


    private String id;
    private String pw;
    private String name;
    private int age;
    private double salary;
    private char gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.trim().isEmpty()){
//            System.out.println("id를 필수로 입력해주세요.");
//            return;
            throw new IllegalArgumentException("필수 값입니다 ");

        }
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        if (pw == null || pw.trim().length() < 6){
//            System.out.println("패스워드는 6자리 이상으로 입력해주세요.");
//            return;
            throw new IllegalArgumentException("패스워드는 6자리 이상으로 입력해주세요. ");

        }
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            System.out.println("이름은 필수 값입니다.");
            return;
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            System.out.println("age는 0 이상이어야 합니다.");
            return;
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0){
            System.out.println("salary는 0 이상이어야 합니다.");
            return;
        }
        this.salary = salary;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender != 'M' && gender != 'F'){
            System.out.println("성별을 정확하게 입력해주세요('M' 또는 'F')");
            return;
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}
