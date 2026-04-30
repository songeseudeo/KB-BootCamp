package sub.stream.user;

// DB에 저장되는 객체 (테이블과 매핑)
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;     // 응답 DTO에는 포함하지 않음
    private boolean active;
    private String role;
    private LocalDateTime createdAt;

    // 요청 DTO -> Entity 변환
    public static User from(UserCreateRequest request, Long id) {
        return User.builder()
                .id(id)
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .active(true)
                .role("USER")
                .createdAt(LocalDateTime.now())
                .build();
    }
}