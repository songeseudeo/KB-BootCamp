package sub.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashsetRun {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("java");
        set.add("jdbc");
        set.add("jsp");
        boolean result = set.add("java");
        System.out.println(result);

        set.add("spring");
        System.out.println(set.size());

        System.out.println(set.contains("java"));
        System.out.println(set.contains("python"));

        set.remove("jsp");
        System.out.println(set.size());

        for(String str : set){
            System.out.println(str);
        }
        System.out.println("========");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
            if (element.equalsIgnoreCase("spring")){
                iterator.remove();
            }
        }
        System.out.println(set);

        Set<String> setB = new HashSet<>();
        setB.add("java");
        setB.add("Python");

        Set<String> testA = new HashSet<>(set);
        testA.retainAll(setB);
        System.out.println("교집합" + testA);

        Set<String> testB = new HashSet<>(set);
        testB.addAll(setB);
        System.out.println("합집합" + testB);

        Set<String> testC = new HashSet<>(set);
        testC.removeAll(setB);
        System.out.println("합집합" + testC);
    }
}
