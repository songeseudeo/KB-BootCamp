package sub.stream.user;

//데이터 전달용 객체 (레이어간 전달 controller <-> service <-> dao)
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class UserDto {

    private Long userId;
    private String username;
    private String email;
    private boolean active;
    private String role;

    // Entity -> DTO 변환
    public static UserDto from(User user) {
        return UserDto.builder()
                .userId(user.getId())
                .username(user.getName())
                .email(user.getEmail())
                .active(user.isActive())
                .role(user.getRole())
                .build();
    }
}