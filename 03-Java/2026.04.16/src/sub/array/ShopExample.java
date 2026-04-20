package sub.array;

public class ShopExample {
    public static void main(String[] args) {

        Role loginUser = Role.USER;

        System.out.println(loginUser);
        String access = switch(loginUser){
            case ADMIN -> "회원관리, 상품관리";
            case USER -> "상품 조회, 주문";
            case GUEST -> "상품조회만";
        };
        System.out.println(access);

        // OrderStatus
        //상태값에 따라 여러 메세지를 출력하도록 구현
        //주문이 접수되었습니다, 결제가 완료되었습니다, 배송중입니다, 배송이 완료되었습니다, 주문이 취소되었습니다
        OrderStatus status = OrderStatus.SHIPPING;

        String message = switch (status) {
            case ORDERED -> "주문이 접수되었습니다";
            case PAID -> "결제가 완료되었습니다";
            case SHIPPING -> "배송중입니다";
            case DELIVERED -> "배송이 완료되었습니다";
            case CANCELLED -> "주문이 취소되었습니다";
        };
        System.out.println(message);

        /*
         * 취소 가능 조건
         * - GUEST 는 주문 자체가 불가능하다 ->System.out.println("로그인이 필요한 서비스입니다.");
         * - USER 는 ORDERED, PAID 상태일 때만 취소 가능하다   그이외 상태틑 배송중이어서 취소가 불가능하다
         *      System.out.println("주문이 취소되었습니다.");
                System.out.println("변경된 주문 상태 : " + status);
         *
         * - ADMIN 은 어떤 상태든 강제 취소 가능하다  - >    System.out.println("관리자 권한으로 강제 취소되었습니다.");
                                                        System.out.println("변경된 주문 상태 : " + status);
         */
        System.out.println("\n--- 주문 취소 시도 ---");

        if (loginUser == Role.GUEST) {
            System.out.println("로그인이 필요한 서비스입니다.");
        } else if (loginUser == Role.USER) {
            if (status == OrderStatus.ORDERED || status == OrderStatus.PAID) {
                status = OrderStatus.CANCELLED;
                System.out.println("주문이 취소되었습니다.");
                System.out.println("변경된 주문 상태 : " + status);
            } else {
                System.out.println("배송중이어서 취소가 불가능합니다.");
            }
        } else if (loginUser == Role.ADMIN) {
            status = OrderStatus.CANCELLED;
            System.out.println("관리자 권한으로 강제 취소되었습니다.");
            System.out.println("변경된 주문 상태 : " + status);
        }
    }
}
