package sub.methodreference.method;

import sub.lambda.Person;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Run {
    public static void main(String[] args) {

        Person person = new Person();


        Comparable comp1 = (String a, String b) -> a.compareToIgnoreCase(b);

        person.ordering(comp1);

        Comparable comp2 = String::compareToIgnoreCase;
        person.ordering(comp2);

        List<String> names = Arrays.asList("banana", "Apple", "pineapple");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("람다식(compareTo): " + names);

        names.sort(String::compareTo);
        System.out.println("메소드참조(compareTo): " + names);

        /* *  메소드 참조 불가능 한경우 길이로 비교
         * 1. 익명 클래스 방식
         *
         * Comparator 인터페이스를 직접 구현한다.
         * compare()에서 문자열 길이를 비교
         */
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        System.out.println("익명 클래스 (길이 기준): " + names);

        /*
         * 2. 람다식 방식
         *
         * 익명 클래스를 람다식으로 단순화
         */
        names.sort((a, b) -> a.length() - b.length());
        System.out.println("람다식 (길이 기준): " + names);

        /*
         * 3. Integer.compare()
         *
         * Integer.compare() 사용
         * -> overflow 위험 방지 (공식적으로 권장되는 비교 방식)
         */
        names.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Integer.compare 사용: " + names);

        /*
         * 4. comparing 메소드
         *
         * comparing은
         * "객체에서 어떤 값을 꺼내서,
         *  그 값을 기준으로 비교하는 Comparator를 만들어준다"
         *
         * 예:
         * String::length
         * -> 문자열에서 length 값을 꺼낸다
         *
         * 즉,
         * 문자열 자체를 비교하는 것이 아니라
         * "길이"를 기준으로 정렬한다
         */
        //내부적으로 (a, b) -> a.length().compareTo(b.length()) 임
        names.sort(Comparator.comparing(String::length));
        System.out.println("comparing + 메소드 참조: " + names);
    }
}
