package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("홍", 85);
        map.put("김", 85);
        System.out.println(map); //값 출력
        System.out.println(map.size());

        //get(key) -> 값추출 가능
        System.out.println("홍");
        //중복 안 된 key들을 set으로 꺼내줌
        Set<String> keys = map.keySet();

        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next(); //키하나 꺼냄
            System.out.println(key + ":" + map.get(key));
        }
        // key+value의 쌍으로 꺼내주고 싶음.(Entry)
// Entry의 Set을 꺼내오는 메서드 이용
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> iterator1 = entrySet.iterator();

        while(iterator1.hasNext()){
            Entry<String, Integer> entry = iterator1.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        map.remove("홍길동"); // key로 삭제
        System.out.println(map.size());
    }
}
