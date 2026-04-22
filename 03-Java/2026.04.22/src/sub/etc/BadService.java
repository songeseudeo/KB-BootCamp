package sub.etc;

public class BadService {
        // 이메일 -> 문자 나 카카오 발송 을 하려고 하면  sms, kakao 로 다 변경 해줘야함
        // 비지니스 로직 (send ) 와 발송방식이 강하게 결합 되어있다
    private  BadEmailSender emailSender = new BadEmailSender();
    public void send(String message) {
        emailSender.send(message);
    }
}
