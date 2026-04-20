package sub.object.makeclass.c_method;

// return 문의 두 가지 역할:
// 1. 리턴값 반환: 호출한 곳으로 결과값을 돌려준다.
// 2. 메소드 종료: return 을 만나면 즉시 메소드가 끝난다.
//                void 메소드에서도 return; 으로 조기 종료할 수 있다.
// ===============================
public class Car {
    private int gas;

    //리턴 값이 없는 메소드
    public void setGas(int gas){
        this.gas = gas;
    }

    public boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("가스가 없습니다.");
            return false;
        }
        System.out.println("가스가 있습니다.");
        return true;
    }
    // 리턴값이 없는 메소드
    // gas 가 없으면 return; 으로 메소드를 조기 종료
    //System.out.println("멈춥니다.(gas잔량:" + gas + ")");
    // gas 가 있으면 -1 감소
    //System.out.println("달립니다.(gas잔량:" + gas + ")");
    public void run(){
        while(true){
            if (gas == 0) {
                System.out.println("멈춥니다.(gas잔량:" + gas + ")");
                return;
            }
            gas--;
            System.out.println("달립니다.(gas잔량:" + gas + ")");
        }
    }
}
