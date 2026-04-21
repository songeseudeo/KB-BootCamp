package sub.object.b_member;

public class Calculator {

    //정적 멤버
    //public static 어디서든 클래스명으로 바로 접근
    public static double pie = 3.141592;

    //private static 이 클래스 안에서만 공유, 외부에서 직접 접근 불가 -> public static getter 매소드를 만들자
    private static int count = 0;

    public Calculator(){
        count++;
    }

    public static int getCount(){
        return count;
    }

    public static int plus(int x, int y){
        return x+y;
    }

    public static int minus(int x, int y){
        return x-y;
    }
}
