package sub.object.makeclass.a_field;

public class Phone {


    /* 접근제한자
     * 클래스 혹은 클래스의 멤버에 참조연산자로 접근할 수 있는 범위를 제한하기 위한 키워드이다.
     * 1. public : 모든 패키지에 접근 허용.
     * 2. protected : 동일 패키지에 접근 허용. 단, 상속관계에 있는 경우 다른 패키지에서도 접근 가능
     * 3. default : 동일 패키지에서만 접근 허용. (작성하지 않는 것이 default)
     * 4. private : 해당 클래스 내부에서만 접근 허용.
     *
     * 위의 네 가지 접근제한자는 클래스의 멤버(필드, 메소드)에 모두 사용 가능하다.
     * 단, 클래스 선언 시 사용하는 접근제한자는 public과 default만 사용 가능하다.
     * */


    // 필드부
    /* 1. 필드 : 객체의 속성을 저장하기위한 공간
     *
     *
     * 멤버변수 == 인스턴스변수
     * <표현법>
     * 접근제한자 [예약어] 자료형 변수명;
     *
     * 필드부에 접근제한자는 private 으로 하는게 객체지향설계원칙 중 하나이다. --> 캡슐화
     *
     * 객체의 필드는 자바가 자동으로 초기화해준다.
     */
    // 공통적 속성: 사이즈 , 스피커


    private int size;    //0    // 크기
    private String speaker; //null // 스피커 정보
    private String brand; //null   // 제조사(브랜드)



    //기본생성자는 정의 하지 않아도 동작, 단 매개변수 있는 생성자가 없는경우에 만 !!
    //생성부
    /*
     * 2. 생성자
     * - 객체를 생성하기 위한 일종의 메소드
     *
     * <표현법>
     * 접근제한자 클래스명([매개변수]){
     *
     * }
     */



    // 메소드부
    /*
     * 3. 메소드
     * -기능을 구현하는 부분
     *
     * <표현법>
     * [접근제한자] [예약어] 반환형 메소드명 ([자료형 매개변수명]){
     *       //기능구현
     * }
     *
     *
     * */
    /*
     * 설정자(setter) 작성 규칙
     * : 필드값을 변경할 목적의 매개변수를 변경하려는 필드와 같은 자료형으로 선언하고
     *   호출 당시 전달되는 매개변수의 값을 이용하여 필드의 값을 변경한다.
     *
     * [표현식]
     * public void set필드명(매개변수) {
     *     필드 = 매개변수;
     * }
     *
     * [작성예시]
     * public void setName(String name) {
     *     this.name = name;
     * }
     *
     * 접근자(getter) 작성 규칙
     * : 필드의 값을 반환받을 목적의 메소드 집함을 의미한다.
     *   각 접근자는 하나의 필드에만 접근하도록 한다.
     *   필드에 접근해서 기록된 값을 return을 이용하여 반환하며, 이 때 반환타입은 반환하려는 값의 자료형과 일치시킨다.
     *
     * [표현식]
     * public 반환형 get필드명() {
     *     return 반환값;
     * }
     *
     * [작성예시]
     * public String getName() {
     *     return this.name;
     * }
     */

    public void setSize(int size) {

        if(size >= 0){ // this : 현재 메소드를 호출한 객체 자신을 가리키는 참조

            this.size = size;
        }else{
            System.out.println("양수를 입력해주세요 ");
        }
    }


    public int getSize() {

        return this.size;
    }


    public void setSpeaker(String speaker) {
        if (speaker == null || speaker.isEmpty()) {
            System.out.println("스피커 정보가 올바르지 않습니다.");
            return;
        }
        this.speaker = speaker;
    }


    public String getSpeaker() {
        return this.speaker;
    }


    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            System.out.println("브랜드를 입력해주세요.");
            return;
        }
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }


}
