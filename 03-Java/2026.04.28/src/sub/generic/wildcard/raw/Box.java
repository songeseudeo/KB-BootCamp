package sub.generic.wildcard.raw;

public class Box <T> {
    public  T content;

    //두 box 안에 들어있는 값이 같은지 비교하는 메서드
    public boolean compare(Box<T> other){
        return content.equals(other.content);
    }
}
