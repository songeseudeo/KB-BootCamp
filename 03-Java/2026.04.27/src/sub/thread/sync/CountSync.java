package sub.thread.sync;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CountSync {
    private int count;

    public synchronized void increament(){
        count++;
    }
}
