package sub.etc;

public class NotificationService {
    // 인터페이스 타입으로 선언해서 어떤 구현체든 받을 수 있도록 구현,
    private final Notifier notifier;

    // 생성자로 Notifier 구현체를  외부에서 받아서 처리  -> 의존성 주입  (DI) // 생성자 의존성 주입
    public NotificationService(Notifier notifier){
        this.notifier = notifier;
    }

    public void send (String message){
        notifier.send(message); // 어떤 구현체든 동일 하게 호출
    }

}
