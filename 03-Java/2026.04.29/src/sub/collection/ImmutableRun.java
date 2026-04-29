package sub.collection;

import java.util.*;

public class ImmutableRun {
    public static void main(String[] args) {
        List<String> list1 = List.of("A", "B", "C");
        Set<String> set1 = Set.of("A", "B", "C");
        Map<Integer, String> map1 = Map.of(
                1, "A",
                2, "B",
                3, "C"
        );

        System.out.println(list1);
        System.out.println(set1);
        System.out.println(map1);

        //list1.add("D");
        //set1.remove("A");
        //map1.put(4, "D");

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        List<String> immutableList = List.copyOf(list);
        System.out.println(immutableList);

        //immutableList.add("D");

        //Set<String> set = new HashSet<>(List.of("A", "B", null)); //NullPointerException //null 허용 안 함

        Set<String> set = new HashSet<>(List.of("A", "B", "C"));
        Set<String> immutableSet = Set.copyOf(set);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        Map<Integer, String> immutableMap = Map.copyOf(map);

        set.add("D");
        map.put(4, "C");

        System.out.println(immutableSet);
        System.out.println(immutableMap);

        String[] arr = {"A", "B", "C"};
        List<String> list2 = Arrays.asList(arr);

        //크기 변경은 불가능
        //list2.add("D");
        //list2.remove(0);

        list2.set(0, "2");

        System.out.println(list2);
        System.out.println(Arrays.toString(arr)); // 원본 배열도 변경
    }
}
