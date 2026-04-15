package oper;

public class Oper1 {
    //변수
    //int x = 10;
    //매서드(=함수)
    //시작되는 메서드는 정해져 있음
    //jvm(자바를 실행시킬 수 있는 프로그램)
    public static void main(String[] args) {
        //x=30; 접근 가능
        int x = 200;
        int y = 100;
        System.out.println("x값: " + x);
        System.out.println("y값: " + y);
        //한글자이상 문자열(string)은 무조건 ""를 사용
        System.out.println("값 출력해 봤음");

        int  sum = x + y;
        System.out.println("두 수의 합은: " + sum);
        //자바에서는 int, int 계산의 결과는 무조건 int
        double div = y/x; //100/200 -> 0.5
        //byte + byte => int + int로 변경해서 계산
        //계산 결과가 int가 됨
        System.out.println("두 수의 나눗셈은: " + div);
        //자바에서 계산 결과를 실수로 얻고 싶으면 최소 하나가
        //실수여야 함
        //변수의 타입 변경 불가능
        //cpu가 변수의 값을 가져다 상제로 값을 타입 변환해 줘야함
        //강제형변환(캐스팅)
        double div2 = (double) y/x;
        System.out.println("두 수의 나눗셈2: " + div2);

        double div3 = (double) (y/x);
        System.out.println("두 수의 나눗셈3: " + div3);

        //기본형 형변환
        //자동형변환(큰 <- 작)
        byte a = 10;
        int b = a;
        double c = b; //10.0
        //강제형변환(작 <- 큰)
        byte d = 20;
        int e = 30;
        d = (byte) e;
    }
}
