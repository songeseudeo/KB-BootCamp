package sub.generic.wildcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exec03 {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();
        List<Double> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();

        addNumber(list1);
        addNumber(list2);
        addNumber(list4);
        // addNumber(list3); // 불가: Double은 Integer의 상위 타입이 아님
    }

    public static void addNumber(List<? super Integer> list) {
        list.add(1);
        list.add(2);

        for (Object num : list) {
            System.out.println(num);
        }

        //Collections.copy();
    }
}