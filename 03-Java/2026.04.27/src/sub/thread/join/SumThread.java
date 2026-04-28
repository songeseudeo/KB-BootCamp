package sub.thread.join;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class SumThread extends Thread {

    private long sum;

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}