package sub.generic.wildcard.gclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product <K, M> {
    private K kind; //K 타입 필드
    private M model; //M 타입 필드


}
