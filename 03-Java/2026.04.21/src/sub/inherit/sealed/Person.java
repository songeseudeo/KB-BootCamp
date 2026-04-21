package sub.inherit.sealed;
// ===============================
// sealed 클래스 (Java 17 정식, 15/16 preview)
// ===============================
// sealed 클래스란?
// - 상속할 수 있는 자식 클래스를 permits 키워드로 직접 지정한다.
// - 지정된 클래스 외에는 상속이 불가능하다.
//
// permits 에 지정된 자식 클래스의 선택지:
// - final     : 더 이상 하위 클래스를 만들 수 없다.
// - sealed    : 자신도 상속 범위를 제한한다.
// - non-sealed: 누구든 자유롭게 상속할 수 있도록 개방한다.
//
// 상속 구조:
//   Person (sealed - Employee, Manager 만 상속 가능)
//   ├── Employee (final - 더 이상 상속 불가)
//   └── Manager  (non-sealed - 누구든 추가 상속 가능)
//       └── Director
// ===============================
public sealed class Person permits Employee, Manager {

    private String name;

    public String getName() { return name; }

    public void work() { System.out.println("하는 일이 결정되지 않았습니다."); }
}
