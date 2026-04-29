package sub.collection.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackRun {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.size());
        System.out.println(stack);

        System.out.println(stack.peek());

        System.out.println(stack.search(20)); //1부터 시작

        System.out.println(stack.empty());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        try {
            stack.pop();
        } catch (Exception e){
            System.out.println("스택이 비어있음");
        }

        //숫자 뒤집기 -> 54321
        long n = 12345;

        String[] arr1 = String.valueOf(n).split("");
        System.out.println(Arrays.toString(arr1));

        Stack<String> stack1 = new Stack<>();
        for(String str : arr1){
            stack1.push(str);
        }
        System.out.println(stack1);

        while (!stack1.isEmpty()){
            System.out.print(stack1.pop() + " ");
        }
    }
}
