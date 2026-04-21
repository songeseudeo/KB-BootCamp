package sub.object.c_etc.prameter;



import java.util.Arrays;

public class Run {
    public static void main(String[] args) {


        //기본자료형 매개변수 전달
        ParameterTest pt = new ParameterTest();
        pt.test1(20);

        //배열인자
        int[] iarr = new int[] {1, 2, 3, 4, 5};
        pt.test2(iarr);
        System.out.println(Arrays.toString(iarr));


        //객체인자
        RectAngle r1 = new RectAngle(12.5, 22.5);
        System.out.println("인자로 전달하는 객체 : " + r1);
        System.out.println("변경 후 사각형의 넓이와 둘레 ========================");

        pt.test3(r1);
        r1.calcArea();
        r1.calcRound();



        //가변인자 - 인자로 전달하는 값의 갯수가 정해지지않은 경우 가변배열활용

        pt.test4("제니");// 가변인자는 전달되지않아도 괜찮다
        pt.test4("제니","볼링");
        pt.test4("제니","볼링","골프");
        pt.test4("제니", new String[]{"테니스","서예"});
    }
}
