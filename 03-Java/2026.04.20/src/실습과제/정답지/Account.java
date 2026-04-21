package com.kb.chap06n.makeclass.f_check.account;

public class Account {

    private String owner;
    private long   balance;
    private String accountNumber;
    private static int  count        = 0;
    private static long totalBalance = 0;

    // 생성자 1 - 소유자 이름만 받는 생성자
    public Account(String owner) {
        this.owner         = owner;
        this.balance       = 0;
        this.accountNumber = "ACC-" + (++count);
    }

    // 생성자 2 - 소유자 이름 + 초기 잔고를 받는 생성자 (this() 활용)
    public Account(String owner, long balance) {
        this(owner);                        // 생성자 1 에게 위임 (accountNumber, count 처리)
        if (balance > 0) {
            this.balance  = balance;
            totalBalance += balance;
        }
        // 0 이하이면 balance 는 생성자 1 에서 이미 0 으로 초기화되어 있으므로 그대로 둔다
    }

    // deposit() - 입금
    public void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("입금 금액은 0보다 커야 합니다.");
            return;
        }
        balance      += amount;
        totalBalance += amount;
        System.out.println("[입금] " + amount + "원 입금. 잔고: " + balance + "원");
    }

    // withdraw() - 출금
    public void withdraw(long amount) {
        if (amount <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
            return;
        }
        if (balance < amount) {
            System.out.println("잔고 부족. 현재 잔고: " + balance + "원");
            return;
        }
        balance      -= amount;
        totalBalance -= amount;
        System.out.println("[출금] " + amount + "원 출금. 잔고: " + balance + "원");
    }



    // static getCount() - 전체 계좌 수 반환
    public static int getCount() { return count; }

    // static getTotalBalance() - 전체 계좌 잔고 합계 반환
    public static long getTotalBalance() { return totalBalance; }

    // getter
    public String getOwner()         { return owner; }
    public long   getBalance()       { return balance; }
    public String getAccountNumber() { return accountNumber; }


    // toString() - 계좌 정보 출력
    @Override
    public String toString() {
        return "====================\n"
                + "계좌번호: " + accountNumber + "\n"
                + "소유자:   " + owner        + "\n"
                + "잔고:     " + balance      + "원\n"
                + "====================";
    }
}