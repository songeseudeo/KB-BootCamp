package sub.etc;

public class Run {
    public static void main(String[] args) {

        BadService badService = new BadService();
        badService.send("회원가입을 축하합니다 ");


        // 이메일로 발송
        NotificationService service = new NotificationService(new EmailSender());
        service.send("회원가입을 축하합니다");

        // 카카오 발송
        service = new NotificationService(new KaKaoSender());
        service.send("회원가입을 축하합니다");
        // sms 발송
        service = new NotificationService(new SmsSender());
        service.send("회원가입을 축하합니다");
    }
}
