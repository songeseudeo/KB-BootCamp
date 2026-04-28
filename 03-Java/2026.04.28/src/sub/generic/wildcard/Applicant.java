package sub.generic.wildcard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Applicant<T> {
    private T Kind;
}
