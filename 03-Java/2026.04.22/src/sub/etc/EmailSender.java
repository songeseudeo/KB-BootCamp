package sub.etc;

public class EmailSender implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("[이메일 발송] : " + message);
    }
}
