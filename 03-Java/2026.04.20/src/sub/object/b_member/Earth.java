package sub.object.b_member;

// ===============================
// 상수(static final)
// ===============================
// 상수란?
// - static final 을 함께 사용해서 선언
// - 객체마다 따로 존재하지 않고 클래스에 하나만 존재
// - 프로그램 전체에서 공통으로 사용하는 변하지 않는 값
//
// 사용법
// - 클래스명.상수명
//
// 접근제어자 주의
// - 다른 패키지에서 사용하려면 클래스도 public
// - 외부에서 사용할 상수는 public static final
//
// 접근제어자별 상수 테스트
// - public    : 어디서든 접근 가능
// - default   : 같은 패키지에서만 접근 가능
// - protected : 같은 패키지 + 상속 관계에서 접근 가능
// - private   : 자기 클래스 내부에서만 접근 가능
// ===============================
public class Earth {

    // ===============================
    // [ 상수]
    // ===============================
    // 다른 패키지(useclass)에서 사용할 것이므로 public 필요
    public static final double EARTH_RADIUS = 6400;// km

    // 선언 후 static 블록에서 초기화하는 상수
    public static final double EARTH_SURFACE_AREA;

    // 초기화 블럭
//    클래스 로딩 시 한 번만 실행
//    정적 필드 초기화 목적
//    복잡한 초기화 로직 처리
    static { //공식: 4 × π × r²  구의 표면적 구하는 공식
        EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }

    // ===============================
    // 접근제어자 테스트용 상수
    // ===============================

    // 1. public 상수: 다른 패키지에서도 접근 가능
    public static final double PUBLIC_TEST = 1.0;

    // 2. default 상수: 같은 패키지에서만 접근 가능
    static final double DEFAULT_TEST = 2.0;

    // 3. protected 상수: 같은 패키지에서는 접근 가능
    protected static final double PROTECTED_TEST = 3.0;

    // 4. private 상수: Earth 클래스 내부에서만 접근 가능
    private static final double PRIVATE_TEST = 4.0;

    // private 상수는 외부에서 직접 접근 불가이므로
    // public 메서드를 통해 간접적으로만 확인 가능
    public static double getPrivateTest() {
        return PRIVATE_TEST;
    }
}