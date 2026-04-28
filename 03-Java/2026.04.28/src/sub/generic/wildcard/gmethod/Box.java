package sub.generic.wildcard.gmethod;

public class Box<T> {
    private T t;

    public T get() {return t;}
    public void set(T t){
        this.t = t;
    }

    //매서드 제네릭
    public <U> void print(U u){
        System.out.println(u);
    }
}
