package sub.generic.wildcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exec02 {
    public static void main(String[] args) {

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.1);
        doubleList.add(3.1);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        printNum(doubleList);
        printNum(integerList);

        List<String> alist = new ArrayList<>();
        alist.add("test1");
        alist.add("test2");

        Set<String> aset = new HashSet<>();
        aset.add("test1");
        aset.add("test2");

        printColl(alist);
        printColl(aset);
    }

    private static void printColl(Collection<String> str) {
        for (String s : str) {
            System.out.println(s);
        }
    }

    private static void printNum(List<? extends Number> numbers) {
//        numbers.add(10);
//        numbers.add(1.1);
//        List<Double> 인지 List<Integer> 인지 알수없어서 추가가 불가능
        for (Number n : numbers) {
            System.out.println(n);
        }
    }
}