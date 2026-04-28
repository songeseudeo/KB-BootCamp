package sub.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

public class Exec01 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);


        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("2");

        printList(list);
        printList(list2);
    }

    public static void printList(List<?> list) { //List<String> // List<Integer>
        // list.add(10);
        // list.add("a");
        // Integer 인지 String 인지 알 수 없어서 추가는 불가능

        for(Object o :list) { //String, int 타입 모두 받을 수 있는 Object
            System.out.println(o);
        }

    }
}
