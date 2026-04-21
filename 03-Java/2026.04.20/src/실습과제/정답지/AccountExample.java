package com.kb.chap06n.makeclass.f_check.account;

public class AccountExample {
    public static void main(String[] args) {

        // 1. 홍길동 계좌 생성 (초기 잔고 없음)
        Account hong = new Account("홍길동");

        // 2. 김길동 계좌 생성 (초기 잔고 50000원)
        Account kim = new Account("김길동", 50000);

        // 3. 전체 계좌 수 출력
        System.out.println("전체 계좌 수: " + Account.getCount());

        // 4. 홍길동 계좌에 30000원 입금
        hong.deposit(30000);

        // 5. 홍길동 계좌에 10000원 출금
        hong.withdraw(10000);

        // 6. 홍길동 계좌에 50000원 출금 시도 (잔고 부족 확인)
        hong.withdraw(50000);

        // 7. 홍길동 계좌에 -1000원 입금 시도 (유효성 검사 확인)
        hong.deposit(-1000);

        // 8. 홍길동, 김길동 계좌 정보 출력 (toString() 자동 호출)
        System.out.println(hong);
        System.out.println(kim);

        // 9. 전체 계좌 잔고 합계 출력
        System.out.println("전체 잔고 합계: " + Account.getTotalBalance() + "원");
    }
}