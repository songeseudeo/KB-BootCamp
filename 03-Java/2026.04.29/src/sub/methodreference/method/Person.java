package sub.methodreference.method;

public class Person {
    public void ordering(Comparable comparable) {
        String a = "홍길동";
        String b = "김길동";


        int result = comparable.compare(a, b);

        /*
         * compareToIgnoreCase의 반환값
         *
         *  - 음수: a가 b보다 앞에 온다
         *  - 0   : a와 b가 같다
         *  - 양수: a가 b보다 뒤에 온다
         */

        if (result < 0) {
            System.out.println(a + "는 " + b + "보다 앞에 옵니다.");
        } else if (result == 0) {
            System.out.println(a + "는 " + b + "와 같습니다.");
        } else {
            System.out.println(a + "는 " + b + "보다 뒤에 옵니다.");
        }
    }
}