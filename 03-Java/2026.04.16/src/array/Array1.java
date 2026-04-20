package array;

//import java.lang.*;
//컴파일할 때 자동으로 넣어줌.
//안써도 됨.

public class Array1 {
    public static void main(String[] args) {
        System.out.println("테스트");

        //배열 만들기 --> 고정크기, 같은 타입만 넣음.
        //방법 1) 배열 생성시에 값을 모르고 있다가 나중에

        int[] jumsu = new int[10]; //자동초기화
        System.out.println(jumsu[0]); //0
        //한 줄 복사(ctrl + d)
        System.out.println(jumsu[1]); //0
        System.out.println(jumsu.length); //10
        System.out.println(jumsu[jumsu.length - 1]);

        jumsu[0] = 100;
        jumsu[1] = 200;
        System.out.println(jumsu[0] + " " + jumsu[1]);

        //
    }
}