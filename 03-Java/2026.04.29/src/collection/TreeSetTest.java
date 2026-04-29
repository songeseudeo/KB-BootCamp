package collection;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("홍");
        treeSet.add("김");
        treeSet.add("이");
        System.out.println(treeSet);

        // 비교할 수 있는 기준이 없어서 실행되지 않음
        // 비교할 수 있는 메서드를 만들어줘야 함
//        TreeSet<Person> treeSet2 = new TreeSet<>(); //unique, 정렬
//        treeSet2.add(new Person("홍", 100));
//        treeSet2.add(new Person("홍", 100));
//        treeSet2.add(new Person("홍", 100));
//        System.out.println(treeSet2);

        TreeSet<Person2> treeSet2 = new TreeSet<>(); //unique, 정렬
        treeSet2.add(new Person2("홍", 100));
        treeSet2.add(new Person2("홍", 200));
        treeSet2.add(new Person2("홍", 100));
        System.out.println(treeSet2);
    }
}
