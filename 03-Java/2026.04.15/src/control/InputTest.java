package control;

import java.util.Scanner;
//코드치고 저장한 후 컴파일하면 자동으로 import java.lang.*;를 넣어줌

public class InputTest {
    public static void main(String[] args) {
        //컴퓨터에 출력하는 것은 많이 사용
        //대문자로 바로 사용 가능
        System.out.println("모니터에 출력");

        //입력하는 것은 잘 사용 안함
        //램에 새롭게 넣어줘야 함
        //new 넣고싶은 클래스명();
        //금요일에 자세히 배울 예정
        Scanner scanner = new Scanner(System.in);
        System.out.println("참조형 변수 출력(주소)>> " + scanner);
        //System: 컴퓨터
        //.: 접근 연산자
        //System.in: 컴퓨터의 기본 input 장치(키보드)
        //System.out: 컴퓨터의 기본 output 장치(모니터, 터미널/콘솔)
        //어디에 새롭게 넣어줬는지 변수를 만들어서
        //주소(위치)를 넣어줘야 함
        //병수명 앞에는 반드시 그 주소에 어떤 유형이 들어있는지 써줘야함
        String data = scanner.nextLine(); //터미널/콘솔에서 입력한 한 줄을 자바 코드로 가지고 들어옴(입력)
        //가지고 들어와서 변수에 저장
        //사용자가 입력한 데이터들은 모두 문자열 타입으로 다룸
        System.out.println("입력 값: " + data);

        String data2 = scanner.nextLine(); //숫자 입력
        System.out.println("입력 값: " + (data2 + 1));
    }
}
