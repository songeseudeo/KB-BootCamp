package sub.generic.wildcard.gmethod;

import java.util.Arrays;
import java.util.List;

public class Run {
    public static <T> Box<T> boxing(T t){
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }

    public static void main(String[] args) {

       Box<Integer> box1 = boxing(100); // T -> Integer
       int val = box1.get();
        System.out.println(val);

       Box<String> box2 = boxing("홍길동"); // T -> String
       String val2 = box2.get();
       System.out.println(val2);

        box1.print("hi");
        box2.print("hi");

        box1.print(100);
        box2.print(100);

        List<Integer> list1 = Arrays.asList(1,2,3);
        System.out.println(list1);
    }
}
