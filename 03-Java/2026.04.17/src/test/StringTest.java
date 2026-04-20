package test;

public class StringTest {
    public static void main(String[] args) {
        String str = "  Hello Java World  ";
        String str2 = "  Hello Java World  ";
        System.out.println(str == str2); //true

        System.out.println(str.length());
        System.out.println(str.charAt(2));
        //코드 일부 자동 완성: 컨트롤 + 스페이스바
        System.out.println(str.substring(2));
        System.out.println(str.substring(2, 5));
        System.out.println(str.trim());
        //concat: 뒤에 붙여줘
        System.out.println(str.concat("java"));
        System.out.println(str.contains("java"));

    }
}
