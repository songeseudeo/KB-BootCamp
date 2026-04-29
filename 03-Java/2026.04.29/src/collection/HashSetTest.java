package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("jdbc");
        set.add("jsp");
        set.add("Spring");
        set.add("Spring");

        System.out.println(set); //모음 전체 프린트
        System.out.println(set.size()); //개수

        //set은 순서가 없음, index가 없음
        //순서 없이 모아놓았기 때문에 하나씩 있는지 체크하고 있으면 꺼내오는 것을 반복
        Iterator<String> iterator = set.iterator();

        System.out.println(iterator.hasNext());

        while (iterator.hasNext()){
            String e = iterator.next();
            System.out.println("꺼낸 값은 " + e);
        }
        set.remove("jdbc");
        System.out.println(set);

        //for-each로 컬렉션에 사용 가능
        for (String s : set){
            System.out.println(s);
        }
    }
}