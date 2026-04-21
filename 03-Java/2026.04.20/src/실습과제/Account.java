package 실습과제;

// ===============================
// Chapter 06. 실습 과제 - 은행 계좌 만들기
// ===============================
//
// 지금까지 배운 클래스, 필드, 생성자, 메소드, static 개념을 활용해서
// 간단한 은행 계좌 프로그램을 완성한다.
//
// ===============================
// 1단계. Account 클래스 만들기
// ===============================
//
// [필드 선언 조건]
//
//   private String owner               → 계좌 소유자 이름
//   private long   balance             → 잔고 (원 단위)
//   private String accountNumber       → 계좌번호
//   private static int  count          → 생성된 전체 계좌 수
//   private static long totalBalance   → 전체 계좌 잔고 합계
//
// ===============================
// [생성자 선언 조건]
//
//   생성자 1 - 소유자 이름만 받는 생성자
//     - owner 를 매개변수로 받아 초기화한다.
//     - balance 는 0 으로 초기화한다.
//     - accountNumber 는 "ACC-" + 생성 순서 번호로 자동 생성한다.
//       힌트) accountNumber = "ACC-" + (++count);
//       예) 첫 번째 생성 → "ACC-1", 두 번째 생성 → "ACC-2"
//
//   생성자 2 - 소유자 이름 + 초기 잔고를 받는 생성자
//     - owner, balance 를 매개변수로 받는다.
//     - accountNumber 자동 생성 규칙과 count 증가는 생성자 1과 동일하다.
//     - this() 를 활용해서 중복 코드를 줄인다.
//     - 초기 잔고가 0 이하이면 0 으로 설정한다.
//     - 초기 잔고가 0 보다 크면 totalBalance 에도 더한다.
//
// ===============================
// [메소드 선언 조건]
//
//   deposit(long amount) - 입금
//     - 입금 금액이 0 이하이면 "입금 금액은 0보다 커야 합니다." 출력 후 종료
//     - 정상 입금 시 balance 와 totalBalance 에 더하고 아래 형식으로 출력
//       "[입금] 30000원 입금. 잔고: 30000원"
//
//   withdraw(long amount) - 출금
//     - 출금 금액이 0 이하이면 "출금 금액은 0보다 커야 합니다." 출력 후 종료
//     - 잔고 부족 시 "잔고 부족. 현재 잔고: 20000원" 출력 후 종료
//     - 정상 출금 시 balance 와 totalBalance 에서 빼고 아래 형식으로 출력
//       "[출금] 10000원 출금. 잔고: 20000원"
//
//   getInfo() or toString() - 계좌 정보 출력
//
//   static getCount() - 전체 계좌 수 반환
//     - count 값을 반환한다.
//     - static 메소드로 선언한다.
//
//   static getTotalBalance() - 전체 계좌 잔고 합계 반환
//     - totalBalance 값을 반환한다.
//     - static 메소드로 선언한다.
//
//   getter
//     - getOwner(), getBalance(), getAccountNumber() 를 선언한다.
//
// ===============================
public class Account {

    // 필드를 선언한다.
    private String owner;
    private long balance;
    private String accountNumber;
    private static int count = 0;
    private static long totalBalance = 0;

    // 생성자 1 - 소유자 이름만 받는 생성자
    public Account(String owner) {
        this.owner         = owner;
        this.balance       = 0;
        this.accountNumber = "ACC-" + (++count);  // 객체 생성 순서대로 자동 번호 부여
    }

    // 생성자 2 - 소유자 이름 + 초기 잔고를 받는 생성자 (this() 활용)
    public Account(String owner, long balance) {
        this(owner); // 생성자 1 호출
        if (balance <= 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
            totalBalance += balance;
        }
    }

    // deposit() - 입금
    public void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("입금 금액은 0보다 커야 합니다.");
            return;
        }
        balance += amount;
        totalBalance += amount;
        System.out.println("[입금] " + amount + "원 입금. 잔고: " + balance + "원");
    }

    // withdraw() - 출금
    public void withdraw(long amount) {
        if (amount <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
            return;
        }
        if (amount > balance) {
            System.out.println("잔고 부족. 현재 잔고: " + balance + "원");
            return;
        }
        balance -= amount;
        totalBalance -= amount;
        System.out.println("[출금] " + amount + "원 출금. 잔고: " + balance + "원");
    }

    // getInfo() or toString() - 계좌 정보 출력
    // static getCount() - 전체 계좌 수 반환
    public static int getCount() {
        return count;
    }

    // static getTotalBalance() - 전체 계좌 잔고 합계 반환
    public static long getTotalBalance() {
        return totalBalance;
    }

    // getter - getOwner(), getBalance(), getAccountNumber()
    public String getOwner() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

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