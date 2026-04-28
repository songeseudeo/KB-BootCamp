package sub.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapRun {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("신용권", 85);
        map.put("제니", 90);
        map.put("리사", 80);
        map.put("제니", 95);

        System.out.println(map.size()); //키는 중복 허용 안 됨, 뒤에 키 값으로 교체
        System.out.println(map);

        String key = "제니";
        int value = map.get(key); //get은 키가 없으면 NullPointerException 발생
        System.out.println(value);

        Set<String> keyset = map.keySet();
        Iterator<String> keyIter = keyset.iterator();
        while (keyIter.hasNext()){
            String k = keyIter.next();
            Integer v = map.get(k);
            System.out.println(k + "   " + v);
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()){
            Entry<String, Integer> entry = entryIterator.next();
            System.out.println(entry.getKey() + entry.getValue());
        }

        map.remove("제니");
        System.out.println(map);
        // map.put("제니", map.get("제니") +1); //NullPointerException

        map.put("제니", map.getOrDefault("제니", 0) + 1);
        map.put("제니", map.getOrDefault("제니", 0) + 1);
        map.put("제니", map.getOrDefault("제니", 0) + 1);
        map.put("리사", map.getOrDefault("리사", 0) + 1);

        System.out.println(map);
    }
}
