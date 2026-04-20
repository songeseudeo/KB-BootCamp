package sub.object.makeclass.b_gettersetter;

// ===============================
// Getter / Setter
// ===============================
// 필드를 private 으로 선언하면 외부에서 직접 접근할 수 없다.
// getter : private 필드의 값을 읽어서 반환하는 메소드
// setter : private 필드의 값을 검증 후 저장하는 메소드
//
// 이렇게 하면 잘못된 값이 필드에 들어오는 것을 막을 수 있다.
// 예) 속도가 음수가 되거나 최고속도를 초과하는 것을 setter 에서 막는다.
//
// IntelliJ Getter/Setter 자동 생성 단축키:
// - Windows : Alt + Insert
// - Mac      : Command + N  (또는 Control + Enter)
// 클래스 안에 커서를 놓고 단축키 입력 → Generate 메뉴 → Getter and Setter 선택
//
// 접근 제한자 (Access Modifier):
// - public  : 어디서든 접근 가능
// - private : 클래스 내부에서만 접근 가능
// - protected : 같은 패키지 + 다른 패키지의 자식 클래스까지 접근 가능
// - default (아무것도 없을 때) : 같은 패키지 안에서만 접근 가능
//
// 필드는 보통 private 으로 선언하고
// 외부에 공개할 메소드는 public 으로 선언하는 것이 기본 원칙이다.
// ===============================
    public class Car {
    private String model;
    private boolean start;
    private int speed;
    private String color = "검정";
    private int maxSpeed =350;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isStart() {
        return start;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0 || speed > maxSpeed) {
            System.out.println("유효하지 않은 속도 입니다 " + speed);
            return;
        }
        this.speed = speed;
        }
        public String getColor() {
            return color;
        }

    @Override // 재정의, 오버라이딩
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", start=" + start +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }
}
