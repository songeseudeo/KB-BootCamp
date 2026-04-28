package sub.generic.wildcard.raw;

public class Run {
    public static void main(String[] args) {

        Box box1 = new Box();
        box1.content = "100";

        Box box2 = new Box();
        box2.content = "200";

        Box box3 = new Box();
        box3.content = 100;

        boolean result1 = box1.compare(box2);
        System.out.println(result1);

        boolean result2 = box1.compare(box3);
        System.out.println(result2);

        Box<String> box4 = new Box<>();
        box4.content = "100";

        Box<Integer> box5 = new Box<>();
        box5.content = 100;

        //System.out.println(box4.compare(box5)); // 컴파일 에러 발생
        //로우타입일 때 타입 체크가 안 되서 잘못된 비교가 허용될 수 있다.

        // 1. 로우 타입은 타입 안전성을 보장하지 않는다
        // 2. 컴파일 에러 대신 런타임 문제를 발생시킬 수 있다
        // 3. 그래서 실제 개발에서는 로우 타입 사용을 지양해야 한다
    }
}
