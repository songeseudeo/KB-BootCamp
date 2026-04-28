package sub.generic.wildcard.basic;

public class Run {
    public static void main(String[] args) {

        Box<String> box1 = new Box<>(); //T가 String으로 대체
        box1.content = "안녕";
        String str = box1.content;
        System.out.println(str);

        Box<Integer> box2 = new Box<>(); //T가 Integer으로 대체
        box2.content = 100;
        int num = box2.content; //자동 언박싱
        System.out.println(num);
    }
}
