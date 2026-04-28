package sub.generic.wildcard.inter;

public interface Rentable <P>{
    P rent(); //P 타입을 반환 - 구현클래스에서 실제 타입이 결정됨
}
