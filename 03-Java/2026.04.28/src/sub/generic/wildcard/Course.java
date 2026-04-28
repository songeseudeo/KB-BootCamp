package sub.generic.wildcard;

public class Course {
    public static void registerCourse1(Applicant<?> applicant){ // ?  제한없음
        System.out.println(applicant.getKind().getClass().getSimpleName() + "   registerCourse1 신청함");
    }


    public static void registerCourse2(Applicant<? extends Student> applicant){ // Student 와 Student의 자식타입만 허용
        System.out.println(applicant.getKind().getClass().getSimpleName() + "   registerCourse2 신청함");
    }

    public static void registerCourse3(Applicant<? super Worker> applicant){ // Worker 와 Worker 의 부모타입만 허용
        System.out.println(applicant.getKind().getClass().getSimpleName() + "   registerCourse3 신청함");
    }
}
