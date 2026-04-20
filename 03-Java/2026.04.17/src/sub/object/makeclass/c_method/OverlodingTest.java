package sub.object.makeclass.c_method;
/*    ------------------------------
      메소드 오버로딩 (Overloading)
      ------------------------------
     - 같은 클래스 안에서
     - 같은 이름의 메소드를 여러 개 정의하는 것
     - 단, 메소드 시그니처가 달라야 한다
       (매개변수의 타입, 개수, 순서 중 하나라도 달라야 함)
      접근제한자와 반환형은 오버로딩 판단 기준이 아니다.
     */

//    메소드 시그니처(Method Signature)란?
//    메소드 이름 + 매개변수 목록(타입, 개수, 순서)

public class OverlodingTest {

    public void test() {}
    // public void test() {}    // 매개변수가 완전히 같아서 중복선언

    public void test(int a) {}
    public void test(int a, String b) {}
    public void test(String a, int b) {} // 순서가 달라서 오버로딩 가능

    public void test(int a, int b) {} // 타입이 달라서 오버로딩 가능
    // public void test(int c, int d) {} //  매개변수 명은 상관 없음

    public void test(String a, int b, String c) {}
    // private void test(String a, int b, String c) {} //접근 제한자는 오버로딩 조건과 무관
    // public int test(String a, int b, String c) {} //반환형도 오버로딩 조건과 무관
}
