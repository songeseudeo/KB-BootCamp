package objeck;

public class Day {
    String doing;
    int time;
    String location;

    public Day(String doing, int time, String location) {
        //this는 이 클래스로 만든 객체
        this.doing = doing;
        this.time = time;
        this.location = location;
    } //생성자

    //toString()을 수정해서 재정의하자.


    @Override
    public String toString() {
        return "Day{" +
                "doing='" + doing + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }
} //클래스
