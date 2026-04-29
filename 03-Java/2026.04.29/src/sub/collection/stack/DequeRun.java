package sub.collection.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeRun {
    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(100);
        stack.push(50);
        stack.push(500);
        stack.push(10);

        System.out.println(stack.peek());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        Deque<Integer> queue = new ArrayDeque<>();

        queue.push(100);
        queue.push(50);
        queue.push(500);
        queue.push(10);

        System.out.println(queue.peek());

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        Deque<String> deque = new ArrayDeque<>();

        deque.offerFirst("A"); // 앞쪽에 추가
        deque.offerLast("B");  // 뒤쪽에 추가
        deque.offerFirst("C"); // 앞쪽에 추가
        // 현재 상태: [C, A, B]

        System.out.println("앞쪽 값 확인: " + deque.peekFirst()); // C
        System.out.println("뒤쪽 값 확인: " + deque.peekLast());  // B

        System.out.println("앞쪽에서 꺼냄: " + deque.pollFirst()); // C 제거
        System.out.println("뒤쪽에서 꺼냄: " + deque.pollLast());  // B 제거
        System.out.println("남은 값: " + deque); // [A]

        // ===============================
        // 4. 빈 Deque에서 메소드 차이
        // ===============================
        Deque<Integer> emptyDeque = new ArrayDeque<>();

        System.out.println("빈 Deque poll(): " + emptyDeque.poll());
        // poll() -> 값 없으면 null 반환 (안전한 방식)

        System.out.println("빈 Deque peek(): " + emptyDeque.peek());
        // peek() -> 값 없으면 null 반환

        // emptyDeque.pop();
        // pop() -> 값 없으면 예외 발생 (NoSuchElementException)
        // ->  poll/peek을 더 많이 사용
    }
}
