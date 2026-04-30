package test;

import java.util.LinkedList;
import java.util.Queue;

public class CardTest {
    public static void main(String[] args) {
        //카드 문제는
        //rule1) 카드수를 입력: 6 (1~6 카드를 만듦)
        //rule2) 맨 앞에 있는 카드를 제거
        //rule3) 두 번째 있는 카드를 맨 끝으로 붙임
        //-> rule2~3번을 반복 후 마지막 남은 카드 번호가 몇 번?
        //큐 -> LinkdList() : remove(), poll()  -> add()

        int x = 6;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < x; i++) {
            queue.add(i);
        }
        System.out.println(queue);

        //rule2) 맨 앞에 있는 카드를 제거
        //rule3) 두 번째 있는 카드를 맨 끝으로 붙임
        for (int i = 0; i < queue.size(); i++) {
            queue.remove(); //맨 앞에 있는 거 삭제
            System.out.println(queue);
            queue.add(queue.poll());
            System.out.println(queue);
        }
        queue.remove();
        System.out.println(queue);
    }
}
