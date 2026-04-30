package sub.stream.user;
//요청(request) 전용 DTO - 클라이언트요청 입력용 객체
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateRequest {

    private String name;
    private String email;
    private String password;
}