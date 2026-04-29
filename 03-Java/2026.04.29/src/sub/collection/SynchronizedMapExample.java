package sub.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// ===============================
// [Chapter 15 - sec07] 동기화된 컬렉션
// ===============================
//
// 동기화(Synchronization)란?
//   멀티 스레드 환경에서 여러 스레드가 동시에 컬렉션을 수정할 때
//   데이터 손상이 발생하지 않도록 처리하는 것이다.
//
// 동기화된 컬렉션이 필요한 이유:
//   ArrayList, HashMap 등은 동기화가 없어서
//   두 스레드가 동시에 접근하면 데이터가 손상될 수 있다.
//
// 방법 1 - 동기화 래퍼(Wrapper) 사용:
//   Collections.synchronizedList(list)
//   Collections.synchronizedSet(set)
//   Collections.synchronizedMap(map)
//   -> 기존 컬렉션을 감싸서 동기화 기능을 추가한다.
//   -> 전체에 lock이 걸려 성능이 떨어질 수 있음
//
// 방법 2 - 처음부터 동기화 컬렉션 사용:
//   Vector (= 동기화된 ArrayList)
//   Hashtable (= 동기화된 HashMap)
//
// 방법 3 - Concurrent 컬렉션 사용
//   ConcurrentHashMap
//   -> 부분적으로 lock을 사용하여 성능이 더 좋다
//
// 실행 결과:
//   총 객체 수: 2000
// ===============================

public class SynchronizedMapExample {
    public static void main(String[] args) throws InterruptedException {

        // ===============================
        // 1 synchronizedMap 사용
        // ===============================
        // HashMap을 동기화된 Map으로 변환
        // -> 여러 스레드가 동시에 접근해도 안전
        Map<Integer, String> map =
                Collections.synchronizedMap(new HashMap<>());
        // synchronizedMap -> 모든 메소드에 synchronized 적용
        // -> 한 번에 하나의 스레드만 접근 가능 (전체 lock)

        Thread threadA = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    map.put(i, "내용" + i);            // 여러 스레드가 동시에 put해도 데이터 손상 없음

                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                for (int i = 1001; i <= 2000; i++) {
                    map.put(i, "내용" + i);
                }
            }
        };

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        //  멀티스레드에서도 데이터 손실 없음
        System.out.println("총 객체 수: " + map.size());


        // ===============================
        // 2️ ConcurrentHashMap 사용
        // ===============================
        // -> 부분 lock으로 성능이 좋음
        Map<String, Integer> counter =
                new ConcurrentHashMap<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {

                // ===============================
                // compute()
                // ===============================
                // key: "count"
                // k: key
                // v: 현재 값 (없으면 null)
                //
                // 동작 과정:
                // 1. "count" 값 가져옴
                // 2. 값이 null이면 -> 1 저장 (초기값)
                // 3. 값이 있으면 -> +1 증가
                // 4. 결과를 다시 map에 저장
                //
                // 특징:
                //  읽기 + 수정 + 저장을 한 번에 처리
                //  멀티스레드에서도 안전
                counter.compute("count",
                        (k, v) -> (v == null) ? 1 : v + 1);

            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //  1000 + 1000 = 2000 (정상 결과)
        System.out.println("count 값: " + counter.get("count"));

        // ===============================
        //  잘못된 방식 (비교용 - 설명용)
        // ===============================
        // 아래 코드는 멀티스레드에서 위험하다
        //
        // counter.put("count",
        //     counter.get("count") + 1);
        //
        // 이유:
        // 1. 여러 스레드가 동시에 get()
        // 2. 같은 값을 읽고
        // 3. 덮어쓰기 발생 -> 값 손실
        //
        // -> 반드시 compute 사용해야 안전
        Map<String, Integer> wrongCounter = new ConcurrentHashMap<>();

        Runnable wrongTask = () -> {
            for (int i = 0; i < 1000; i++) {

                //  잘못된 방식 (atomic 아님)
                wrongCounter.put("count",
                        wrongCounter.getOrDefault("count", 0) + 1);

                // get + put이 따로 실행됨 -> 중간에 다른 스레드 끼어들 수 있음
            }
        };

        Thread w1 = new Thread(wrongTask);
        Thread w2 = new Thread(wrongTask);

        w1.start();
        w2.start();

        w1.join();
        w2.join();

        System.out.println("[잘못된 방식 결과]");
        System.out.println("count 값: " + wrongCounter.get("count"));



    }
}
//synchronizedMap -> 전체 lock (안전하지만 느림)
//ConcurrentHashMap -> 부분 lock (안전 + 빠름)
//ConcurrentHashMap에서는 "읽기+수정"을 따로 하면 위험하다
//-> compute로 한 번에 처리해야 한다



// ===============================
// compute()
// ===============================
// default V compute(K key,
//     BiFunction<? super K, ? super V, ? extends V> remappingFunction)
//
// 1. 전체 의미:
//    key에 대한 현재 값을 가져와서,
//    함수(remappingFunction)로 계산한 뒤,
//    새로운 값을 저장하고 반환한다.
//
// 2. BiFunction<A, B, C>:
//    (A, B) -> C 형태의 함수
//    -> 입력 2개, 결과 1개
//
// 3. 제네릭 해석:
//    <? super K>
//      -> K 또는 K의 부모 타입까지 입력 허용
//      -> key를 더 넓은 타입으로 받아도 됨
//
//    <? super V>
//      -> V 또는 V의 부모 타입까지 입력 허용
//      -> 현재 값(v)을 더 넓은 타입으로 받아도 됨
//
//    <? extends V>
//      -> V 또는 V의 자식 타입 반환 가능
//      -> 결과는 결국 V 타입으로 저장되므로 안전하게 제한
//
// 4. 전체 해석:
//    (K 또는 그 부모, V 또는 그 부모)를 받아서
//    V 또는 그 자식 타입을 반환하는 함수
//

//    입력 -> super (넓게 받기)
//    반환 -> extends (안전하게 반환)

//    compute는 "읽기 + 계산 + 저장"을 한 번에 처리하는
//    타입 안전한 함수 기반 메소드이다.
// ===============================