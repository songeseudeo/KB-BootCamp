package sub.stream.user;

public class ControllerTest {
    public static void main(String[] args) {

        UserService userService = new UserService();
        userService.initData();

        //전체조회
        System.out.println("===== 전체 조회 =====");
        userService.findAll().forEach(System.out::println);

        System.out.println("===== 활성사용자 조회 =====");
        userService.findActiveUsers()
                .forEach(System.out::println);

        System.out.println("===== 단건 조회 =====");
        UserDto userDto = userService.findOne(1L);
        System.out.println(userDto);

        System.out.println("===== 저장 =====");

        UserCreateRequest request = new UserCreateRequest("제니", "test@test.com", "1234");

        userService.save(request);

        Long saveId = userService.save(request);
        System.out.println("저장된 ID" + saveId);

        System.out.println("===== 전체 조회 =====");
        userService.findAll().forEach(System.out::println);

    }
}
