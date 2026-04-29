package sub.lambda;

import sub.conreference.Member;
import sub.methodreference.method.Comparable;

public class Person {

    public void workAction(Workable workable) {
        workable.work();
    }

    public void speakAction(Speakable speakable) {
        speakable.speak("안녕하세요");
    }

    public void calcAction(Calculable2 calculable2) {
        double result = calculable2.calculate(10, 4);
        System.out.println(result);
    }

    public void ordering(Comparable comp1) {

    }
}