package sub.thread.sync;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Count {
    private int count;

    public void increament(){
        System.out.println(Thread.currentThread().getName());
        count++;
    }
}
