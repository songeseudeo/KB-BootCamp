package sub.methodreference.method;

@FunctionalInterface
public interface Comparable {

    // 스트링 두개 받아서 인트 반환하는 메소드 하나
    int compare(String a, String b);
}