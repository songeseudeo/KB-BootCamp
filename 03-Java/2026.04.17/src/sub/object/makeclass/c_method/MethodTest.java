package sub.object.makeclass.c_method;

public class MethodTest {

    public void methodA(){
        System.out.println("methodA 시작 ");
        methodB();
        System.out.println("methodA 종료 ");
    }
    private void methodB(){
        System.out.println("methodB 시작");
        int rs = methodC(100);

        System.out.println("methodC 반환값" +rs);
        System.out.println("methodB 종료");
    }

    private int methodC(int num) {
        System.out.println("methodC 시작" +num);
        return num + 100;
    }
}
