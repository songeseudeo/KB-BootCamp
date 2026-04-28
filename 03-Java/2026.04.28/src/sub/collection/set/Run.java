package sub.collection.set;

import java.util.HashSet;
import java.util.Set;


public class Run {
    public static void main(String[] args) {

        Set<Member> set = new HashSet<>();
        set.add(new Member("홍", 30));
        set.add(new Member("홍", 30));

        System.out.println(set.size());
    }
}
