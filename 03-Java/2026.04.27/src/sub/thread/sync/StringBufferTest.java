package sub.thread.sync;

public class StringBufferTest {
    /* String, StringBuilder, StringBuffer */

    /* String : 불변(immutable) 특성
     *          문자열 + 연산으로 합치면 기존 객체를 변경하지 않고
     *          새로운 인스턴스를 생성한다.
     *          따라서 문자열 변경이 잦으면 성능이 떨어질 수 있다.
     *          반대로, 변하지 않는 문자열을 많이 사용할 때는 효율적이다.
     */

    /* StringBuilder : 가변(mutable) 특성
     *          append() 등을 사용하면 기존 인스턴스를 수정한다.
     *          새로운 객체를 생성하지 않기 때문에
     *          문자열 변경이 잦은 경우 성능이 좋다.
     *          (단, 스레드 안전하지 않음)
     */

    /* StringBuffer : 가변(mutable) 특성 //thread safe
     *          StringBuilder와 동일하게 기존 인스턴스를 수정한다.
     *          차이점은 모든 메서드가 동기화(synchronized) 되어 있어
     *          멀티스레드 환경에서 안전하게 사용할 수 있다.
     *          대신 동기화로 인해 StringBuilder보다 성능은 다소 느릴 수 있다.
     */

    public static void main(String[] args) throws InterruptedException{
        StringBuffer sb = new StringBuffer("java");
        System.out.println(sb);
        System.out.println(sb.hashCode());

        sb.append("oracle");
        System.out.println(sb);
        System.out.println(sb.hashCode());

        StringBuilder sb1 = new StringBuilder();
        StringBuffer sb2 = new StringBuffer();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                sb1.append(i);
                sb2.append(i);

            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                sb1.append(i);
                sb2.append(i);

            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
