package sub.collection.stack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRun {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.size());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.element());

        System.out.println(queue.poll());
        System.out.println(queue.remove());

        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll()); //큐가 비었을 때 null

        try {
            System.out.println(queue.remove());
        } catch (Exception e) {
            System.out.println("remove 실패(빈큐)");
        }
        System.out.println(queue.isEmpty());


        long n = 12345;

        Queue<Integer> q = new LinkedList<>();
        // 12345 % 10 -> 5
        // 1234 % 10  -> 4
        // 123 % 10   -> 3
        // 12 % 10    -> 2
        // 1 % 10     -> 1
        while (n > 0){
            q.offer((int) n % 10); //마지막 자리부터 큐에 저장
            n /= 10; // 마지막 자리를 제거하고 다시 n에 담음
        }

        while (!q.isEmpty()){
            System.out.print(q.poll() + " ");
        }
    }
}
