package sub.generic.wildcard;

public class GenericExample {
    public static void main(String[] args) {

        // =============================== Course1 - 모든 사람 등록 가능
        System.out.println("[Course1 - 모든 사람]");
        Course.registerCourse1(new Applicant<>(new Person()));
        Course.registerCourse1(new Applicant<>(new Worker()));
        Course.registerCourse1(new Applicant<>(new Student()));
        Course.registerCourse1(new Applicant<>(new HighStudent()));
        Course.registerCourse1(new Applicant<>(new MiddleStudent()));
        System.out.println();

        // =============================== Course2 - 학생만 등록 가능
        System.out.println("[Course2 - 학생만]");
        // Course.registerCourse2(new Applicant<>(new Person()));    // 불가 - Person 은 Student 상위
        // Course.registerCourse2(new Applicant<>(new Worker()));    // 불가 - Worker 는 Student 무관
        Course.registerCourse2(new Applicant<>(new Student()));
        Course.registerCourse2(new Applicant<>(new HighStudent()));
        Course.registerCourse2(new Applicant<>(new MiddleStudent()));
        System.out.println();

        // =============================== Course3 - 직장인 및 일반인만 등록 가능
        System.out.println("[Course3 - 직장인/일반인만]");
        Course.registerCourse3(new Applicant<Person>(new Person()));
        Course.registerCourse3(new Applicant<Worker>(new Worker()));
//         Course.registerCourse3(new Applicant<Student>(new Student()));       // 불가 - Student 는 Worker 하위 아님
//         Course.registerCourse3(new Applicant<Student>(new HighStudent()));   // 불가
//         Course.registerCourse3(new Applicant<Student>(new MiddleStudent())); // 불가
        Course.registerCourse3(new Applicant<Person>(new MiddleStudent())); // new Applicant<> 으로 작성시 타입 추론이 상위 타입으로 될수있음
        // =============================== Course3 - 직장인 및 일반인만 등록 가능
        System.out.println("[Course3 - 직장인/일반인만]");
        Course.registerCourse3(new Applicant<>(new Person()));
        Course.registerCourse3(new Applicant<>(new Worker()));
        // Course.registerCourse3(new Applicant<>(new Student()));       // 불가 - Student 는 Worker 하위 아님
        // Course.registerCourse3(new Applicant<>(new HighStudent()));   // 불가
        // Course.registerCourse3(new Applicant<>(new MiddleStudent())); // 불가
    }
}