package sub.stream.user;

import sub.stream.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public void initData() {
        users.add(User.builder()
                .id(1L)
                .name("홍길동")
                .email("hong@test.com")
                .password("1111")
                .active(true)
                .role("USER")
                .createdAt(java.time.LocalDateTime.now())
                .build());

        users.add(User.builder()
                .id(2L)
                .name("신용권")
                .email("shin@test.com")
                .password("2222")
                .active(false)
                .role("USER")
                .createdAt(java.time.LocalDateTime.now())
                .build());

        users.add(User.builder()
                .id(3L)
                .name("감자바")
                .email("gam@test.com")
                .password("3333")
                .active(true)
                .role("ADMIN")
                .createdAt(java.time.LocalDateTime.now())
                .build());
    }

    // 문제 1. 회원 가입 기능을 구현하세요.
    // - UserCreateRequest를 받아 User Entity로 변환하세요.
    // - 새로운 id를 생성해서 저장하세요.
    // - 저장 후 생성된 회원 id를 반환하세요.
    // 웹 요청 DTO -> Entity 저장
    public Long save(UserCreateRequest request) {
        Long newId = (long)(users.size() + 1);

        User user = User.from(request, newId);
        users.add(user);

        return user.getId();
    }


    // 문제 2. 회원 단건 조회 기능을 구현하세요.
    // - id와 일치하는 사용자를 찾으세요.
    // - 찾은 User를 UserDto로 변환해서 반환하세요.
    // - 사용자가 없으면 IllegalArgumentException을 발생시키세요.
    public UserDto findOne(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(UserDto::from)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없음"));
    }


    // 문제 3. 전체 회원 조회 기능을 구현하세요.
    // - 저장된 모든 User를 조회하세요.
    // - 각 User를 UserDto로 변환하세요.
    // - List<UserDto> 형태로 반환하세요.
    public List<UserDto> findAll() {
        return users.stream()
                //.map(UserDto::from).toList();
                .map(user -> UserDto.from(user))
                .toList();
    }


    // 문제 4. 활성 사용자 조회 기능을 구현하세요.
    // - active 값이 true인 사용자만 필터링하세요.
    // - 필터링된 User를 UserDto로 변환하세요.
    // - List<UserDto> 형태로 반환하세요.
    public List<UserDto> findActiveUsers() {
        return users.stream()
                .filter(user -> user.isActive())
                .map(user -> UserDto.from(user))
                .toList();
    }

}