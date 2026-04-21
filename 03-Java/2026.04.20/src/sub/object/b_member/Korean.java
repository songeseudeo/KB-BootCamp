package sub.object.b_member;

/* final-마지막의, 변경될수 없는
     final class : 상속불가, 후손 클래스 파생 못 함
     final method : 상속시 오버라이딩 하지 못하는 메소드
     final variable : 지역변수가 가진 초기값 수정 불가능
     final field : 필드가 가진 초기값 수정 불가능 ,선언과 동시에 초기화, 생성자에서 초기화 가능
     */

public class Korean {

    private final String nation = "대한민국";

    private final String ssn;

    private String name;

    public Korean(String name, String ssn){
        this.name = name;
        this.ssn = ssn; //생성자에서 초기화
    }

    public String getNation() {
        return nation;
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setSsn(String ssn) { //final이라 변경 불가능
//        this.ssn = ssn;
//    }

    @Override
    public String toString() {
        return "Korean{" +
                "nation='" + nation + '\'' +
                ", ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
