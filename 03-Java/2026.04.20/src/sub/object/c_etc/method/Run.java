package sub.object.c_etc.method;

import sub.object.c_etc.prameter.RectAngle;

public class Run {
    public static void main(String[] args) {


        // 인스턴스 메소드 호출
        NonStaticMethod n1 = new  NonStaticMethod();
        n1.method();

        String msg = n1.method2();// 메소드에서 리턴되는 타입과 같은 자료형 변수에 담아서 사용
        System.out.println(msg);

        n1.method3(10, 20);// 반드시 전달되는 매개변수의 타입과 순서에 맞게 전달

        int sum =  n1.method4(10, 20);
        System.out.println(sum);

        System.out.println(n1.method(new RectAngle(10,20)));

    }
}
