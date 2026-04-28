package sub.check;

public class Run {
//    processOrder() 호출
//→ 3개 작업 제출
//→ get()으로 3개 끝날 때까지 대기
//→ processOrder() 끝남
//
//    processOrder2() 호출
//→ 다시 3개 작업 제출
//→ get()으로 3개 끝날 때까지 대기
//→ processOrder2() 끝남
//
//    그 다음에야 메인 종료 출력
    public static void main(String[] args) {

        OrderService service = new OrderService();

        System.out.println("주문 처리 시작");

        service.processOrder();
        service.processOrder2();
        service.shutdown();
        System.out.println("메인 종료 (비동기 실행 중)");
    }
}
