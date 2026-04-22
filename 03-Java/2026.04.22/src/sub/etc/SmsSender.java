package sub.etc;

public class SmsSender implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("[문자발송] : " + message);
    }
}
